package com.example.MARS.controllers;


import com.example.MARS.exceptions.InvalidCommandException;
import com.example.MARS.services.MarsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MarsControllerTest {

    @MockBean
    private MarsService marsService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldExecuteCommandsCorrectly() throws Exception {
        when(marsService.executeCommands("MMRMMRMM")).thenReturn("(2, 0, S)");
        this.mockMvc.perform(post("/rest/mars/MMRMMRMM")).andExpect(status().isOk())
                .andExpect(content().string(containsString("(2, 0, S)")));
    }
    @Test
    public void shouldNotExecuteBadCommands() throws Exception {
        when(marsService.executeCommands("KKKJ")).thenThrow(InvalidCommandException.class);
        mockMvc.perform(post("/rest/mars/KKKJ"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("400 Bad Request")));
    }

    @Test
    public void shouldNotGetOutOfRange() throws Exception {
        when(marsService.executeCommands("MMMMMMMM")).thenThrow(InvalidCommandException.class);
        mockMvc.perform(post("/rest/mars/MMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("400 Bad Request")));
    }
}