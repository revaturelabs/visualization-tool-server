package com.revature.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.app.dao.SkillDAO;
import com.revature.app.dto.SkillDTO;
import com.revature.app.exception.BadParameterException;
import com.revature.app.exception.EmptyParameterException;
import com.revature.app.exception.SkillDAOException;
import com.revature.app.exception.SkillNotAddedException;
import com.revature.app.exception.SkillNotDeletedException;
import com.revature.app.exception.SkillNotFoundException;
import com.revature.app.exception.SkillNotUpdatedException;
import com.revature.app.model.Category;
import com.revature.app.model.Skill;


@ExtendWith(MockitoExtension.class)
class SkillServiceUnitTest {
	
	@Mock
	private SkillDAO mockSkillDAO;
	
	@InjectMocks
	private SkillService skillService;
	
	@BeforeAll
	public static void setUp() throws SkillDAOException {
		
	}
	
	@BeforeEach
	public void beforeTest() throws SkillDAOException {
		Skill skill1 = new Skill(1, "", new Category(1, "", null));
		Skill skill2 = new Skill(2, "", new Category(1, "", null));
		Skill skill3 = new Skill(1, "TestSkill", new Category(1, "TestCat", null));
		SkillDTO skillDTO1 = new SkillDTO("TestSkill", new Category(1, "TestCat", null));
		SkillDTO skillDTO2 = new SkillDTO("Duplicate", new Category(1, "TestCat", null));
		SkillDTO skillDTO3 = new SkillDTO("Test", new Category(0, "BadCat", null));
		
		lenient().when(mockSkillDAO.getSkillByID(eq(1))).thenReturn(skill1);
		lenient().when(mockSkillDAO.getSkillByID(eq(0))).thenThrow(new SkillDAOException());
		
		lenient().when(mockSkillDAO.addSkill(skillDTO1)).thenReturn(skill3);
		lenient().when(mockSkillDAO.addSkill(skillDTO2)).thenThrow(new SkillDAOException());
		lenient().when(mockSkillDAO.addSkill(skillDTO3)).thenThrow(new SkillDAOException());
		
		lenient().when(mockSkillDAO.updateSkill(1, skillDTO1)).thenReturn(skill3);
		lenient().when(mockSkillDAO.updateSkill(2, skillDTO1)).thenThrow(new SkillDAOException());
		lenient().when(mockSkillDAO.updateSkill(2, skillDTO3)).thenThrow(new SkillDAOException());
		
		lenient().when(mockSkillDAO.deleteSkill(0)).thenThrow(new SkillDAOException());
		lenient().when(mockSkillDAO.deleteSkill(1)).thenReturn(skill1);
		
	}
	
	
	@Test
	void test_getAllSkills_happy() {
		Skill skill1 = new Skill(1, "", new Category(1, "", null));
		Skill skill2 = new Skill(2, "", new Category(1, "", null));
		List<Skill> expected = new ArrayList<Skill>();
		expected.add(skill1);
		expected.add(skill2);
		when(mockSkillDAO.getAllSkills()).thenReturn(expected);
		List<Skill> actual = skillService.getAllSkills();
		assertEquals(expected, actual);
	}
	
	@Test
	void test_getAllSkills_noSkills() {
		List<Skill> expected = new ArrayList<Skill>();
		when(mockSkillDAO.getAllSkills()).thenReturn(expected);
		List<Skill> actual = skillService.getAllSkills();
		assertEquals(expected, actual);
	}

//
	@Test
	void test_getSkillByID_happy() throws BadParameterException, EmptyParameterException, SkillNotFoundException {
		Skill expected = new Skill(1, "", new Category(1, "", null));
		Skill actual = skillService.getSkillByID("1");
		assertEquals(expected, actual);
	}
	
	@Test
	void test_getSkillbyID_BadID() {
		try {
			skillService.getSkillByID("0");
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			fail("Wrong exception was thrown");
		} catch (BadParameterException e) {
			fail("Wrong exception was thrown");
		} catch (SkillNotFoundException e) {
			assertEquals(e.getMessage(), "The skill with ID 0 could not be found.");
		}
	}
	
	@Test
	void test_getSkillbyID_BadParameter() {
		try {
			skillService.getSkillByID("test");
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			fail("Wrong exception was thrown");
		} catch (BadParameterException e) {
			assertEquals(e.getMessage(), "The skill ID provided must be of type int");
		} catch (SkillNotFoundException e) {
			fail("Wrong exception was thrown");
		}
	}
	
	@Test
	void test_getSkillbyID_EmptyParameter() {
		try {
			skillService.getSkillByID("   ");
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			assertEquals(e.getMessage(), "The skill ID was left blank");
		} catch (BadParameterException e) {
			fail("Wrong exception was thrown");
		} catch (SkillNotFoundException e) {
			fail("Wrong exception was thrown");
		}
	}
	
//	
	@Test
	void test_addSkill_happy() throws EmptyParameterException, SkillNotAddedException {
		SkillDTO skillDTO = new SkillDTO("TestSkill", new Category(1, "TestCat", null));
		Skill expected = new Skill(1, "TestSkill", new Category(1, "TestCat", null));
		Skill actual = skillService.addSkill(skillDTO);
		assertEquals(expected, actual);
	}
	
