package org.udlma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SampleController {
	
	@GetMapping("/sample1")
	public void sample() {
		
	}
	
	@GetMapping("/guest")
	public void forGuest() {

		log.info("guest");

	}

	@GetMapping("/manager")
	public void forManager() {

		log.info("manager");

	}

	@GetMapping("/admin")
	public void forAdmin() {

		log.info("admin");

	}

}
