package com.finatext.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finatext.recruit.entity.UserComment;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Integer>{

}
