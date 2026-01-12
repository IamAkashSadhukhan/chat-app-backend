package com.substring.chat.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.substring.chat.controllers.payload.MessageRequest;
import com.substring.chat.entities.Message;
import com.substring.chat.entities.Room;
import com.substring.chat.repository.RoomRepository;

@Controller
public class ChatController
{
	@Autowired
	private RoomRepository roomRepository;
	
	//for sending and reciving messages
	
	@MessageMapping("/sendMessage/{roomId}")
	@SendTo("/topic/room/{roomId}")
	@CrossOrigin("http://localhost:5173")
	public Message sendMessage(
		@DestinationVariable String roomId,
		@RequestBody MessageRequest request
			) throws RuntimeException{
		
		Room room = roomRepository.findByRoomId(roomId);
		
		Message message = new Message();
		message.setContent(request.getContent());
		message.setTimestamp(LocalDateTime.now());
		message.setSender(request.getSender());
	
		if(room != null) {
			room.getMessages().add(message);
			roomRepository.save(room);
		}else {
			throw new RuntimeException("Room not found");
		}
		
		return message;
		
	}
}
