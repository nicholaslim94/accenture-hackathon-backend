//package com.example.vaccinatetogether.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class OrganizationContorllerIT {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void register() throws Exception {
//		mockMvc
//		.perform(post("/register"))
//		.andExpect(status().isOk());
//	}
//	
//	@Test
//	public void login() throws Exception {
//		MvcResult result = mockMvc
//				.perform(post("/login"))
//				.andExpect(status().isOk())
//				.andReturn();
//		String content = result.getResponse().getContentAsString();
//		System.out.println(content);
//	}
//	
//
//	
//	
//
//}
