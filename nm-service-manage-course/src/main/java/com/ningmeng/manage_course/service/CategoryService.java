package com.ningmeng.manage_course.service;

import com.ningmeng.framework.domain.course.CourseBase;
import com.ningmeng.framework.domain.course.ext.CategoryNode;
import com.ningmeng.framework.model.response.CommonCode;
import com.ningmeng.framework.model.response.ResponseResult;
import com.ningmeng.manage_course.dao.CategoryMapper;
import com.ningmeng.manage_course.dao.CourseBaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CourseBaseRepository courseBaseRepository;


    @Transactional
    public CategoryNode findList() {
        return categoryMapper.findList();
    }

    @Transactional
    public CourseBase getCourseBaseById(String courseId) {
        return courseBaseRepository.findById(courseId).get();
    }

    public ResponseResult updateCourseBase(String id, CourseBase courseBase) {
        courseBase.setId(id);
        courseBaseRepository.saveAndFlush(courseBase);
        return new ResponseResult(CommonCode.SUCCESS);
    }






}
