package com.revature.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.app.model.Skill;

@RestController
public class SkillController {

	
	@GetMapping(path="skill")
	public List<Skill> getAllSkills() {
		return null;
	}
	
	@PostMapping(path="skill")
	public void addSkills() {
		
	}
	
	@PutMapping(path="skill")
	public void updateSkill() {
		
	}
	
	@DeleteMapping(path="skill")
	public void deleteSkill() {
		
	}
	
}
