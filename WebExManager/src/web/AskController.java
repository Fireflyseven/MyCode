package web;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Ask;
import model.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import service.AskService;
import service.ReplyService;
import util.DateTools;



@Controller
public class AskController {
	@Autowired
	AskService ask;
	@Autowired
	ReplyService reply;
	
	@RequestMapping("/add_ask_form")
	public String add_ask_from(Model model) {
		model.addAttribute("ask", new Ask());
		return "student/s_ask_add";
	}
	
	@RequestMapping("/add_ask")
	public String add_ask(Model model,@ModelAttribute Ask a,HttpSession session) {
		a.setAskid(DateTools.getTimeString());
		a.setUsername((String)session.getAttribute("usr"));
		if(ask.addAsk(a)){
			
		}else{
			
		}
		return "redirect:/s_a_list";
	}

	@RequestMapping("/del_ask/{askid}")
	public String del_ask(Model model, @PathVariable String askid) {
		if (ask.deleteAsk(askid)) {

		} else {

		}
		return "redirect:/s_a_list";

	}
	
	@RequestMapping("/s_a_list")
	public String s_a_list(Model model, HttpSession session) {
		List<Ask> a = ask.findAllAsk();
		model.addAttribute("a", a);
		return "student/s_ask_list";
	}
	@RequestMapping("/s_reply/{askid}")
	public String s_reply(Model model,@PathVariable String askid) {
		Ask a=ask.findAskById(askid);
		List<Reply> r = reply.getReplyList(askid);
		model.addAttribute("r", r);
		model.addAttribute("a", a);
		return "student/s_reply";
	}
	@RequestMapping("/s_add_reply_form/{askid}")
	public String s_add_reply_from(Model model,@PathVariable String askid ) {
		Ask a=ask.findAskById(askid);
		Reply reply=new Reply();
		reply.setAskid(askid);
		model.addAttribute("r",reply );
		model.addAttribute("a", a);
		return "student/s_reply_add";
	}
	@RequestMapping("/s_submit_reply")
	public String s_submit_reply(Model model, @ModelAttribute Reply r, HttpSession session) {
		r.setUsername((String) session.getAttribute("usr"));
		r.setReplyid(r.getAskid()+r.getReplyid());
		if (this.reply.submitReply(r)) {

		} else {

		}
		model.addAttribute("askid", r.getAskid());
		return "redirect:/s_reply/{askid}";
	}
	
//	@RequestMapping("/s_reply_update/{rid}")
//	public String s_reply_upadte(Model model, @PathVariable String rid) {
//		
//		Reply r = reply.findReply(rid);
//		Ask a=ask.findAskById(r.getAskid());
//		model.addAttribute("r",r);
//		model.addAttribute("ask",a);
//		return "student/s_reply_update";
//	}
//	
//	@RequestMapping("/s_update_reply")
//	public String s_update_reply(Model model, @ModelAttribute Reply r) {
//
//		if (this.reply.submitReply(r)) {
//
//		} else {
//
//		}
//		model.addAttribute("replyid", r.getReplyid());
//		return "redirect:/s_reply_update";
//	}

	@RequestMapping("/s_del_reply/{rid}")
	public String s_del_reply(Model model, @PathVariable String rid) {
		if (reply.deleteReply(rid)) {

		} else {

		}
		String askid=rid.substring(0,14);
		model.addAttribute("askid", askid);
		return "redirect:/s_reply/{askid}";
	}
	
	@RequestMapping("/t_a_list")
	public String t_a_list(Model model, HttpSession session) {
		List<Ask> a = ask.findAllAsk();
		model.addAttribute("a", a);
		return "teacher/t_ask_list";
	}
	@RequestMapping("/t_reply/{askid}")
	public String t_reply(Model model,@PathVariable String askid) {
		Ask a=ask.findAskById(askid);
		List<Reply> r = reply.getReplyList(askid);
		model.addAttribute("r", r);
		model.addAttribute("a", a);
		return "teacher/t_reply";
	}
	@RequestMapping("/t_add_reply_form/{askid}")
	public String t_add_reply_from(Model model,@PathVariable String askid ) {
		Ask a=ask.findAskById(askid);
		Reply reply=new Reply();
		reply.setAskid(askid);
		model.addAttribute("r",reply );
		model.addAttribute("a", a);
		return "teacher/t_reply_add";
	}
	@RequestMapping("/submit_reply")
	public String submit_reply(Model model, @ModelAttribute Reply r, HttpSession session) {
		r.setUsername((String) session.getAttribute("usr"));
		r.setReplyid(r.getAskid()+r.getReplyid());
		System.out.println(r.getReplyid());
		if (this.reply.submitReply(r)) {

		} else {

		}
		model.addAttribute("askid", r.getAskid());
		return "redirect:/t_reply/{askid}";
	}
	
//	@RequestMapping("/t_reply_update/{rid}")
//	public String t_reply_upadte(Model model, @PathVariable String rid) {
//		
//		Reply r = reply.findReply(rid);
//		Ask a=ask.findAskById(r.getAskid());
//		model.addAttribute("reply",r);
//		model.addAttribute("ask",a);
//		return "teacher/t_reply_update";
//	}
//	
//	@RequestMapping("/update_reply")
//	public String update_reply(Model model, @ModelAttribute Reply r) {
//		if (this.reply.submitReply(r)) {
//
//		} else {
//
//		}
//		model.addAttribute("replyid", r.getReplyid());
//		return "redirect:/t_reply_update";
//	}

	@RequestMapping("/t_del_reply/{rid}")
	public String del_reply(Model model, @PathVariable String rid) {
		if (reply.deleteReply(rid)) {

		} else {

		}
		String askid=rid.substring(0,14);
		model.addAttribute("askid", askid);
		return "redirect:/t_reply/{askid}";

	}

}
