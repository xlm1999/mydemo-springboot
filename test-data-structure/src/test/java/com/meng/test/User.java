package com.meng.test;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private String userName;
    private String passWord;
    private String userInfo;
    private List<User> friends;
}
