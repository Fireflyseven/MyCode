package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Experiment;
import model.Question;
import service.NewExService;

@Controller
public class NewExController {

	@Autowired
	NewExService nes;

	@RequestMapping("/add_ex_form")
	public String add_ex_form(Model model) {
		model.addAttribute("e", new Experiment());
		return "teacher/add_ex";
	}

	@RequestMapping("/add_ques_form/{exid}")
	public String add_ques_form(Model model, @PathVariable String exid) {
		Experiment ex = nes.findExperimentById(exid);
		model.addAttribute("ex", ex);
		model.addAttribute("q", new Question());
		return "teacher/add_ques";
	}

	@RequestMapping("/add_ques_form/add_que")
	public String add_que(Model model, @ModelAttribute Question q) {
		String experimentid = q.getExperimentid();
		q.setQuestionid(experimentid + q.getQuestionid());
		System.out.println(q.getQuestionid());
		if (nes.addAQuestion(q)) {
			model.addAttribute("info", "锟斤拷锟斤拷锟斤拷锟侥匡拷晒锟�");
		} else {
			model.addAttribute("info", "锟斤拷锟斤拷锟斤拷锟侥渴э拷锟�");
		}
		model.addAttribute("id", experimentid);
		return "redirect:/t_qlist/{id}";
	}

	@RequestMapping("/add_ex")
	public String add_ex(Model model, @ModelAttribute Experiment e) {
		e.setState("进行中");
		if (nes.addAnEx(e)) {
			model.addAttribute("info", "锟斤拷锟斤拷锟绞碉拷锟缴癸拷");
		} else {
			model.addAttribute("info", "锟斤拷锟斤拷锟绞碉拷锟�");
		}
		return "redirect:/t_list";
	}
}
