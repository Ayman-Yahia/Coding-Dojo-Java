package com.codingdojo.BeltReviewer.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.BeltReviewer.models.Comment;
import com.codingdojo.BeltReviewer.models.Event;
import com.codingdojo.BeltReviewer.models.User;
import com.codingdojo.BeltReviewer.repositories.CommentRepository;
import com.codingdojo.BeltReviewer.repositories.EventRepository;
import com.codingdojo.BeltReviewer.repositories.UserRepository;


@Service
public class MainService {
	private final UserRepository userRepository;
	private final EventRepository eventRepository;
	private final CommentRepository commentRepository;
	public MainService(UserRepository userRepository,EventRepository eventRepository,CommentRepository commentRepository) {
		this.commentRepository=commentRepository;
		this.eventRepository=eventRepository;
		this.userRepository=userRepository;
	}
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
	public List<Event> allEvents() {
    	return eventRepository.findAll();
    }
	public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
	public User findUserById(Long id) {
    	Optional<User> user = userRepository.findById(id);
    	if(user.isPresent()) {
            return user.get();
    	}
    	else {
    	    return null;
    	}
    }
	public Event findEventById(Long id) {
    	Optional<Event> event = eventRepository.findById(id);
    	if(event.isPresent()) {
            return event.get();
    	}
    	else {
    	    return null;
    	}
    }
	public void updateEvent(Long id, String eventName, Date eventDate, String city, String state) {
		Optional <Event> temp = eventRepository.findById(id);
		if(temp != null) {
			temp.get().setEventName(eventName);
			temp.get().setEventDate(eventDate);
			temp.get().setCity(city);
			temp.get().setState(state);
		}  
    }
    
    public void updateUser(User user) {
    	userRepository.save(user);
    }
    public void updateMessage(Comment message) {
    	commentRepository.save(message);
    }
    
    public void newMessage(Comment message) {
    	commentRepository.save(message);
    }
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
    public List<Event> evenstNotInYourState(User user){
    	return eventRepository.findByStateIsNot(user.getState());
    	
    }
    public List<Event> evenstInYourState(User user){
    	return eventRepository.findByStateIs(user.getState());
    	
    }
    public Event createEvent(Event b) {
        return eventRepository.save(b);
    }
    public void joinUserEvent(User user,Event event) {
    	event.getAttendedUsers().add(user);
    	eventRepository.save(event);
    	
    }
}
