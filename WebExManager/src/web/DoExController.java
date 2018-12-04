package web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Answer;
import model.Experiment;
import model.Question;
import service.ExperimentService;

@Controller
public class DoExController {
	@Autowired
	ExperimentService es;

	@RequestMapping("s_qlist/{qid}")
	public String s_qlist(Model model, @PathVariable String qid, HttpSession session) {
		Experiment ex = es.findExperimentById(qid.substring(0, 6));
		model.addAttribute("ex", ex);
		List<Question> qs = es.findQuestionsByExId(ex.getExperimentid());
		model.addAttribute("qs", qs);
		Question qu = new Question();
		if ((qu = es.findQuestionById(qid)) != null) {
			model.addAttribute("qu", qu);
		}
		Answer an = new Answer();
		String usr = (String) session.getAttribute("usr");
		if ((an = es.findAnswer(usr, qid)) != null) {
			model.addAttribute("an", an);
			System.out.println(an.getAnswertext());
		} else {
			model.addAttribute("an", new Answer());
		}
		return "student/do_ex";
	}

	@RequestMapping("s_qpre/{qid}")
	public String s_qpre(Model model, @PathVariable String qid) {
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
		System.out.println(pre);
		model.addAttribute("pre", pre);
		return "redirect:/s_qlist/{pre}";
	}

	@RequestMapping("s_qnext/{qid}")
	public String s_qnext(Model model, @PathVariable String qid) {
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
		return "redirect:/s_qlist/{next}";
	}

	@RequestMapping("save_answer")
	public String save_answer(Model model, @ModelAttribute Answer a, HttpSession session) {
		a.setUsername((String) session.getAttribute("usr"));
		a.setAnswerid(a.getQuestionid() + a.getUsername());
		if (this.es.saveAnswer(a)) {

		} else {

		}
		model.addAttribute("id", a.getQuestionid());
		return "redirect:/s_qlist/{id}";
	}

}
