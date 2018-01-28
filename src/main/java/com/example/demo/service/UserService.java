package com.example.demo.service;

import com.example.demo.common.PasswordEncoder;
import com.example.demo.domain.entities.User;
import com.example.demo.domain.dtos.UserDto;
import com.example.demo.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper repository;

    @Autowired
    public UserService(UserMapper repository){
        this.repository = repository;
    }

    public void create(UserDto dto) throws Exception {

        User user = this.repository.getByEmail(dto.getEmail());

        if(user == null){
            user = new User(dto.getName(), dto.getLogin(), dto.getEmail(), PasswordEncoder.generatePassword(dto.getPassword()));
            user.setCreationDate(new Date());
            this.repository.create(user);
        }

    }

    public List<User> getAll(){
        return this.repository.getAll();
    }

    public UserDto getById(long id) {
        return this.repository.getById(id);
    }

    public void update(UserDto dto) throws Exception {

        User user = new User(dto.getName(), dto.getLogin(), dto.getEmail(), dto.getPassword());
        user.setId(dto.getId());
        user.setUpdateDate(new Date());
        if(dto != null){
            this.repository.update(user);
        }
    }

    public void delete(long id) {
        this.repository.delete(id);
    }

}
