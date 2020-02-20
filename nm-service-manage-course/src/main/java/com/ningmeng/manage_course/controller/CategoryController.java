package com.ningmeng.manage_course.controller;

import com.ningmeng.api.course.CategoryControllerApi;
import com.ningmeng.framework.domain.course.CourseBase;
import com.ningmeng.framework.domain.course.CourseMarket;
import com.ningmeng.framework.domain.course.ext.CategoryNode;
import com.ningmeng.framework.model.response.ResponseResult;
import com.ningmeng.manage_course.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cate")
public class CategoryController implements CategoryControllerApi {

    @Resource
    private CategoryService categoryService;

    @Override
    public CategoryNode findList() {
        return categoryService.findList();
    }

    @Override
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException {
        return categoryService.getCourseBaseById(courseId);
    }

    @Override
    public ResponseResult updateCourseBase(String id, CourseBase courseBase) {
        return categoryService.updateCourseBase(id,courseBase);
    }

    @Override
    public CourseMarket getCourseMarketById(String courseId) {
        return categoryService.getCourseMarketById(courseId);
    }

    @Override
    public ResponseResult updateCourseMarket(String id, CourseMarket courseMarket) {
        return categoryService.updateCourseMarket(id,courseMarket);
    }
}
