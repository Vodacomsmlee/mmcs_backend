package com.vdc.mmcs.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@Component("file")
public class MultipartFileUpload {

    public Map<String,Object> parseInsertFileInfo(String filePath, Map<String,Object> map, HttpServletRequest request) throws Exception{
        //String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/";

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        MultipartFile multipartFile;
        String originalFileName;
        String originalFileExtension;
        String storedFileName;

        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        while(iterator.hasNext()) {
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if (!multipartFile.isEmpty()) {
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = getRandomString()+originalFileExtension; //저장될 파일명 변경

                file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);

                map.put("ORIGINAL_FILE_NAME", originalFileName);
                map.put("FILE_NAME", storedFileName);
                map.put("FILE_PATH", filePath);

            }
        }
        return map;
    }
    public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
