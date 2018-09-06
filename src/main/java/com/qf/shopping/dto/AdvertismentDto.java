package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qf.shopping.pojo.Advertisment;

public class AdvertismentDto {

	private Integer adId;

	private String adType;

	private String actionUrl;

	private String imgPath;

	private Date adStartTime;

	
	public AdvertismentDto() {
	}
	
	public AdvertismentDto(Advertisment ad){
		this.adId=ad.getAdId();
		this.adType=ad.getAdType();
		this.imgPath=ad.getImgPath();
		this.actionUrl=ad.getActionUrl();
		this.adStartTime=ad.getAdStartTime();
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone="GMT+8")
	public Date getAdStartTime() {
		return adStartTime;
	}

	public void setAdStartTime(Date adStartTime) {
		this.adStartTime = adStartTime;
	}
	
	public static List<AdvertismentDto> getDtos(List<Advertisment> pos){
		List<AdvertismentDto> dtos = new ArrayList<AdvertismentDto>();
		for (Advertisment po : pos) {
			dtos.add(new AdvertismentDto(po));
		}
		return dtos;
	}
}
