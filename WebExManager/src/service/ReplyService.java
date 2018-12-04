package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ReplyRepository;
import model.Reply;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;
	
	public Reply findReply(String id) {
		return this.replyRepository.findReply(id);
	}
	public List<Reply> getReplyList(String askid) {
		return this.replyRepository.getReplyList(askid);
	}
	public boolean submitReply(Reply p){
		return this.replyRepository.submitReply(p);
	}
	public boolean updateReply(Reply reply){
		return this.updateReply(reply);
	}
	public boolean deleteReply(String id){
		return this.replyRepository.deleteReply(id);
	}
	

}
