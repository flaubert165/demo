package com.example.demo.persistence;

import com.example.demo.domain.entities.User;
import com.example.demo.domain.dtos.UserDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user (name,login, email, password, creationDate, updateDate) " +
            "values(#{user.name},#{user.login},#{user.email},#{user.password},#{user.creationDate},#{user.updateDate})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void create(@Param("user") User user);

    @Select("select * from user")
    List<User> getAll();

    @Select("select * from user where email = #{email}")
    User getByEmail(@Param("email") String email);

    @Select("select * from user where id = #{id}")
    UserDto getById(@Param("id") long id);

    @Update("update user set name=#{name}, login=#{login}, email=#{email}, updateDate=#{updateDate}" +
            "  where id=#{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(@Param("id") long id);
}
