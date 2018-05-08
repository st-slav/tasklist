package ru.mamsta.exam.ibs.tasklist.api.services.util;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class IdCounter {

	private AtomicLong id;
	
	@PostConstruct
	private void init() {
		id = new AtomicLong();
		id.set(0);
	}

	public Long nextId() {
		return id.incrementAndGet();
	}
}
