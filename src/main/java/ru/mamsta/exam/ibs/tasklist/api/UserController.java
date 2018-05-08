package ru.mamsta.exam.ibs.tasklist.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.mamsta.exam.ibs.tasklist.api.model.User;
import ru.mamsta.exam.ibs.tasklist.api.services.CatalogDataService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Resource(name = "userService")
	private CatalogDataService<User> userService;
	
	@GetMapping()
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getDataList(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<User>(userService.getDataById(id), HttpStatus.OK);
	}
}
