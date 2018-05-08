package ru.mamsta.exam.ibs.tasklist.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.mamsta.exam.ibs.tasklist.api.model.Status;
import ru.mamsta.exam.ibs.tasklist.api.services.CatalogDataService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

	@Resource(name = "statusService")
	private CatalogDataService<Status> statusService;
	
	@GetMapping()
	public ResponseEntity<List<Status>> getUsers() {
		return new ResponseEntity<List<Status>>(statusService.getDataList(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Status> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<Status>(statusService.getDataById(id), HttpStatus.OK);
	}
}
