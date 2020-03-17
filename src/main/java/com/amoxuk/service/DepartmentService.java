
package com.amoxuk.service;

import com.amoxuk.entity.Department;
import com.amoxuk.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {


    @Autowired
    private DepartmentMapper mapper;

    private DepartmentService(DepartmentMapper mapper) {
        this.mapper = mapper;
    }

    public List<Department> selectAll() {
        return mapper.select();
    }
}
