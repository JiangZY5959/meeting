package com.caztc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJN
 */
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void writeJsonToResponse(HttpServletResponse response, Object data) throws IOException {
        String json = mapper.writeValueAsString(data);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
