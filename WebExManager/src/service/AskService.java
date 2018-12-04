package service;

import java.util.List;

import model.Ask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.AskRepository;



@Service
public class AskService {
	@Autowired
	AskRepository askRepository;

	
	public List<Ask> findAllAsk(){
		return this.askRepository.findAllAsk();
	}
	public List<Ask> findAskByUsername(String username){
		return this.askRepository.findAskByUsername(username);
	}
	public Ask findAskById(String id){
		return this.askRepository.findAskById(id);
	}
	public boolean addAsk(Ask ask){
		return this.askRepository.addAsk(ask);
	}
	public boolean deleteAsk(String id){
		return this.askRepository.deleteAsk(id);
	}
	

}
