package com.capgemini.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.rest.entity.Worker;

@RestController
public class SimpleController {

	@GetMapping("/hello")
	public String sayHello() {
		return "HelloWorld";
	}

	@GetMapping("/worker")
	public Worker displayWorker() {
		return new Worker("ABC", 123);
	}

	@PostMapping("/test")
	public String success(@RequestBody Worker worker) {
		System.out.println(worker);
		return "success";
	}
}
