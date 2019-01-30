package com.xuecheng.manage.controller;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/dictionary")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @GetMapping("/get/{type}")
    public List<SysDictionary> findByDType(@PathVariable("type") String type){
        return sysDictionaryService.findByDType(type);
    }
}
