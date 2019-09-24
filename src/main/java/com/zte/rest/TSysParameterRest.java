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
import com.zte.mapper.TSysParameterMapper;
import com.zte.model.TSysParameter;
import com.zte.model.TSysParameterExample;
import com.zte.param.PageInfo;
import com.zte.common.util.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tSysParameter")
@Api(tags = "系统参数表")
public class TSysParameterRest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TSysParameterMapper tSysParameterMapper;

    @ApiOperation(value = "查询列表接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "每页条数", required = true, dataType = "Integer"),
          @ApiImplicitParam(paramType ="query",name="parameterId",value="参数id",required = false,dataType="java.lang.Long"),
@ApiImplicitParam(paramType ="query",name="parameterName",value="参数名称",required = false,dataType="java.lang.String"),
@ApiImplicitParam(paramType ="query",name="parameterValue",value="参数值",required = false,dataType="java.lang.String"),
@ApiImplicitParam(paramType ="query",name="remark",value="备注",required = false,dataType="java.lang.String"),})
    @GetMapping(value = "list/{pageNum}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult list(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
            TSysParameter item) {
        TSysParameterExample example = new TSysParameterExample();
        // 补充查询参数开始
        // 补充查询参数结束
        Page<List< TSysParameter>> page = PageHelper.startPage(pageNum, pageSize);
        List< TSysParameter> list = tSysParameterMapper.selectByExample(example);
        PageInfo info = new PageInfo(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getPages(), list);
        return JsonResult.getSuccess(info);
    }


    @ApiOperation(value = "查询单个接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "id", required = true, dataType = "Long") })
    @GetMapping(value = "item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult item(@PathVariable("id") long id) {
        return JsonResult.getSuccess(tSysParameterMapper.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "修改接口", notes = "")
    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult update(@RequestBody TSysParameter item) {
        return JsonResult.getSuccess(tSysParameterMapper.updateByPrimaryKeySelective(item));
    }

    @ApiOperation(value = "删除接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "id", required = true, dataType = "Long"), })
    @GetMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult delete(@PathVariable("id") long id) {
        return JsonResult.getSuccess(tSysParameterMapper.deleteByPrimaryKey(id));
    }

    @ApiOperation(value = "新增接口", notes = "")
    @PostMapping(value = "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult insert(@RequestBody TSysParameter item) {
        return JsonResult.getSuccess(tSysParameterMapper.insertSelective(item));
    }
    
}
