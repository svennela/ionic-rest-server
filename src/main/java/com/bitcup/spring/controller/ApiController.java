package com.bitcup.spring.controller;

import com.bitcup.spring.entity.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = {"api"})
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping(value = {"/v1.0/foo/list"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Foo> getFooList(HttpServletResponse response) {
        logger.info("inside getFooList");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return Arrays.asList(new Foo("just a test"), new Foo("another test"));
    }
}
