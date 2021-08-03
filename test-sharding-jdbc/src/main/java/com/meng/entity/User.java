package com.meng.entity;
 
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;
 
/**
 * @Classname User
 * @Description 用户实体类
 * @Author 章国文 13120739083@163.com
 * @Date 2019-06-28 17:24
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {
 
    /**
     * 主键Id
     */
    private int id;
 
    /**
     * 名称
     */
    private String name;
 
    /**
     * 年龄
     */
    private int age;
    
    String s = "SELECT\n" +
            " T . NAME,\n" +
            " t2. NAME,\n" +
            " T3. NAME,\n" +
            " t4. NAME,\n" +
            " T1.fld_u_00004,\n" +
            " T1.fld_d_00005,\n" +
            " T .ObjStatusID,\n" +
            " T .OWNERIDS,\n" +
            " T .CREATORID,\n" +
            " T .CREATEDTIME\n" +
            "FROM\n" +
            " T_WF22_WF22 T\n" +
            "LEFT JOIN T_WF22_EXT t1 ON t1.OBJECTID = T . ID\n" +
            "LEFT JOIN T_PSM_PJT t2 ON t2. ID = T .projectid\n" +
            "LEFT JOIN T_OBJ_BASEITEM t3 ON t3. ID = T1.fld_s_00002\n" +
            "LEFT JOIN T_OBJ_BASEITEM t4 ON t4. ID = T1.fld_s_00003\n" +
            "ORDER BY\n" +
            " T .MODIFYTIME DESC;\n" +
            "\n";
}