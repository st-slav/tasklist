package ru.mamsta.exam.ibs.tasklist.api.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mamsta.exam.ibs.tasklist.api.model.Status;
import ru.mamsta.exam.ibs.tasklist.api.services.CatalogDataService;
import ru.mamsta.exam.ibs.tasklist.api.services.util.IdCounter;

@Service("statusService")
public class StatusServiceImpl implements CatalogDataService<Status> {
	
	@Autowired
	private IdCounter idCounter;
	
	private Map<Long, Status> statusMap;
	
	@PostConstruct
	private void init() {
		statusMap = new HashMap<>();
		Long id = idCounter.nextId();
		statusMap.put(id, new Status(id, "Новый"));
		
		id = idCounter.nextId();
		statusMap.put(id, new Status(id, "В обработке"));
		
		id = idCounter.nextId();
		statusMap.put(id, new Status(id, "Выполнен"));
		
		System.out.println("statuses catalog created: " + statusMap.toString());
	}

	public List<Status> getDataList() {
		return new ArrayList<>(statusMap.values());
	}

	public Status getDataById(Long id) {
		return statusMap.get(id);
	}
}
