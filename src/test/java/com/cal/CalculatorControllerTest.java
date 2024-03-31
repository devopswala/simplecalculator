package com.cal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class CalculatorControllerTest {

    private MockMvc mockMvc;
    private WebApplicationContext context;

    @Before
    public void setup() {
        //this.mockMvc = standaloneSetup(new CalculatorController()).build();
        this.mockMvc = MockMvcBuilders.WebApplicationContextSetup(context).build();
    }

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
                .andExpect(content().string(containsString("Result: 3")));
    }
}
