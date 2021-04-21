package com.example.PowerliftingResults.web;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.PowerliftingResults.domain.SignupForm;
import com.example.PowerliftingResults.domain.User;
import com.example.PowerliftingResults.domain.UserRepository;

@Controller
public class UserContoller {
	
	@Autowired
    private UserRepository repository; 
	
    @RequestMapping(value = "signup")
    public String addUser(Model model){
    	model.addAttribute("signupform", new SignupForm());
        return "signup";
    }	
 
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { 
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {	
	    		String pwd = signupForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupForm.getUsername());
		    	newUser.setRole("USER");
		    	newUser.setEmail(signupForm.getEmail());
		    	
		    	if (repository.findByUsername(signupForm.getUsername()) == null) {
		    		
		    		if(repository.findByEmail(signupForm.getEmail()) == null) {
		    		repository.save(newUser);
		    		}
		    		
		    		else {
		    			bindingResult.rejectValue("email", "err.email", "Email already in use");    	
		    			return "signup";
		    		
		    		}
		    	}
		    	
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "signup";		    		
		    	}
		    	
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    }  
    
 
    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            repository.save(user);
        } else {
            throw new UsernameNotFoundException("Could not find any user with the email " + email);
        }
    }
     
    public User getByResetPasswordToken(String token) {
        return repository.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPasswordHash(encodedPassword);
         
        user.setResetPasswordToken(null);
        repository.save(user);
    }
    
  
}

    
   
  


  