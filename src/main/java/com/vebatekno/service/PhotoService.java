package com.vebatekno.service;

import java.util.List;

import com.vebatekno.model.Photo;
import com.vebatekno.model.User;

public interface PhotoService {

	Photo save(Photo photo);
	List<Photo> findAll();
	List<Photo> findByUser(User user);
	Photo findByPhotoId(Long photoId);
	
	
	
}
