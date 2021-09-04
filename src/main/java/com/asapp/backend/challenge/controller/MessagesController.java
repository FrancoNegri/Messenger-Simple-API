package com.asapp.backend.challenge.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asapp.backend.challenge.model.message.Message;
import com.asapp.backend.challenge.model.message.MessageList;
import com.asapp.backend.challenge.model.message.MessageRequest;
import com.asapp.backend.challenge.model.message.MessageResponse;
import com.asapp.backend.challenge.repositories.MessageRepository;

@RestController
public class MessagesController {

	@Autowired
	private MessageRepository messageRepository;

	@PostMapping(path = "/messages")
	public MessageResponse newMessage(@RequestBody Message newMessage) {
		logger.info("New message from : " + newMessage);
		newMessage.setTimestamp();
		newMessage = messageRepository.save(newMessage);
		return new MessageResponse(newMessage.getId(), newMessage.getTimestamp());
	}

	@GetMapping(path = "/messages")
	public MessageList fetchMessages(@RequestBody MessageRequest messageRequest) {
		logger.info("New message request from: " + messageRequest);
		Message messageExample = new Message();
		// The challange documentation does not say anything about not being able to
		// fetch other users messages, but from a security perspective seems strange
		messageExample.setRecipient(messageRequest.getRecipient());
		List<Message> allUserMessages = messageRepository.findAll(Example.of(messageExample, ExampleMatcher.matching().withIgnorePaths("id")));
		Integer request_limit = messageRequest.getLimit() != null ? messageRequest.getStart() + messageRequest.getLimit()
				: messageRequest.getStart() + 100;
		int limit = request_limit < allUserMessages.size() ? request_limit : allUserMessages.size();
		List<Message> filteredMessages = allUserMessages.subList(messageRequest.getStart(), limit);
		return new MessageList(filteredMessages);
	}

	private final Logger logger = LoggerFactory.getLogger(MessagesController.class);

}
