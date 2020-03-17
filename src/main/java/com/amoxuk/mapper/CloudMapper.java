package com.amoxuk.mapper;

/**
 * Created by Misty-Rain on 2019/5/26.
 */


import com.amoxuk.entity.Cloud;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


@Mapper
public interface CloudMapper {

    //    为了解决对象属性和字段驼峰不一致的问题，我们可以使用映射注解@Results来指定映射关系。
//    @Results({
//            @Result(property = "userId", column = "USER_ID"),
//            @Result(property = "username", column = "USERNAME"),
//            @Result(property = "password", column = "PASSWORD"),
//            @Result(property = "mobileNum", column = "PHONE_NUM")
//    })

//    crud：
//    @Select
//    @Insert
//    @Update
//    @Delete


    /**
     * 延伸：无论什么方式,如果涉及多个参数,则必须加上@Param注解,否则无法使用EL表达式获取参数。
     */
//    @Select("select * from t_user where username like #{username} and password like #{password}")
//    User get(@Param("username") String username, @Param("password") String password);
    @Select("SELECT * FROM cloud")
//    @Results({
//            @Result(property = "hostName", column = "host_name"),
//            @Result(property = "ipAddr", column = "ip_addr"),
//            @Result(property = "buId", column = "bu_id"),
//            @Result(property = "deptId", column = "dept_id"),
//            @Result(property = "projId", column = "proj_id"),
//            @Result(property = "isLsf", column = "is_lsf"),
//            @Result(property = "isCore", column = "is_core"),
//            @Result(property = "macAddr", column = "mac_addr"),
//            @Result(property = "cpuSpec", column = "cpu_spec"),
//            @Result(property = "cpuNum", column = "cpu_num"),
//            @Result(property = "memorySize", column = "memory_size"),
//            @Result(property = "cabinetRankNum", column = "cabinet_rank_num"),
//            @Result(property = "cabinetRankStartPosition", column = "cabinet_rank_start_position"),
//            @Result(property = "createAt", column = "create_at"),
//            @Result(property = "createBy", column = "create_by"),
//            @Result(property = "lastUpdateAt", column = "last_update_at"),
//            @Result(property = "lastUpdateBy", column = "last_update_by")
//    })
    List<Cloud> select();

    @Select("select * from cloud where id=#{id}")
    Cloud selectId(String id);


    @Insert("insert into cloud()")
    int add(Cloud cloud);

    @Delete("delete cloud where id=#{id}")
    int delete(String id);

    @Select("SELECT * FROM cloud where " +
            "is_lsf = #{isLsf} AND " +
            "bu_id = #{buId} AND " +
            "is_core = #{isCore} AND " +
            "instr(ip_addr, #{ipAddr})>0 AND " +
            "instr(host_name, #{hostName})>0")
    @Results(
            {
                    @Result(id = true, column = "dept_id", property = "deptId"),
                    @Result(id = true, column = "bu_id", property = "buId"),
                    @Result(id = true, column = "proj_id", property = "projId"),

                    @Result(
                            column = "dept_id",
                            property = "department",
                            one = @One(select = "com.amoxuk.mapper.DepartmentMapper.selectId",
                                    fetchType = FetchType.EAGER)
                    ),
                    @Result(
                            column = "bu_id",
                            property = "parentDepartment",
                            one = @One(select = "com.amoxuk.mapper.DepartmentMapper.selectId",
                                    fetchType = FetchType.EAGER)
                    ),
                    @Result(
                            column = "proj_id",
                            property = "project",
                            one = @One(select = "com.amoxuk.mapper.ProjectMapper.selectId",
                                    fetchType = FetchType.EAGER)
                    )
            })
    List<Cloud> selectSearch(@Param("buId") String bu,
                             @Param("isLsf") boolean lsf,
                             @Param("ipAddr") String ip,
                             @Param("isCore") boolean core,
                             @Param("hostName") String name);
}