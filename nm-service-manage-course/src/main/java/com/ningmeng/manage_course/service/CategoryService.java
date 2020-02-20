package com.ningmeng.manage_course.service;

import com.ningmeng.framework.domain.course.CourseBase;
import com.ningmeng.framework.domain.course.CourseMarket;
import com.ningmeng.framework.domain.course.ext.CategoryNode;
import com.ningmeng.framework.exception.ExceptionCast;
import com.ningmeng.framework.model.response.CommonCode;
import com.ningmeng.framework.model.response.ResponseResult;
import com.ningmeng.manage_course.dao.CategoryMapper;
import com.ningmeng.manage_course.dao.CourseBaseRepository;
import com.ningmeng.manage_course.dao.CourseMarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CourseBaseRepository courseBaseRepository;

    @Resource
    private CourseMarketRepository courseMarketRepository;


    @Transactional
    public CategoryNode findList() {
        return categoryMapper.findList();
    }

    @Transactional
    public CourseBase getCourseBaseById(String courseId) {
        if(StringUtils.isEmpty(courseId)){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return courseBaseRepository.findById(courseId).get();
    }

    public ResponseResult updateCourseBase(String id, CourseBase courseBase) {
        CourseBase base = courseBaseRepository.getOne(id);
        if(base == null){
            courseBase.setId(id);
        }
        courseBaseRepository.saveAndFlush(courseBase);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Transactional
    public CourseMarket getCourseMarketById(String courseId) {
        if(StringUtils.isEmpty(courseId)){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return courseMarketRepository.getOne(courseId);
    }

    public ResponseResult updateCourseMarket(String id, CourseMarket courseMarket) {
        CourseMarket market = courseMarketRepository.getOne(id);
        if(market == null){
            market.setId(id);
        }
        courseMarketRepository.saveAndFlush(market);
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
