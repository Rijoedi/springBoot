//package com.aoPremura.springBoot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.aoPremura.springBoot.model.Guest;
//import com.aoPremura.springBoot.repository.GuestRepository;
//
//@Controller
//public class GuestRegisterController {
//	
//	@Autowired
//	private GuestRepository guestRepository;
//	
//	@RequestMapping(value = "/guestregister")
//	public String guestRegister() {
//	    return "guestregister";
//	}
//	
//	@RequestMapping(value = "save", method = RequestMethod.POST)
//	public String save(@RequestParam("name")String name,@RequestParam("email") String email,
//			@RequestParam("tel") String tel, Model model) {
//		
//		Guest newGuest = new Guest(name,email,tel);
//		guestRepository.save(newGuest);
//		
//		Iterable<Guest> guests = guestRepository.findAll();
//	    model.addAttribute("guests", guests);
//
//	    return "guestlist";
//	}
//
//}
