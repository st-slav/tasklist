package ru.mamsta.exam.ibs.tasklist.api.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mamsta.exam.ibs.tasklist.api.model.User;
import ru.mamsta.exam.ibs.tasklist.api.services.CatalogDataService;
import ru.mamsta.exam.ibs.tasklist.api.services.util.IdCounter;

@Service("userService")
public class UserServiceImpl implements CatalogDataService<User> {
	
	@Autowired
	private IdCounter idCounter;
	
	private Map<Long, User> userMap;
	
	@PostConstruct
	private void init() {
		userMap = new HashMap<>();
		
		Long id = idCounter.nextId();
		userMap.put(id, new User(id, "@neo"));
		
		id = idCounter.nextId();
		userMap.put(id, new User(id, "@morpheus"));
		
		id = idCounter.nextId();
		userMap.put(id, new User(id, "@trinity"));
		
		id = idCounter.nextId();
		userMap.put(id, new User(id, "@agent_smith"));
		
		id = idCounter.nextId();
		userMap.put(id, new User(id, "@agent_jones"));
		
		id = idCounter.nextId();
		userMap.put(id, new User(id, "@oracle"));
		
		System.out.println("users catalog created: " + userMap.toString());
	}

	public List<User> getDataList() {
		return new ArrayList<>(userMap.values());
	}

	public User getDataById(Long id) {
		return userMap.get(id);
	}
}
