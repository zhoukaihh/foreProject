package com.qf.shopping.controll;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qf.shopping.dto.AdvertismentDto;
import com.qf.shopping.service.IAdvertismentService;
import com.qf.shopping.util.UUIDUtils;


@Controller
@RequestMapping("/ads")
public class AdvertismenController {

	private static Logger logger = Logger.getLogger(AdvertismenController.class);
	
	@Autowired
	private IAdvertismentService adService;

	/**
	 * 获取所有信息
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String findByPage(Integer pageNo, Model model) {
		// 获取总页数
		Integer allPage = adService.findAllPage();
		model.addAttribute("allPage", allPage);
		// 获取所有商品数据
		List<AdvertismentDto> dtos = adService.findAllgoods(pageNo);
		model.addAttribute("ads", dtos);
		// 设置当前页数
		model.addAttribute("currentpage", pageNo);

		return "back/Ad/adList";
	}
	
	/**
	 * 创建广告
	 * @param adType
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value ="/create",method=RequestMethod.POST)
	public String create(AdvertismentDto dto,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		String originalFilename = file.getOriginalFilename();
		String fileName = originalFilename.substring(originalFilename.indexOf("."));
		String path = (new StringBuffer("D:\\doc\\CD-1802\\codes\\Shopping_sptingBoot_iBatis2\\src\\main\\webapp\\shoppingImages")
				.append(File.separator).append(UUIDUtils.getUuid()).append(fileName)).toString();
		
		File uploadFile = new File(path);
		
		file.transferTo(uploadFile);	
		String path1 = path.substring(path.lastIndexOf("\\")+1);
//			String path1 = getUploadPath(file);
			logger.info(path1);
			dto.setImgPath(path1);
			logger.info(path1);
			adService.create(dto);
		return "redirect:/ads/list?pageNo=1";
	}
	
	/**
	 * 上传图片并返回储存路径
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 
	private String getUploadPath(MultipartFile file) throws IllegalStateException, IOException {
		String originalFilename = file.getOriginalFilename();
		String fileName = originalFilename.substring(originalFilename.indexOf("."));
		String path = (new StringBuffer("D:\\doc\\CD-1802\\codes\\Shopping_sptingBoot_iBatis2\\src\\main\\webapp\\shoppingImages")
				.append(File.separator).append(UUIDUtils.getUuid()).append(fileName)).toString();
		
		File uploadFile = new File(path);
		
		file.transferTo(uploadFile);	
		String path1 = path.substring(path.lastIndexOf("\\")+1);
		return path1;
	}*/

	@RequestMapping("/getAll")
	public List<AdvertismentDto> findAll(){
		List<AdvertismentDto> dtos = adService.findAll();
		return dtos;
	}
	
	/**
	 * 通过id查询广告
	 * @param adId
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer adId,Integer pageNo,Model model){
		
		AdvertismentDto dto = adService.findById(adId);
		model.addAttribute("ad", dto);
		model.addAttribute("pageNo", pageNo);
		return "back/Ad/adupdate";
	}
	
	/**
	 * 修改信息
	 * @param dto
	 * @param pageNo
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(AdvertismentDto dto,Integer pageNo,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		String originalFilename = file.getOriginalFilename();
		String fileName = originalFilename.substring(originalFilename.indexOf("."));
		String path = (new StringBuffer("D:\\doc\\CD-1802\\codes\\Shopping_sptingBoot_iBatis2\\src\\main\\webapp\\shoppingImages")
				.append(File.separator).append(UUIDUtils.getUuid()).append(fileName)).toString();
		
		File uploadFile = new File(path);
		
		file.transferTo(uploadFile);	
		String path1 = path.substring(path.lastIndexOf("\\")+1);
//		String path = getUploadPath(file);
		dto.setImgPath(path1);
		adService.update(dto);
		return (new StringBuilder("redirect:/ads/list?pageNo=")).append(pageNo).toString();
		
	}
	
	
	/**
	 * 删除信息
	 * @param adId
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(Integer adId,Integer pageNo){
		adService.delete(adId);
		return (new StringBuilder("redirect:/ads/list?pageNo=")).append(pageNo).toString();
	}
	
	
}
