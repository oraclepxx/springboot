package com.springboot.sample.podcast;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PodcastController {
	
	@RequestMapping("/podcast")
	public String podcast() {
		return "hi, podcast";
	}

}
