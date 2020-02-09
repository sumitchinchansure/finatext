package com.finatext.recruit.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finatext.recruit.dto.UserCommentDto;
import com.finatext.recruit.service.UserCommentService;

@RestController
public class UserCommentController {

	private final UserCommentService userCommentService;

	public UserCommentController(final UserCommentService userCommentService) {
		this.userCommentService = userCommentService;
	}

	@CrossOrigin("*")
	@GetMapping("/v1/comment/{id}")
	public UserCommentDto getCommentById(@PathVariable("id") final int id) {
		return userCommentService.getCommentById(id);
	}

	@CrossOrigin("*")
	@GetMapping("/v2/comment/{id}")
	public UserCommentDto getCommentWithUserById(
			@PathVariable("id") final int id) {
		return userCommentService.getCommentWithUserById(id);
	}

}
