package com.qf.shopping.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qf.shopping.dto.AdvertismentDto;

public interface IAdvertismentService {

	Integer findAllPage();

	List<AdvertismentDto> findAllgoods(Integer pageNo);

	void create(AdvertismentDto dto);

	void delete(Integer adId);

	AdvertismentDto findById(Integer adId);

	void update(AdvertismentDto dto);

}
