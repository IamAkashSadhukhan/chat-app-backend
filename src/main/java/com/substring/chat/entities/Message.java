package com.substring.chat.entities;

import java.time.LocalDateTime;


public class Message {
	
	private String sender;
	private String content;
	private LocalDateTime timestamp;
	
	public Message(String sender,String content) {
		this.sender= sender;
		this.content = content;
		timestamp = LocalDateTime.now();
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
