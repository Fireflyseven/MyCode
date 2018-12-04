package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Experiment;
import model.Question;
import repository.ExperimentRepository;
import repository.QuestionRepository;

@Service
public class NewExService {

	@Autowired
	ExperimentRepository experimentRepository;

	@Autowired
	QuestionRepository questionRepository;
	
	public boolean addAnEx(Experiment ex) {
		return this.experimentRepository.addAnEX(ex);
	}

	public Experiment findExperimentById(String id) {
		return this.experimentRepository.findExperimentById(id);
	}

	public boolean addAQuestion(Question q) {
		return this.questionRepository.addAQuestion(q);

	}

}
