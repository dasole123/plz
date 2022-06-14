package com.recipe.plz.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.plz.dto.ResponseDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class RestLoginFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setResult(false);
        responseDto.setErr_msg("아이디와 패스워드를 다시 확인해주세요");
        response.setStatus(HttpServletResponse.SC_OK);
        OutputStream out = response.getOutputStream();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, responseDto);
        out.flush();
    }
}