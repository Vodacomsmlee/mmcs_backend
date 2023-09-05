package com.vdc.mmcs.common.util;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ExcelView {

    //일반 다운로드
    public void download(HttpServletRequest request, HttpServletResponse response,
                         Map<String, Object> bean, String fileName, String templateFile)
            throws ParsePropertyException, InvalidFormatException, IOException {

        InputStream is = new ClassPathResource("/static/file_tpl/"+templateFile).getInputStream();
        XLSTransformer xls = new XLSTransformer();
        Workbook workbook = xls.transformXLS(is, bean);

        ContentDisposition contentDisposition = ContentDisposition.builder("attachment").filename(fileName+ ".xlsx", StandardCharsets.UTF_8).build();
        response.setHeader("Content-Disposition", contentDisposition.toString());


        OutputStream os = response.getOutputStream();
        workbook.write(os);

    }


}
