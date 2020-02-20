package com.ningmeng.manage_course.dao;

import com.ningmeng.framework.domain.system.SysDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface SysDicthinaryRepository extends JpaRepository<SysDictionary,String> {

    SysDictionary findByDType(String type);

}
