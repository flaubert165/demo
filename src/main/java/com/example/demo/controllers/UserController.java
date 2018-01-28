package com.example.demo.controllers;

import com.example.demo.domain.entities.User;
import com.example.demo.domain.dtos.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public void create(@RequestBody UserDto dto) throws Exception {
        this.service.create(dto);
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = GET)
    public List<User> getAll() {
        return this.service.getAll();
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = GET, value = "/{userId}")
    public UserDto getById(@PathVariable long userId) {
        return this.service.getById(userId);
    }

    @PreAuthorize("#oauth2.hasScope('write')")
    @RequestMapping(method = PUT, value = "/{userId}")
    public void update(@RequestBody UserDto dto) throws Exception {
        this.service.update(dto);
    }

    @PreAuthorize("#oauth2.hasScope('write')")
    @RequestMapping(method = DELETE, value = "/{userId}")
    public void delete(@PathVariable long userId) {
        this.service.delete(userId);
    }

}
