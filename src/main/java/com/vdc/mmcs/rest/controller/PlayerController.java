package com.vdc.mmcs.rest.controller;

import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.common.util.CryptUtil;
import com.vdc.mmcs.rest.service.ConfService;
import com.vdc.mmcs.rest.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.MapUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final ConfService confService;

    String _CRYPT_KEY_ = "vdc7200qwert1234";

    @RequestMapping("/rec/player")
    public ModelAndView SinglePlayer(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception {
        Map<String, Object> Result = new HashMap<>();

        Map<String, Object> infoMap = playerService.get_rec_file(commandMap.getMap());

        if (!MapUtils.isEmpty(infoMap)) {
            String filePath = infoMap.get("conference_record_path").toString();
            File encFile = new File(filePath);

            Result.put("ownr_user_id", infoMap.get("ownr_user_id").toString());

            if (encFile.exists()) {
                byte[] encFileData = CryptUtil.decrypt(_CRYPT_KEY_, encFile);
                Result.put("base64File", Base64.getEncoder().encodeToString(encFileData));
                Result.put("orgFilName", encFile.getName());
                Result.put("success", true);

                // 청취 이력 Insert
                Map<String, Object> rec_histMap = new HashMap<>();
                rec_histMap.put("conference_uuid", infoMap.get("conference_uuid").toString());
                rec_histMap.put("hist_type", 0); // 0 : 청취, 1 : 다운로드
                confService.hist_rec_Add(rec_histMap, request);
            } else {
                Result.put("base64File", "");
                Result.put("orgFilName", "");
                Result.put("success", false);
                Result.put("msg", "[Not Exists] " + filePath);
            }
        } else {
            Result.put("ownr_user_id", "");
            Result.put("base64File", "");
            Result.put("orgFilName", "");
            Result.put("success", false);
            Result.put("msg", "[Data Empty] cdr_conference");
        }

        Result.put("conference_uuid", commandMap.getMap().get("conference_uuid"));
        Result.put("conn_user_id", session.getAttribute("user_id"));
        Result.put("auth_cd", session.getAttribute("auth_cd"));

        ModelAndView mv = new ModelAndView("view/player");
        mv.addObject("info", Result);
        return mv;
    }

    @RequestMapping("/rec/multi/player")
    public ModelAndView MultiPlayer_Page(CommandMap commandMap, HttpSession session) throws Exception {
        Map<String, Object> Result = new HashMap<>();
        List<Map<String, Object>> ListMap = playerService.get_rec_files(commandMap.getMap());

        int index = 0;
        for(Map<String, Object> infoMap : ListMap){
            String filePath = infoMap.get("conference_record_path").toString();
            File encFile = new File(filePath);

            if (encFile.exists()) {
                byte[] encFileData = CryptUtil.decrypt(_CRYPT_KEY_, encFile);
                if (index == 0) {
                    infoMap.put("base64File", Base64.getEncoder().encodeToString(encFileData));
                }
                else
                {
                    infoMap.put("base64File", "");
                }
                infoMap.put("orgFilName", encFile.getName());
                infoMap.put("success", true);
            } else {
                infoMap.put("base64File", "");
                infoMap.put("orgFilName", "");
                infoMap.put("success", false);
                infoMap.put("msg", "[Not Exists] " + filePath);
            }
            index++;
        }

        Result.put("conference_uuids", commandMap.getMap().get("conference_uuid"));
        Result.put("conn_user_id", session.getAttribute("user_id"));
        Result.put("auth_cd", session.getAttribute("auth_cd"));
        Result.put("playNum", ListMap.size());

        ModelAndView mv = new ModelAndView("view/players");
        mv.addObject("rows", ListMap);
        mv.addObject("info", Result);
        return mv;
    }

    @RequestMapping("/rec/multi/player/info")
    @ResponseBody
    public Map<String, Object> get_rec_base64(CommandMap commandMap, HttpServletRequest request) throws Exception {
        Map<String,Object> Map = new HashMap<>();
        Map<String,Object> Result = new HashMap<>();
        Map<String, Object> infoMap = playerService.get_rec_base64(commandMap.getMap());

        if (!MapUtils.isEmpty(infoMap)) {
            String filePath = infoMap.get("conference_record_path").toString();
            Result.put("ownr_user_id", infoMap.get("ownr_user_id").toString());

            File encFile = new File(filePath);

            if (encFile.exists()) {
                byte[] encFileData = CryptUtil.decrypt(_CRYPT_KEY_, encFile);
                Result.put("base64File", Base64.getEncoder().encodeToString(encFileData));
                Result.put("orgFilName", encFile.getName());
                Result.put("success", true);

                // 청취 이력 Insert
                Map<String, Object> rec_histMap = new HashMap<>();
                rec_histMap.put("conference_uuid", infoMap.get("conference_uuid").toString());
                rec_histMap.put("hist_type", 0); // 0 : 청취, 1 : 다운로드
                confService.hist_rec_Add(rec_histMap, request);
            } else {
                Result.put("base64File", "");
                Result.put("orgFilName", "");
                Result.put("success", false);
                Result.put("msg", "[Not Exists] " + filePath);
            }
        } else {
            Result.put("ownr_user_id", "");
            Result.put("base64File", "");
            Result.put("orgFilName", "");
            Result.put("success", false);
            Result.put("msg", "[Data Empty] cdr_conference");
        }

        Map.put("info", Result);
        return Map;
    }

    @RequestMapping("/rec/dn")
    public void download(CommandMap commandMap, HttpServletResponse response, HttpServletRequest request) throws Exception {

        List<Map<String, Object>> ListMap = playerService.get_rec_file_info(commandMap.getMap());

        for(Map<String, Object> infoMap : ListMap){
            String filePath = infoMap.get("conference_record_path").toString();
            File encFile = new File(filePath);

            if (encFile.exists()) {
                byte[] encFileData = CryptUtil.decrypt(_CRYPT_KEY_, encFile);

                response.setContentType("application/octet-stream");
                response.setContentLength(encFileData.length);
                response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(encFile.getName(),"UTF-8")+"\";");
                response.setHeader("Content-Transfer-Encoding", "binary");
                response.getOutputStream().write(encFileData);

                response.getOutputStream().flush();
                response.getOutputStream().close();

                //download history
                Map<String, Object> histmap = new HashMap<>();
                histmap.put("conference_uuid", commandMap.getMap().get("conference_uuid"));
                histmap.put("hist_type", 1);
                confService.hist_rec_Add(histmap, request);
            }
        }

    }
}
