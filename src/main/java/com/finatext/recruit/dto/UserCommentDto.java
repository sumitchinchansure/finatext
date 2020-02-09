package com.finatext.recruit.dto;

import java.util.LinkedList;
import java.util.List;
import com.finatext.recruit.entity.CommentScore;
import com.finatext.recruit.entity.UserComment;
import java.time.format.DateTimeFormatter;

public class UserCommentDto {
	private int id;

	private int userId;

	private String comment;

	private String createdAt;

	private UserDto user;

	private List<CommentScoreDto> commentScores;

	public UserCommentDto(final UserComment userComment) {
		id = userComment.getId();
		userId = userComment.getUserId();
		comment = userComment.getComment();
		createdAt = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(userComment.getCreatedAt());
	}

	public UserCommentDto(final UserComment userComment, final UserDto user,
			final List<CommentScore> comeScores) {
		this(userComment);
		this.user = user;
		if (comeScores != null && comeScores.size() > 0) {
			commentScores = new LinkedList<>();
			for (final CommentScore score : comeScores) {
				commentScores.add(new CommentScoreDto(score));
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(final int userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final String createdAt) {
		this.createdAt = createdAt;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(final UserDto user) {
		this.user = user;
	}

	public List<CommentScoreDto> getCommentScores() {
		return commentScores;
	}

	public void setCommentScores(final List<CommentScoreDto> commentScores) {
		this.commentScores = commentScores;
	}
}
