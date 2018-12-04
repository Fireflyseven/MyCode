package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Answer;
import model.Experiment;
import model.Grade;
import model.Question;
import model.User;
import repository.AnswerRepository;
import repository.ExperimentRepository;
import repository.QuestionRepository;
import repository.UserRepository;

@Service
public class ExperimentService {

	@Autowired
	ExperimentRepository experimentRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	UserRepository userRepository;


	public List<Experiment> findAllExperiment() {
		return this.experimentRepository.findAllExperiment();
	}

	public List<Question> findQuestionsByExId(String id) {
		return this.questionRepository.findQuestionsByExId(id);
	}

	public Question findQuestionById(String id) {
		return this.questionRepository.findQuestionsById(id);
	}

	public Experiment findExperimentById(String id) {
		return this.experimentRepository.findExperimentById(id);
	}

	public boolean updateExperiment(Experiment e) {
		return this.experimentRepository.updateExperiment(e);
	}

	public boolean deleteExperiment(String id) {
		return this.experimentRepository.deleteExperiment(id);
	}

	public boolean updateQuestion(Question qu) {
		return this.questionRepository.updateQuestion(qu);
	}

	public boolean deleteQuestion(String id) {
		return this.questionRepository.deleteQuestion(id);
	}

	public List<Experiment> findExperimentByStuType(int type) {
		return this.experimentRepository.findExperimentByStuType(type);
	}

	public Answer findAnswer(String usr, String id) {
		return this.answerRepository.findAnswer(usr, id);
	}

	public int countQuestion(String exid) {
		return this.questionRepository.countQuestion(exid);
	}

	public boolean saveAnswer(Answer a) {
		return this.answerRepository.saveAnswer(a);
	}

	public User findUserById(String usr) {
		return this.userRepository.findAUser(usr);
	}
	
	public List<Grade> getAllGrades(String username) {
		List<Experiment> exs=this.experimentRepository.findAllExperiment();
		List<Grade> list =new ArrayList<>();
		for(int i=0;i<exs.size();i++) {
			Grade g=new Grade();
			g.setExid(exs.get(i).getExperimentid());
			g.setUsername(username);
			if(this.answerRepository.calcuExGrade(username, exs.get(i).getExperimentid())!=null){
				g.setGrade(this.answerRepository.calcuExGrade(username, exs.get(i).getExperimentid()));
			}else {
				g.setGrade(0);
			}
			list.add(g);
		}
		return list;
	}
	
	

}
