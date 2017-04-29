package co.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.md.bean.UserRequest;
import co.md.bean.UserResponse;
import co.md.exception.ServiceException;
import co.md.model.entity.User;
import co.md.service.UserService;
import co.md.util.UserUtils;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			User user = UserUtils.fromWebToDomain(userRequest);
			user = userService.saveUser(user, userRequest.getCampaignId());
			UserResponse response = UserUtils.fromDomainToWeb(user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
