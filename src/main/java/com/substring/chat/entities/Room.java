package com.substring.chat.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="rooms")
@Getter
@Service
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	
	@Id
	private String id;//mongodb unique identifier
	private String roomId;
	private List<Message> messages = new ArrayList();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomid() {
		return roomId;
	}

	public void setRoomid(String roomid) {
		roomId = roomid;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	
	
}
