package com.meng.mapper;

import com.meng.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> listUser();
    String getName(Integer id);
    int addUser(User user);

    int updateUser(User user);
    int deleteUser(Integer id);

}
