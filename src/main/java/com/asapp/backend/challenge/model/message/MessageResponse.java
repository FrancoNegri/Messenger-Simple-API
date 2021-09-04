package com.asapp.backend.challenge.model.message;

public class MessageResponse {

	private final long id;
	private final String timestamp;

	public MessageResponse(long id, String timestamp) {
		this.timestamp = timestamp;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getTimeStamp() {
		return timestamp;
	}

}
