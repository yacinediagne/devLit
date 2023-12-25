package com.practice.devLit.service;

import com.practice.devLit.model.Users;
import com.practice.devLit.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUserByCapitalize (@org.jetbrains.annotations.NotNull Users user) {
        String lastName =user.getLastName();
        String firstName = user.getFirstName();
         user.setLastName(lastName.substring(0,1).toUpperCase()+ lastName.substring(1));
        user.setFirstName(firstName.substring(0,1).toUpperCase()+ firstName.substring(1));
         return usersRepository.save(user);


    }
}
