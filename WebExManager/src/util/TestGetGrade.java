package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Answer;
import repository.AnswerRepository;

class TestGetGrade {

	@Test
	void test() {
		AnswerRepository ar=new AnswerRepository();
		List<Answer> lists=(List<Answer>) ar.findAnswer("15202101", "201801001");
		
		
	}

}
