package com.example.transaction.service;

import com.example.transaction.exception.BusinessException;
import com.example.transaction.model.User;
import com.example.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Transactional
    public void createUserRuntimeException(){
        User user=new User();
        user.setName("Aarti");
        userRepository.save(user);

        throw new RuntimeException("Something went wrong");
    }
    @Transactional
    public void createUserCheckedException() throws BusinessException{
        User user=new User();
        user.setName("User1234");
        userRepository.save(user);
        // Checked exception ,Spring COMMITS the transaction
        //Checked exceptions do NOT cause rollback by default
        throw new BusinessException("Business rule failed");
    }
    @Transactional(rollbackFor = BusinessException.class)
    public void createUserCheckedExceptionWithRollback()
            throws BusinessException {

        User user = new User();
        user.setName("RollbackUser");
        userRepository.save(user);

        throw new BusinessException("Now rollback works");
    }

}
