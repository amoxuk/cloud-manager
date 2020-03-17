
package com.amoxuk.service;

import com.amoxuk.entity.Cloud;
import com.amoxuk.mapper.CloudMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CloudService {


    @Autowired
    private CloudMapper mapper;

    private CloudService(CloudMapper mapper) {
        this.mapper = mapper;
    }

    public List<Cloud> selectAll() {
        return mapper.select();
    }

    public List<Cloud> select(String bu, boolean lsf, String ip, boolean core, String name) {
        return mapper.selectSearch(bu, lsf, ip, core, name);
    }
}
