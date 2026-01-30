package com.example.transaction.controller;

import com.example.transaction.exception.BusinessException;
import com.example.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/runtime")
    public void runtime(){
        userService.createUserRuntimeException();
    }
    @GetMapping("/checked")
    public void checked() throws BusinessException {
        userService.createUserCheckedException();
    }

    @GetMapping("/checked-rollback")
    public void checkedRollback() throws BusinessException {
        userService.createUserCheckedExceptionWithRollback();
    }
}
