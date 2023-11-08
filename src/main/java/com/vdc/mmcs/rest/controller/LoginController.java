package com.vdc.mmcs.rest.controller;

import com.vdc.mmcs.common.resolver.CommandMap;
import com.vdc.mmcs.configuration.WebSessionListener;
import com.vdc.mmcs.rest.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final WebSessionListener webSessionListener;

    @RequestMapping(value = "/login/proc")
    @ResponseBody
    public Map<String, Object> LoginCheck(CommandMap commandMap, HttpServletRequest request) throws Exception {
        Map<String, Object> Rst = new HashMap<>();
        Map<String, Object> LoginRst = loginService.account_login(commandMap.getMap());

        boolean success = false;
        String msg = "";

        if (LoginRst != null && !LoginRst.isEmpty()) {

            HttpSession session = request.getSession();
            if (!webSessionListener.isLoginUser(request, LoginRst.get("user_id").toString())) {
                session.setAttribute("user_id", URLDecoder.decode(LoginRst.get("user_id").toString(), "UTF-8"));
                session.setAttribute("user_nm", URLDecoder.decode(LoginRst.get("user_nm").toString(), "UTF-8"));
                session.setAttribute("dept_cd", URLDecoder.decode(LoginRst.get("dept_cd").toString(), "UTF-8"));
                session.setAttribute("auth_cd", URLDecoder.decode(LoginRst.get("auth_cd").toString(), "UTF-8"));

                webSessionListener.setSession(request, URLDecoder.decode(LoginRst.get("user_id").toString(), "UTF-8"));

                loginService.account_last_login(commandMap.getMap());

                success = true;
                msg = "login ok";
                Rst.put("token", session.getId());
                Rst.put("rst", LoginRst);

            } else {
                msg = "Duplicate login user";
            }
        }

        Rst.put("success", success);
        Rst.put("msg", msg);

        return Rst;
    }

    @RequestMapping(value="/logout")
    @ResponseBody
    public Map<String, Object>  LogOut(HttpSession session, HttpServletRequest request) {
        Map<String, Object> Rst = new HashMap<>();
        try {
            if(session.getAttribute("user_id") != null) {
                webSessionListener.removeSession(request);
            }
            Rst.put("success", true);
            Rst.put("msg", "log out");
        }catch (Exception e) {
            Rst.put("success", false);
            Rst.put("msg", e.getMessage());
        }

        return Rst;
    }
}