	@Test
	void test_addSkill_emptyName() throws SkillNotAddedException {
		try {
			SkillDTO skillDTO = new SkillDTO("  ", new Category(1, "TestCat", null));
			skillService.addSkill(skillDTO);
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			assertEquals(e.getMessage(), "The skill name was left blank");
		}
	}
	
	@Test
	void test_addSkill_badCategory() throws EmptyParameterException {
		try {
			SkillDTO skillDTO = new SkillDTO("Test", new Category(0, "BadCat", null));
			skillService.addSkill(skillDTO);
			fail("SkillNotAddedException was not thrown");
		} catch (SkillNotAddedException e) {
			assertEquals(e.getMessage(), "The skill could not be added due to a database issue");
		}
	}
	
	@Test
	void test_addSkill_duplicateSkill() throws EmptyParameterException {
		try {
			SkillDTO skillDTO = new SkillDTO("Duplicate", new Category(1, "TestCat", null));
			skillService.addSkill(skillDTO);
			fail("SkillNotAddedException was not thrown");
		} catch (SkillNotAddedException e) {
			assertEquals(e.getMessage(), "The skill could not be added due to a database issue");
		}
	}
	
//	
	@Test
	void test_updateSkill_happy() throws EmptyParameterException, SkillNotUpdatedException, BadParameterException {
		SkillDTO upSkill = new SkillDTO("TestSkill", new Category(1, "TestCat", null));
		Skill expected = new Skill(1, "TestSkill", new Category(1, "TestCat", null));
		Skill actual = skillService.updateSkill("1", upSkill);
		assertEquals(expected, actual);
	}
	
	@Test
	void test_updateSkill_emptyID() throws SkillNotUpdatedException {
		try {
			SkillDTO upSkill = new SkillDTO("", new Category(1, "", null));
			skillService.updateSkill("   ", upSkill);
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			assertEquals(e.getMessage(), "The skill ID was left blank");
		} catch (BadParameterException e) {
			fail("Wrong exception was thrown");
		}
	}
	
	@Test
	void test_updateSkill_badID() throws SkillNotUpdatedException, EmptyParameterException {
		try {
			SkillDTO upSkill = new SkillDTO("Test", new Category(1, "", null));
			skillService.updateSkill("test", upSkill);
			fail("BadParameterException was not thrown");
		} catch (BadParameterException e) {
			assertEquals(e.getMessage(), "The skill ID provided must be of type int");
		}
	}
	
	@Test
	void test_updateSkill_emptyName() throws SkillNotUpdatedException, BadParameterException {
		try {
			SkillDTO upSkill = new SkillDTO("", new Category(1, "", null));
			skillService.updateSkill("1", upSkill);
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			assertEquals(e.getMessage(), "The skill name was left blank");
		}
	}
	

	@Test
	void test_updateSkill_badCategory() throws EmptyParameterException, BadParameterException {
		try {
			SkillDTO upSkill = new SkillDTO("Test", new Category(0, "BadCat", null));
			skillService.updateSkill("2", upSkill);
			fail("SkillNotUpdatedException was not thrown");
		} catch (SkillNotUpdatedException e) {
			assertEquals(e.getMessage(), "The skill could not be updated due to a database issue");
		}
	}
	
	@Test
	void test_updateSkill_duplicateSkill() throws EmptyParameterException, BadParameterException {
		try {
			SkillDTO upSkill = new SkillDTO("TestSkill", new Category(1, "TestCat", null));
			skillService.updateSkill("2", upSkill);
			fail("SkillNotUpdatedException was not thrown");
		} catch (SkillNotUpdatedException e) {
			assertEquals(e.getMessage(), "The skill could not be updated due to a database issue");
		}
	}

//	
	@Test
	void test_deleteSkill_happy() throws EmptyParameterException, BadParameterException, SkillNotDeletedException {
		Skill expected = new Skill(1, "", new Category(1, "", null));
		Skill actual = skillService.deleteSkill("1");
		assertEquals(expected, actual);
	}
	
	@Test
	void test_deleteSkill_IDDoesntExist() throws EmptyParameterException, BadParameterException {
		try {
			skillService.deleteSkill("0");
			fail("SkillNotDeletedException was not thrown");
		} catch (SkillNotDeletedException e) {
			assertEquals(e.getMessage(), "The skill could not be deleted due to a database issue");
		}
	}
	
	@Test
	void test_deleteSkill_BadParameter() throws EmptyParameterException, SkillNotDeletedException {
		try {
			skillService.deleteSkill("test");
			fail("BadParameterException was not thrown");
		} catch (BadParameterException e) {
			assertEquals(e.getMessage(), "The skill ID provided must be of type int");
		}
	}
	
	@Test
	void test_deleteSkill_emptyParameter() throws BadParameterException, SkillNotDeletedException {
		try {
			skillService.deleteSkill("      ");
			fail("EmptyParameterException was not thrown");
		} catch (EmptyParameterException e) {
			assertEquals(e.getMessage(), "The skill ID was left blank");
		}
	}
	
	
}
