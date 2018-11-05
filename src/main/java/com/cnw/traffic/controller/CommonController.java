package com.cnw.traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注意：
 * thymeleaf + Spring Boot 开发环境运行正常，用jar运行时报错：
 * Error resolving template template might not exist or might not be accessible;
 * 返回路径不要用/开头
 */
@Controller
public class CommonController {

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/main", method = {RequestMethod.POST, RequestMethod.GET})
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/tpc", method = {RequestMethod.POST, RequestMethod.GET})
    public String tpc() {
        return "tpc";
    }

    @RequestMapping(value = "/txc", method = {RequestMethod.POST, RequestMethod.GET})
    public String txc() {
        return "txc";
    }

    @RequestMapping(value = "/scrc", method = {RequestMethod.POST, RequestMethod.GET})
    public String scrc() {
        return "scrc";
    }

    @RequestMapping(value = "/scrcStreaming", method = {RequestMethod.POST, RequestMethod.GET})
    public String scrcStreaming() {
        return "scrcStreaming";
    }

    @RequestMapping(value = "/tpcStreaming", method = {RequestMethod.POST, RequestMethod.GET})
    public String tpcStreaming() {
        return "tpcStreaming";
    }

    @RequestMapping(value = "/gis", method = {RequestMethod.POST, RequestMethod.GET})
    public String toGis() {
        return "gis";
    }
}
