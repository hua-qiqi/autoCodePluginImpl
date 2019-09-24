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
import com.zte.mapper.${mapper};
import com.zte.model.${model};
import com.zte.model.${example};
import com.zte.param.PageInfo;
import com.zte.common.util.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/${mapping}")
@Api(tags = "${tags}")
public class ${class} {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ${mapper} ${mapperclass1};

    @ApiOperation(value = "查询列表接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "每页条数", required = true, dataType = "Integer"),
          ${ApiImplicitParam}})
    @GetMapping(value = "list/{pageNum}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult list(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
            ${model} item) {
        ${example} example = new ${example}();
        // 补充查询参数开始
        // 补充查询参数结束
        Page<List< ${model}>> page = PageHelper.startPage(pageNum, pageSize);
        List< ${model}> list = ${mapperclass1}.selectByExample(example);
        PageInfo info = new PageInfo(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getPages(), list);
        return JsonResult.getSuccess(info);
    }


    @ApiOperation(value = "查询单个接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "id", required = true, dataType = "Long") })
    @GetMapping(value = "item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult item(@PathVariable("id") long id) {
        return JsonResult.getSuccess(${mapperclass1}.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "修改接口", notes = "")
    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult update @RequestBody ${model} item) {
        return JsonResult.getSuccess(${mapperclass1}.updateByPrimaryKeySelective(item));
    }

    @ApiOperation(value = "删除接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "id", required = true, dataType = "Long"), })
    @GetMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult delete(@PathVariable("id") long id) {
        return JsonResult.getSuccess(${mapperclass1}.deleteByPrimaryKey(id));
    }

    @ApiOperation(value = "新增接口", notes = "")
    @PostMapping(value = "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult insert(@RequestBody ${model} item) {
        return JsonResult.getSuccess(${mapperclass1}.insertSelective(item));
    }
    
}
