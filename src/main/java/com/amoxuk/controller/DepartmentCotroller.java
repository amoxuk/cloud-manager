package com.amoxuk.controller;
/**
 * Created by Misty-Rain on 2019/5/26.
 */


import com.amoxuk.entity.Department;
import com.amoxuk.service.DepartmentService;
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
public class DepartmentCotroller {

    @Autowired
    private DepartmentService service;


    @ResponseBody
    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public List<Department> fetch() {
        List<Department> depts = service.selectAll();
        return depts;
    }

}
