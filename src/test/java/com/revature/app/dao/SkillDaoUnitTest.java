package com.revature.app.dao;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@DirtiesContext
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SkillDaoUnitTest {

	
	
	@Test
	@Transactional
	@Order(2)
	@Commit
	void test_getAllSkills_happy() {
		
	}
	
	@Test
	@Transactional
	@Order(0)
	@Commit
	void test_getAllSkills_noSkills() {
		
	}

//
	@Test
	@Transactional
	@Order(2)
	@Commit
	void test_getSkillByID_happy() {
		
	}
	
	@Test
	@Transactional
	@Order(0)
	@Commit
	void test_getSkillbyID_SkillDoesntExist() {
		
	}
	
//	
	@Test
	@Transactional
	@Order(1)
	@Commit
	void test_addSkill_happy() {
		
	}
	
	@Test
	@Transactional
	@Order(4)
	@Commit
	void test_addSkill_categoryDoesntExist() {
		
	}
	
	@Test
	@Transactional
	@Order(6)
	@Commit
	void test_addSkill_duplicateSkill() {
		
	}
	
//	
	@Test
	@Transactional
	@Order(3)
	@Commit
	void test_updateSkill_happy() {
		
	}
	
	@Test
	@Transactional
	@Order(0)
	@Commit
	void test_updateSkill_IDDoesntExist() {
		
	}
	
	@Test
	@Transactional
	@Order(4)
	@Commit
	void test_updateSkill_categoryDoesntExist() {
		
	}
	
	@Test
	@Transactional
	@Order(6)
	@Commit
	void test_updateSkill_duplicateSkill() {
		
	}

//	
	@Test
	@Transactional
	@Order(5)
	@Commit
	void test_deleteSkill_happy() {
		
	}
	
	@Test
	@Transactional
	@Order(0)
	@Commit
	void test_deleteSkill_skillDoesntExist() {
		
	}
}
