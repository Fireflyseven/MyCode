package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Answer;
import model.Experiment;
import model.Grade;
import model.Question;
import model.User;
import service.CheckService;
import service.ExperimentService;

@Controller
public class CheckController {
	@Autowired
	CheckService cs;
	
	@Autowired
	ExperimentService es;
	
	@RequestMapping("t_slist/{exid}")
	public String t_slist(Model model,@PathVariable String exid) {
		Experiment ex=this.cs.findExperimenById(exid);
		List<User> ss=this.cs.getStudentsByType(ex.getStutype());
		List<Grade> gs=new ArrayList<>();
		for(int i=0;i<ss.size();i++) {
			Grade grade=new Grade();
			grade.setExid(exid);
			grade.setUsername(ss.get(i).getUsername());
			grade.setName(ss.get(i).getName());
			if(this.cs.getExGrade(ss.get(i).getUsername(),exid)!=null) {
				grade.setGrade(this.cs.getExGrade(ss.get(i).getUsername(),exid));
			}else {
				grade.setGrade(0);
			}
			
			gs.add(grade);
		}
		model.addAttribute("ss", ss);
		model.addAttribute("ex", ex);
		model.addAttribute("gs", gs);
		return "teacher/t_slist";
	}
	
	@RequestMapping("t_check/{usr}/{qid}")
	public String s_qlist(Model model, @PathVariable String qid, @PathVariable String usr) {
		Experiment ex = es.findExperimentById(qid.substring(0, 6));
		model.addAttribute("ex", ex);
		List<Question> qs = es.findQuestionsByExId(ex.getExperimentid());
		model.addAttribute("qs", qs);
		Question qu = new Question();
		if ((qu = es.findQuestionById(qid)) != null) {
			model.addAttribute("qu", qu);
		}
		Answer an = es.findAnswer(usr, qid);
		model.addAttribute("an", an);
		User s=es.findUserById(usr);
		model.addAttribute("s", s);
		return "teacher/check_ex";
	}

	@RequestMapping("t_qpre/{usr}/{qid}")
	public String s_qpre(Model model, @PathVariable String qid,@PathVariable String usr) {
		String ex = qid.substring(0, 6);
		String idStr = qid.substring(7, 9);
		String pre = "";
		int id = Integer.parseInt(idStr);
		if (id > 1) {
			id = id - 1;
		}
		if (id >= 1 && id <= 9) {
			pre = ex + "00" + id;
		} else if (id > 9 && id <= 99) {
			pre = ex + "0" + id;
		} else if (id > 99) {
			pre = ex + id;
		}
		model.addAttribute("pre", pre);
		model.addAttribute("usr", usr);
		return "redirect:/t_check/{usr}/{pre}";
	}

	@RequestMapping("t_qnext/{usr}/{qid}")
	public String s_qnext(Model model, @PathVariable String qid,@PathVariable String usr) {
		String ex = qid.substring(0, 6);
		String idStr = qid.substring(7, 9);
		String next = "";
		int id = Integer.parseInt(idStr);
		int cnt = es.countQuestion(ex);
		if (id < cnt) {
			id += 1;
		}
		if (id >= 1 && id <= 9) {
			next = ex + "00" + id;
		} else if (id > 9 && id <= 99) {
			next = ex + "0" + id;
		} else if (id > 99) {
			next = ex + id;
		}
		model.addAttribute("next", next);
		model.addAttribute("usr", usr);
		return "redirect:/t_check/{usr}/{next}";
	}
	@RequestMapping("save_grade")
	public String save_answer(Model model, @ModelAttribute Answer a) {
		Answer an=this.cs.findAnswerById(a.getAnswerid());
		an.setScore(a.getScore());
		if(this.cs.saveGrade(an)) {
			
		}else {
			
		}
		model.addAttribute("usr", an.getUsername());
		model.addAttribute("qid", an.getQuestionid());
		return "redirect:/t_check/{usr}/{qid}";
	}
	
}
