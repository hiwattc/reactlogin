package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request, HttpServletRequest servletRequest) {
        // 실제로는 여기에서 아이디와 비밀번호를 확인하는 로직을 구현해야 합니다.
        // 예시로 admin/admin으로 로그인할 때 성공으로 가정합니다.

        logger.info("Received login request with username: {}", request.getUsername());
        HttpSession session = servletRequest.getSession();
        try{
            String username = (String) session.getAttribute("username");
            logger.info("Already Login? ::"+username);
            if("admin".equals(username)){
                return "OK";
            }
        }catch(Exception e){
            logger.info("Not logined yet");
        }


        if ("admin".equals(request.getUsername()) && "admin".equals(request.getPassword())) {
            // 로그인 성공 시 세션에 사용자 아이디 저장
            session.setAttribute("username", request.getUsername());
            logger.info("Login Successful!");
            return "OK";
        } else {
            logger.info("Invalid Credentials");
            return "ERR";
        }
    }
}



