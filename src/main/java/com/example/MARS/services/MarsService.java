package com.example.MARS.services;

import com.example.MARS.enums.MarsCommands;
import com.example.MARS.exceptions.InvalidCommandException;
import com.example.MARS.utils.MarsPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarsService {
    @Autowired
    private final MarsPosition marsPosition;

    public MarsService(MarsPosition marsPosition) {
        this.marsPosition = marsPosition;
    }

    public String executeCommands(String commands){
       try{
           for (int i = 0; i < commands.length(); i++) {
               MarsCommands.valueOf(String.valueOf(commands.charAt(i))).execute(marsPosition);
           }
           return marsPosition.returnPosition();
       } catch (IllegalArgumentException e){
           throw new InvalidCommandException();
       } finally {
            marsPosition.resetPosition();
       }
    }




}
