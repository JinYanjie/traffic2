package com.cnw.traffic.controller;

import com.cnw.traffic.model.Student;
import com.cnw.traffic.model.Traffic;
import com.cnw.traffic.service.TrafficService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/traffic")
public class TrafficController {
    @Autowired
    private TrafficService userService;

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize){
        PageInfo<Traffic> allTpcs = userService.findAllTpc(pageNum, pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", allTpcs.getList());
        resultMap.put("total", allTpcs.getTotal());
        resultMap.put("success", true);
        return resultMap;
    }
    @ResponseBody
    @GetMapping("/listTpc")
    public Object listTpc(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize){
        PageInfo<Traffic> tpcList = userService.findAllTpc(pageNum, pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", tpcList.getList());
        resultMap.put("total", tpcList.getTotal());
        resultMap.put("success", true);
        return resultMap;
    }

    @ResponseBody
    @GetMapping("/listTxc")
    public Object listTxc(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize){
        PageInfo<Traffic> tpcList = userService.findAllTxc(pageNum, pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", tpcList.getList());
        resultMap.put("total", tpcList.getTotal());
        resultMap.put("success", true);
        return resultMap;
    }
    @ResponseBody
    @GetMapping("/listScrc")
    public Object listScrc(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize){
        PageInfo<Traffic> tpcList = userService.findAllScrc(pageNum, pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", tpcList.getList());
        resultMap.put("total", tpcList.getTotal());
        resultMap.put("success", true);
        return resultMap;
    }

    @ResponseBody
    @GetMapping("/testData")
    public Object getTestData(
            @RequestParam(name= "type",required = false,defaultValue = "1") String type){
        Map<String,Object> map=new HashedMap();
        if ("1".equals(type)){
            map.put("resultID",0);
            map.put("action","get");
            map.put("message","success");
            map.put("isSuccess",true);
            map.put("data",new Student("lihua",23));
        }else {
            map.put("resultID",2);
            map.put("action","get");
            map.put("message","fail");
            map.put("isSuccess",false);
            List<Student> list=new ArrayList<>();
            list.add(new Student("lihua",23));
            list.add(new Student("xiaoming",25));
            map.put("data",list);
        }
        return map;
    }
}
