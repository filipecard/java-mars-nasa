package com.example.MARS.services;

import com.example.MARS.exceptions.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MarsServiceTest {

    @Autowired
    private MarsService marsService;

    @Test
    public void shouldExecuteCommandsCorrectly() {
        assertEquals(marsService.executeCommands("MMRMMRMM"), "(2, 0, S)");

    }

    @Test
    public void shouldNotExecuteBadCommands() {
        assertThrows(InvalidCommandException.class, () -> marsService.executeCommands("KKKJ"), "(0, 0, N)");

    }

    @Test
    public void shouldNotGetOutOfRange() {
        assertThrows(InvalidCommandException.class, () -> marsService.executeCommands("MMMMMMM"));

    }

}