package com.revature.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.app.dto.SkillDTO;
import com.revature.app.exception.SkillDAOException;
import com.revature.app.model.Skill;

@Repository
public class SkillDAO {

	public List<Skill> getAllSkills() {
		return null;
	}
	
	public Skill getSkillByID(int skillID) throws SkillDAOException {
		return null;
	}
	
	public Skill addSkill(SkillDTO newSkill) throws SkillDAOException {
		return null;
	}
	
	public Skill updateSkill(int skillID, SkillDTO upSkill) throws SkillDAOException {
		return null;
	}
	
	public Skill deleteSkill(int skillID) throws SkillDAOException {
		return null;
	}
}
