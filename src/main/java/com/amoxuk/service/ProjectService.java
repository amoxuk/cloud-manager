
package com.amoxuk.service;

import com.amoxuk.entity.Project;
import com.amoxuk.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {


    @Autowired
    private ProjectMapper mapper;

    private ProjectService(ProjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Project> selectAll() {
        return mapper.select();
    }
}
