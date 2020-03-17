package com.amoxuk.entity;

import lombok.Data;

@Data
public class Cloud {
    private long id;
    private String hostName;
    private String ipAddr;
    private String buId;
    private String deptId;
    private String projId;
    private boolean isLsf;
    private boolean isCore;
    private String macAddr;
    private double cpuSpec;
    private long cpuNum;
    private double memorySize;
    private long cabinetRankNum;
    private String cabinetRankStartPosition;
    private boolean enable;
    private java.sql.Timestamp createAt;
    private String createBy;
    private java.sql.Timestamp lastUpdateAt;
    private String lastUpdateBy;

    private Department department;
    private Department parentDepartment;
    private Project project;
}
