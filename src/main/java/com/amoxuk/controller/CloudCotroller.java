package com.amoxuk.controller;
/**
 * Created by Misty-Rain on 2019/5/26.
 */


import com.amoxuk.entity.Cloud;
import com.amoxuk.global.Global;
import com.amoxuk.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
public class CloudCotroller {

    @Autowired
    private CloudService service;


    @ResponseBody
    @RequestMapping(value = "/cloud",
            method = RequestMethod.GET,
            produces = Global.JSON_VALUE)
    public List<Cloud> fetch() {
        List<Cloud> clouds = service.selectAll();
        return clouds;
    }

    @ResponseBody
    @RequestMapping(value = "/cloud/search",
            method = RequestMethod.POST,
            produces = Global.JSON_VALUE)
    public List<Cloud> search(
            @RequestParam("bu") String bu,
            @RequestParam("lsf") boolean lsf,
            @RequestParam("ip") String ip,
            @RequestParam("core") boolean core,
            @RequestParam("name") String name
    ) {

        List<Cloud> clouds = service.select(bu, lsf, ip, core, name);
        return clouds;
    }

}
