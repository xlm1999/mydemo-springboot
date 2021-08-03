package com.meng;

import lombok.*;
import java.io.Serializable;

//注意：实体类要可序列化
@Getter
@Setter
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", 名字='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}