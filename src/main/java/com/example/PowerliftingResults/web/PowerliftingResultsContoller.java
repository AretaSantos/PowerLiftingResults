package com.example.PowerliftingResults.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.PowerliftingResults.domain.Result;
import com.example.PowerliftingResults.domain.ResultRepository;



@Controller
public class PowerliftingResultsContoller {
	
	@Autowired 
	private ResultRepository repository;
	
	@RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }
	
	@RequestMapping("/results")
	public String results(Model model) {
	model.addAttribute("results", repository.findAll());
	return "results";
	}
	
	@RequestMapping(value="/resultlist", method = RequestMethod.GET)
	    public @ResponseBody List<Result> bookListRest() {	
	        return (List<Result>) repository.findAll();
	    }
	
	@RequestMapping(value = "/add")
	public String addStudent(Model model){
	 model.addAttribute("result", new Result());
	 return "addresult";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Result result){
	 repository.save(result);
	 return "redirect:results";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String EditResult(@PathVariable("id") Long ResultId, Model model) {
		Optional <Result> result = repository.findById(ResultId);
		model.addAttribute("result", result);
			return "editresult";
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteResult(@PathVariable("id") Long resultId, Model model) {
	 repository.deleteById(resultId);
	 return "redirect:../results";
	}
	
	@RequestMapping(value="/result/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Result> findResultRest(@PathVariable("id") Long resultId) {
	return repository.findById(resultId);
	}
	
	
}