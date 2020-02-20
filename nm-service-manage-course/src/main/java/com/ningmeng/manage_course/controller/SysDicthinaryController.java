package com.ningmeng.manage_course.controller;

import com.ningmeng.api.course.SysDicthinaryControllerApi;
import com.ningmeng.framework.domain.system.SysDictionary;
import com.ningmeng.manage_course.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys")
public class SysDicthinaryController implements SysDicthinaryControllerApi {

    @Resource
    private CourseService courseService;


    @Override
    @GetMapping("/{type}")
    public SysDictionary getByType(@PathVariable("type") String type) {
        return courseService.getByType(type);
    }
}
