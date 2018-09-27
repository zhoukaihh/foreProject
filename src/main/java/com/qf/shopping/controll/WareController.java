package com.qf.shopping.controll;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.dto.SecondTypeDto;
import com.qf.shopping.dto.WareDto;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.service.IWareService;
import com.qf.shopping.service.impl.FirstTypeService;
import com.qf.shopping.service.impl.SecondTypeSrervice;
import com.qf.shopping.util.UUIDUtils;

@Controller
@RequestMapping("/goods")
public class WareController {

	private static Logger logger = Logger.getLogger(WareController.class);

	@Autowired
	private IWareService wareService;

	@Autowired
	private SecondTypeSrervice stService;

	@Autowired
	private FirstTypeService ftService;

	@RequestMapping("/list")
	public String findByPage(Integer pageNo, Model model) {
		// 获取总页数
		Integer allPage = wareService.findAllPage();
		logger.info(allPage);
		model.addAttribute("allPage", allPage);
		// 设置分页
		int pageNo1 = pageNo.intValue();
		Integer start = new Integer((pageNo1 - 1) * 5);
		Integer length = 5;
		PageHelper.startPage(pageNo, length);
		// 获取所有商品数据
		List<WareDto> dtos = wareService.findAllgoods(pageNo);
		// 设置分页所需的pageInfo
		PageInfo<WareDto> pageInfo = new PageInfo<WareDto>(dtos);
		model.addAttribute("pageInfo", pageInfo);

		model.addAttribute("goods", dtos);
		// 设置当前页数
		model.addAttribute("currentpage", pageNo);

		return "back/goods/goodsList";
	}

	/**
	 * 查询一级类别
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/findParent")
	public String findFrist(Model model) {
		// 查询一级类别
		List<FirstTypeDto> fts = ftService.findAll();

		// 放入域对象
		model.addAttribute("firstTypes", fts);

		return "back/goods/goodsadd";
	}

	/**
	 * 根据一级id查询下属二级类别
	 * 
	 * @param firstTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findSByftId", method = RequestMethod.GET)
	public List<SecondTypeDto> findSecondByFist(Integer firstTypeId) {
		// 查询二级类别
		List<SecondTypeDto> sts = stService.findSecondByFist(firstTypeId);
		return sts;
	}

	/**
	 * 创建商品
	 * 
	 * @param dto
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/create")
	public String create(WareDto dto, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		String uploadPath = getUploadPath(file);
		dto.setGoodImage(uploadPath);
		wareService.create(dto);
		return "redirect:/goods/list?pageNo=1";
	}

	/**
	 * 上传图片并返回储存路径
	 * 
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	private String getUploadPath(MultipartFile file) throws IllegalStateException, IOException {
		String originalFilename = file.getOriginalFilename();
		String fileName = originalFilename.substring(originalFilename.indexOf("."));
		String path = (new StringBuffer(
				"D:\\doc\\CD-1802\\codes\\Shopping_sptingBoot_iBatis2\\src\\main\\webapp\\shoppingImages")
						.append(File.separator).append(UUIDUtils.getUuid()).append(fileName)).toString();

		File uploadFile = new File(path);

		file.transferTo(uploadFile);
		String path1 = path.substring(path.lastIndexOf("\\") + 1);
		return path1;
	}

	/**
	 * 通过id查询
	 * 
	 * @param goodId
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String findById(Integer goodId, Integer pageNo, Model model) {
		// 查询一级类别
		List<FirstTypeDto> fts = ftService.findAll();
		// 放入域对象
		model.addAttribute("firstTypes", fts);

		WareDto dto = wareService.findById(goodId);
		SecondType secondType = stService.findById(dto.getSecondTypeId());
		dto.setSecondType(secondType);

		model.addAttribute("good", dto);
		model.addAttribute("pageNo", pageNo);
		return "back/goods/goodupdate";
	}

	/**
	 * 修改信息
	 * 
	 * @param dto
	 * @param pageNo
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(WareDto dto, Integer pageNo, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		String uploadPath = getUploadPath(file);
		dto.setGoodImage(uploadPath);
		wareService.update(dto);
		return (new StringBuilder("redirect:/goods/list?pageNo=")).append(pageNo).toString();
	}

	/**
	 * 删除信息
	 * 
	 * @param goodId
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(Integer goodId, Integer pageNo) {
		wareService.delete(goodId);

		return (new StringBuilder("redirect:/goods/list?pageNo=")).append(pageNo).toString();
	}

	@RequestMapping("/showGoodById")
	public String showGoodById(Integer goodId, Model model) {
		WareDto good = wareService.findById(goodId);
		model.addAttribute("good", good);
		return "goodInfo";
	}

	private static final String URL = "http://120.79.233.168:8080/solr/core";

	@RequestMapping("/searchGoods")
	public String serchGoods(String searchInfo, Integer pageNo,Model model) throws SolrServerException, IOException {
		HttpSolrClient solrClient = new HttpSolrClient(URL);
		SolrQuery solrQuery = new SolrQuery();
		// 构建查询的条件
		solrQuery.add("q", "goodName:"+searchInfo);
		// 下面就可以开始查询了
		QueryResponse response = solrClient.query(solrQuery);
		// 获取查询的结果了
		SolrDocumentList documentList = response.getResults();
		// 获取查询的条目数
//		System.out.println("查询的条目数:" + list.getNumFound());
//		// 遍历这个集合
//		for (SolrDocument solrDocument : list) {
//
//			Collection<String> lists = solrDocument.getFieldNames();
//			System.out.println(lists);
//		}
		
		model.addAttribute("documentList", documentList);
		model.addAttribute("searchInfo", searchInfo);
		
		return "showSearchGoods";
	}
}
