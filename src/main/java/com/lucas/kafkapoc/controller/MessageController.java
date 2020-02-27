package com.lucas.kafkapoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.kafkapoc.service.Producer;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
	
	private final Producer producer;
	
	@Autowired
	public MessageController(Producer producer) {
		this.producer = producer;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> publishMessage( @RequestBody(required = true) String message ) {
		this.producer.sendMessage(message);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
}
