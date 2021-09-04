package com.asapp.backend.challenge.model.message;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String timestamp;
	private long sender;
	private long recipient;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Content content;

	public long getId() {
		return id;
	}

	public long getSender() {
		return sender;
	}

	public void setSender(long sender) {
		this.sender = sender;
	}

	public long getRecipient() {
		return recipient;
	}

	public void setRecipient(long recipient) {
		this.recipient = recipient;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public void setTimestamp() {
		timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", recipient=" + recipient + ", content=" + content + "]";
	}


}
