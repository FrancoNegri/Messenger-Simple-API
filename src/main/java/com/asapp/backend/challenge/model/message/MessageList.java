package com.asapp.backend.challenge.model.message;

import java.util.List;

public class MessageList {

	private final List<Message> messages;

	public MessageList(List<Message> messages) {
		this.messages = messages;
	}

	public List<Message> getMessages() {
		return messages;
	}

}
