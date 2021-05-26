package com.revature.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.app.dao.SkillDAO;
import com.revature.app.dto.SkillDTO;
import com.revature.app.exception.BadParameterException;
import com.revature.app.exception.EmptyParameterException;
import com.revature.app.exception.SkillDAOException;
import com.revature.app.exception.SkillNotAddedException;
import com.revature.app.exception.SkillNotDeletedException;
import com.revature.app.exception.SkillNotFoundException;
import com.revature.app.exception.SkillNotUpdatedException;
import com.revature.app.model.Skill;

@Service
public class SkillService {

	@Autowired
	private SkillDAO skillDAO;

	public List<Skill> getAllSkills(){
		return skillDAO.getAllSkills();
	}
	
	public Skill getSkillByID(String skillID) throws BadParameterException, EmptyParameterException, SkillNotFoundException {
		Skill skill = null;
		try {
			if(skillID.trim().equals("")){
				throw new EmptyParameterException("The skill ID was left blank");
			}
			int id = Integer.parseInt(skillID);
			skill = skillDAO.getSkillByID(id);
			return skill;
		} catch (NumberFormatException e) {
			throw new BadParameterException("The skill ID provided must be of type int");
		} catch (SkillDAOException e) {
			throw new SkillNotFoundException("The skill with ID " + skillID + " could not be found.");
		}
	}
	
	public Skill addSkill(SkillDTO skillDTO) throws EmptyParameterException, SkillNotAddedException {
		Skill skill = null;
		try {
			if(skillDTO.getName().trim().equals("")) {
				throw new EmptyParameterException("The skill name was left blank");
			}
			skill = skillDAO.addSkill(skillDTO);
			return skill;
		} catch (SkillDAOException e) {
			throw new SkillNotAddedException("The skill could not be added due to a database issue");
		}
	}
	
	public Skill updateSkill(String skillID, SkillDTO upSkill) throws EmptyParameterException, SkillNotUpdatedException, BadParameterException{
		Skill skill = null;
		try {
			if(skillID.trim().equals("")){
				throw new EmptyParameterException("The skill ID was left blank");
			}
			if(upSkill.getName().trim().equals("")){
				throw new EmptyParameterException("The skill name was left blank");
			}
			int id = Integer.parseInt(skillID);
			skill = skillDAO.updateSkill(id, upSkill);
			return skill;
		} catch (NumberFormatException e) {
			throw new BadParameterException("The skill ID provided must be of type int");
		} catch (SkillDAOException e) {
			throw new SkillNotUpdatedException("The skill could not be updated due to a database issue");
		}
	}
	
	public Skill deleteSkill(String skillID) throws EmptyParameterException, BadParameterException, SkillNotDeletedException {
		Skill skill = null;
		try {
			if(skillID.trim().equals("")){
				throw new EmptyParameterException("The skill ID was left blank");
			}
			int id = Integer.parseInt(skillID);
			skill = skillDAO.deleteSkill(id);
			return skill;
		} catch (NumberFormatException e) {
			throw new BadParameterException("The skill ID provided must be of type int");
		} catch (SkillDAOException e) {
			throw new SkillNotDeletedException("The skill could not be deleted due to a database issue");
		}
	}
}
