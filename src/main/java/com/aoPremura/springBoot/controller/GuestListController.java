package com.aoPremura.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aoPremura.springBoot.model.Guest;
import com.aoPremura.springBoot.repository.GuestRepository;
import com.enviadorEmail.service.EmailService;

@Controller
public class GuestListController {

	@Autowired
	private GuestRepository guestRepository;
	
	/* OBJECTS */
	private Guest guest;

	@RequestMapping(value = "/guestlist")
	public String guestList(Model model) {
		Iterable<Guest> guests = guestRepository.findAll();
		model.addAttribute("guests", guests);

		return "guestlist";
	}
	
	@RequestMapping(value = "/guestjson", produces = {"application/JSON"})
	@ResponseBody
	public String guestListJson() {
		Iterable<Guest> guests = guestRepository.findAll();
		return guests.toString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam Long id) {
		guest = guestRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		guestRepository.delete(guest);

		return "redirect:/guestlist";
	}

	@RequestMapping(value = "/update")
	public String updateUser(@RequestParam Long id, Model model) {
	   guest = guestRepository.findById(id)
	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	   
	   	model.addAttribute("idguest", guest.getIdguest());
	    model.addAttribute("name", guest.getName());
	    model.addAttribute("email", guest.getEmail());
	    model.addAttribute("tel", guest.getTel());
	    
        return "guestedit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save() {
		
			//保存します
			guestRepository.save(guest);
			//メール送ります
			new EmailService().send(guest.getName(), guest.getEmail());
			
		return "redirect:/guestlist";
	}
}
