package com.ilovesshan.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

    /**
     * 响应给客户端数据工具类(JSON格式)
     *
     * @param response     响应对象
     * @param responseData 响应数据
     * @throws IOException
     */
    public static void write(HttpServletResponse response, Object responseData) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        String responseJson = new ObjectMapper().writeValueAsString(responseData);
        response.getWriter().print(responseJson);
        response.getWriter().flush();
    }


    /**
     * 响应给客户端数据工具类(JSON格式)
     *
     * @param response     响应对象
     * @param status       Http状态码
     * @param responseData 响应数据
     * @throws IOException
     */
    public static void write(HttpServletResponse response, int status, Object responseData) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(status);
        String responseJson = new ObjectMapper().writeValueAsString(responseData);
        response.getWriter().print(responseJson);
        response.getWriter().flush();
    }

}