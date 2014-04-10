package com.bitcup.spring.controller;

import com.bitcup.spring.entity.User;
import com.bitcup.spring.entity.UserKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public UserKey login(@RequestBody User user, HttpServletResponse response) throws Exception {
        // simulate delay to test UI loader/spinner
        Thread.sleep(2000);
        logger.info("inside login - user: " + user);
        if (user.getUsername().equals("test") && user.getPassword().equals("test")) {
            return new UserKey("abc", "1234567890");
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return new UserKey();
    }
}
