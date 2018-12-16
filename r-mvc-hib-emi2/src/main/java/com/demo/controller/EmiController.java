package com.demo.controller;

import java.util.List;
import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.entity.Emi;
import com.demo.service.EmiService;

@Controller
@RequestMapping("/emi")
public class EmiController {
	@Autowired
	private EmiService emiService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		theModel.addAttribute("emi", new Emi());
		// get emi from the service
		List<Emi> theEmis = emiService.getEmis();
		// add the customers to the model
		theModel.addAttribute("emis", theEmis);
		return "list-emis";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model
		Emi theEmi = new Emi();
		theModel.addAttribute("emi", theEmi);
		return "Emi-form";
	}

	@PostMapping("/saveCustomer")
	public String saveEmi(@ModelAttribute("emi") Emi theEmi) {
// save the customer using our service
		emiService.saveEmi(theEmi);
		return "redirect:/emi/list";
	}

	@PostMapping("/calcultor")
	public String calculator(@RequestParam("loanAmount") float loanAmount,
			@RequestParam("rateofInterest") float rateofInterest, @RequestParam("tenure") float tenure,
			@RequestParam("NoofInstallments") float NoofInstallments, Model theModel) {
		float theEmi = emiService.calculateEmi(loanAmount, rateofInterest, tenure, NoofInstallments);
		theModel.addAttribute("emi", theEmi);
		return "Emi-form";
	}

	@PostMapping("/repaymentSchedule")
	public String repaymentSchedule(@RequestParam("emi") float emi, @RequestParam("loanAmount") float loanAmount,
			@RequestParam("rateofInterest") float rateofInterest, @RequestParam("tenure") float tenure,
			@RequestParam("NoofInstallments") float NoofInstallments, Model theModel) {
		return "Emi-form";
	}
}