package com.example.practisecrud.controller;

import com.example.practisecrud.model.School;
import com.example.practisecrud.service.impl.schoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class schoolController {
    @Autowired
    schoolServiceImpl service;

    @GetMapping("/getDetails")
    public List<School> getAllSchools(){
        return service.getAllSchools();
    }

    @GetMapping("/getById/{id}")
    public School getSchoolById(@PathVariable Long Id){
        return service.getSchoolById(Id);
    }

    @PostMapping("/AddSchool")
    public School addSchool(@RequestBody School s){
        return service.addSchool(s);
    }

    @DeleteMapping("/deleteSchool")
    public School

}
