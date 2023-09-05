package com.online.bookstore.demo.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN; // 403

        Map<String, Object> data = new HashMap<>();
        data.put(
                "timestamp",
                new Date()
        );
        data.put(
                "message",
                accessDeniedException.getMessage()
        );
        response.setStatus(httpStatus.value());
        response
                .getOutputStream()
                .println(
                        objectMapper.writeValueAsString(data)
                );
    }
}
