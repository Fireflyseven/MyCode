package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Answer;
import model.Experiment;
import model.User;
import repository.AnswerRepository;
import repository.ExperimentRepository;
import repository.UserRepository;

@Service
public class CheckService {
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	ExperimentRepository experimentRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<Answer> getAnswerList(String exid) {
		return this.answerRepository.getAnswerList(exid);
	}

	public Experiment findExperimenById(String exid) {
		return this.experimentRepository.findExperimentById(exid);
	}

	public List<User> getStudentsByType(int stutype) {
		return this.userRepository.findUsersByType(stutype);
	}

	public Double getExGrade(String username, String exid) {
		return this.answerRepository.calcuExGrade(username,exid);
	}

	public Answer findAnswerById(String answerid) {
		return this.answerRepository.findAnswerById(answerid);
	}

	public boolean saveGrade(Answer an) {
		return this.answerRepository.saveGrade(an);
	}

}
