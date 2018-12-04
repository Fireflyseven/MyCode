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
import model.Grade;
import model.Question;
import service.ExperimentService;

@Controller
public class ExListController {

	@Autowired
	ExperimentService els;

	@RequestMapping("/t_list")
	public String t_list(Model model) {
		List<Experiment> exs = els.findAllExperiment();
		model.addAttribute("exs", exs);
		return "teacher/t_main";
	}

	@RequestMapping("/t_qlist/{id}")
	public String t_qlist(Model model, @PathVariable String id) {
		Experiment ex = els.findExperimentById(id);
		List<Question> qs = els.findQuestionsByExId(ex.getExperimentid());
		model.addAttribute("ex", ex);
		model.addAttribute("qs", qs);
		model.addAttribute("e", new Experiment());
		return "teacher/t_list";
	}

	@RequestMapping("/t_qlist/update_ex")
	public String update_ex(Model model, @ModelAttribute Experiment e) {
		if (els.updateExperiment(e)) {
			model.addAttribute("info", "����ʵ����Ϣ�ɹ�");
		} else {
			model.addAttribute("info", "����ʵ����Ϣʧ��");
		}
		model.addAttribute("id", e.getExperimentid());
		return "redirect:/t_qlist/{id}";
	}

	@RequestMapping("/del_ex/{id}")
	public String del_ex(Model model, @PathVariable String id) {
		if (els.deleteExperiment(id)) {

		} else {

		}
		return "redirect:/t_list";

	}

	@RequestMapping("t_qlist/t_qedit/{id}")
	public String t_qedit(Model model, @PathVariable String id) {
		Question qu = els.findQuestionById(id);
		Experiment ex = els.findExperimentById(qu.getExperimentid());
		model.addAttribute("ex", ex);
		model.addAttribute("qu", qu);
		return "teacher/update_ques";
	}

	@RequestMapping("t_qlist/t_qedit/update_que")
	public String update_que(Model model, @ModelAttribute Question qu) {

		if (this.els.updateQuestion(qu)) {

		} else {

		}
		model.addAttribute("id", qu.getExperimentid());
		return "redirect:/t_qlist/{id}";
	}

	@RequestMapping("t_qlist/t_qdelete/{id}")
	public String t_qdelete(Model model, @PathVariable String id) {
		if (this.els.deleteQuestion(id)) {

		} else {

		}
		return "redirect:/t_qlist/{id}";
	}

	@RequestMapping("/s_list")
	public String s_list(Model model, HttpSession session) {
		int type = (Integer) session.getAttribute("type");
		String usr=(String) session.getAttribute("usr");
		List<Experiment> exs = els.findExperimentByStuType(type);
		List<Grade> gs=els.getAllGrades(usr);
		model.addAttribute("exs", exs);
		model.addAttribute("gs",gs);
		return "student/s_main";
	}

	@RequestMapping("/s_qlist0/{id}")
	public String s_qlist(Model model, @PathVariable String id, HttpSession session) {
		Experiment ex = els.findExperimentById(id);
		model.addAttribute("ex", ex);
		List<Question> qs = els.findQuestionsByExId(ex.getExperimentid());
		model.addAttribute("qs", qs);
		Question qu = new Question();
		if ((qu = els.findQuestionById(id + "001")) != null) {
			model.addAttribute("qu", qu);
		}
		Answer an = new Answer();
		String usr = (String) session.getAttribute("usr");
		if ((an = els.findAnswer(usr, id + "001")) != null) {
			model.addAttribute("an", an);
		} else {
			model.addAttribute("an", new Answer());
		}
		return "student/do_ex";
	}

}
