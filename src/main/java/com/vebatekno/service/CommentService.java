package com.vebatekno.service;

import java.util.List;

import com.vebatekno.model.Comment;

public interface CommentService {

	Comment save(Comment comment);
	List<Comment> findByPhotoId(Long photoId);
	//Comment findOne(Long commentId);
	
	
}
