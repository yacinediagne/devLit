package com.practice.devLit.controller;

import com.practice.devLit.model.Messages;
import com.practice.devLit.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

    @Autowired
    private MessagesRepository messagesRepository;

    @PostMapping("/save-messages")
    public Messages sendMessages(@RequestBody Messages message){
        return messagesRepository.save(message);
    }

}
