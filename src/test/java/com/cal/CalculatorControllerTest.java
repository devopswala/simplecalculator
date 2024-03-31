package com.cal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class) // This focuses on the CalculatorController only
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateAdd() throws Exception {
        this.mockMvc.perform(get("/calculate?operation=add&a=1&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Result: 3")));
    }

    @Test
    public void testCalculateSubtract() throws Exception {
        this.mockMvc.perform(get("/calculate?operation=subtract&a=5&b=2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("Result: 3")));
    }
}