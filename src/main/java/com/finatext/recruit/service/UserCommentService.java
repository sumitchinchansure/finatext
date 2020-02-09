package com.finatext.recruit.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finatext.recruit.dto.UserCommentDto;
import com.finatext.recruit.dto.UserDto;
import com.finatext.recruit.entity.UserComment;
import com.finatext.recruit.repository.UserCommentRepository;

@Service
public class UserCommentService {

	private final UserCommentRepository userCommentRepository;

	public UserCommentService(final UserCommentRepository userCommentRepository) {
		this.userCommentRepository = userCommentRepository;
	}

	public UserCommentDto getCommentById(final int id) {
		final Optional<UserComment> userComment = userCommentRepository
				.findById(id);
		if (!userComment.isPresent()) {
			throw new RuntimeException("");
		}
		return new UserCommentDto(userComment.get());
	}

	public UserCommentDto getCommentWithUserById(final int id) {
		final Optional<UserComment> userCommentOpt = userCommentRepository
				.findById(id);
		if (!userCommentOpt.isPresent()) {
			throw new RuntimeException("");
		}
		final UserComment userComment = userCommentOpt.get();
		final String uri = "https://interview-external.moneywelfare.com/users/"
				+ userComment.getUserId();
		final RestTemplate restTemplate = new RestTemplate();
		final UserDto userDto = restTemplate.getForObject(uri, UserDto.class);
		return new UserCommentDto(userComment, userDto,
				userComment.getCommentScores());
	}

}
