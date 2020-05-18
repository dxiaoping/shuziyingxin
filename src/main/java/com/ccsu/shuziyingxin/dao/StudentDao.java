package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    Student queryByStuNo(String stuNo);
}
