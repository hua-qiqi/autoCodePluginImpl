package com.zte.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zte.mapper.TOperHisMapper;
import com.zte.model.TOperHis;
import com.zte.model.TOperHisExample;
import com.zte.param.PageInfo;
import com.zte.common.util.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tOperHis")
@Api(tags = "操作历史表")
public class TOperHisRest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TOperHisMapper tOperHisMapper;

	@ApiOperation(value = "查询列表接口", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "pageNum", value = "页码", required = true, dataType = "Integer"),
			@ApiImplicitParam(paramType = "path", name = "pageSize", value = "每页条数", required = true, dataType = "Integer"),
			@ApiImplicitParam(paramType = "query", name = "operHisId", value = "操作历史ID", required = false, dataType = "java.lang.Long"),
			@ApiImplicitParam(paramType = "query", name = "operUserId", value = "操作用户ID", required = false, dataType = "java.lang.Long"),
			@ApiImplicitParam(paramType = "query", name = "functionId", value = "功能ID", required = false, dataType = "java.lang.Long"),
			@ApiImplicitParam(paramType = "query", name = "operTime", value = "操作类型", required = false, dataType = "java.util.Date"),
			@ApiImplicitParam(paramType = "query", name = "operContent", value = "操作时间", required = false, dataType = "java.lang.String"),
			@ApiImplicitParam(paramType = "query", name = "remark", value = "操作内容", required = false, dataType = "java.lang.String"), })
	@GetMapping(value = "list/{pageNum}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult list(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
			TOperHis item) {
		TOperHisExample example = new TOperHisExample();
		// 补充查询参数开始
		// 补充查询参数结束
		Page<List<TOperHis>> page = PageHelper.startPage(pageNum, pageSize);
		List<TOperHis> list = tOperHisMapper.selectByExample(example);
		PageInfo info = new PageInfo(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getPages(), list);
		return JsonResult.getSuccess(info);
	}

	@ApiOperation(value = "查询单个接口", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "id", value = "id", required = true, dataType = "Long") })
	@GetMapping(value = "item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult item(@PathVariable("id") long id) {
		return JsonResult.getSuccess(tOperHisMapper.selectByPrimaryKey(id));
	}

	@ApiOperation(value = "修改接口", notes = "")
	@PostMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult update(@PathVariable("id") long id, @RequestBody TOperHis item) {
		item.setOperHisId(id);
		return JsonResult.getSuccess(tOperHisMapper.updateByPrimaryKeySelective(item));
	}

	@ApiOperation(value = "删除接口", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "id", value = "id", required = true, dataType = "Long"), })
	@GetMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult delete(@PathVariable("id") long id) {
		return JsonResult.getSuccess(tOperHisMapper.deleteByPrimaryKey(id));
	}

	@ApiOperation(value = "新增接口", notes = "")
	@PostMapping(value = "insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult insert(@RequestBody TOperHis item) {
		return JsonResult.getSuccess(tOperHisMapper.insertSelective(item));
	}

}
