package com.revature.app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.app.service.SkillService;

@SpringBootTest
@AutoConfigureMockMvc
class SkillControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private SkillService mockSkillService;
	
	@InjectMocks
	private SkillController skillController;
	
	
	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(mockSkillService).build();
		
		
	}
	
	
	@Test
	void test_getAllSkills_happy() {
		
	}
	
	@Test
	void test_getAllSkills_noSkills() {
		
	}
	
//	
	@Test
	void test_addSkill_happy() {
		
	}
	
	@Test
	void test_addSkill_emptyName() {
		
	}
	
	@Test
	void test_addSkill_badCategory() {
		
	}
	
	@Test
	void test_addSkill_duplicateSkill() {
		
	}
	
//	
	@Test
	void test_updateSkill_happy() {
		
	}
	
	@Test
	void test_updateSkill_emptyName() {
		
	}
	
	@Test
	void test_updateSkill_badID() {
		
	}
	
	@Test
	void test_updateSkill_badCategory() {
		
	}
	
	@Test
	void test_updateSkill_duplicateSkill() {
		
	}

//	
	@Test
	void test_deleteSkill_happy() {
		
	}
	
	@Test
	void test_deleteSkill_badID() {
		
	}
	

}
