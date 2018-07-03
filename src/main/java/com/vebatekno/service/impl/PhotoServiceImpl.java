package com.vebatekno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vebatekno.dao.PhotoDao;
import com.vebatekno.model.Photo;
import com.vebatekno.model.User;
import com.vebatekno.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private PhotoDao photoDao;
	
	@Override
	public Photo save(Photo photo) {
	
		return photoDao.save(photo);
	}

	@Override
	public List<Photo> findAll() {
	
		return photoDao.findAll();
	}

	@Override
	public List<Photo> findByUser(User user) {
		
		return photoDao.findByUser(user);
	}

	@Override
	public Photo findByPhotoId(Long photoId) {
		
		return photoDao.findByPhotoId(photoId);
	}

	
	
}
