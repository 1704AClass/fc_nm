package com.ningmeng.manage_course.controller;

import com.ningmeng.api.course.CourseControllerApi;
import com.ningmeng.framework.domain.course.Teachplan;
import com.ningmeng.framework.domain.course.ext.TeachplanNode;
import com.ningmeng.framework.model.response.ResponseResult;
import com.ningmeng.manage_course.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi {

    @Resource
    private CourseService courseService;

    //查询课程计划
    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(String courseId) {
        return courseService.findTeachplanList(courseId);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }
}
