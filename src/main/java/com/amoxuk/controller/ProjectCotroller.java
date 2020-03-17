package com.amoxuk.controller;
/**
 * Created by Misty-Rain on 2019/5/26.
 */


import com.amoxuk.entity.Project;
import com.amoxuk.global.Global;
import com.amoxuk.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
public class ProjectCotroller {

    @Autowired
    private ProjectService service;


    @ResponseBody
    @RequestMapping(value = "/proj",
            method = RequestMethod.GET,
            produces = Global.JSON_VALUE)
    public List<Project> fetch() {
        List<Project> projects = service.selectAll();
        return projects;
    }

}
