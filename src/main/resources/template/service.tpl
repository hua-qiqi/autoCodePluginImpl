package com.zte.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zte.mapper.${mapper};
import com.zte.model.${model};
import com.zte.model.${example};
import com.zte.param.PageInfo;

@Service
public class ${serviceClass} {

	@Autowired
	private ${mapper} ${mapper1};

	/**
	 * 条件查询、满足所有条件组合查询
	 * @param pageNum 页码
	 * @param pageSize   分页大小
	 * @param item  查询条件对象
	 * @return 分页对象PageInfo
	 */
	public PageInfo selectList(int pageNum, int pageSize, ${model} item) {
		${example} example = null;
		// 补充查询参数开始
		if (item != null) {
			example = new ${example}();
			${example}.Criteria criteria = example.createCriteria();
			${params}
		}
		// 补充查询参数结束
		Page<List<${model}>> page = PageHelper.startPage(pageNum, pageSize);
		List<${model}> list = ${mapper1}.selectByExample(example);
		PageInfo info = new PageInfo(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getPages(), list);
		return info;
	}

	/**
	 * 通过主键查询
	 * @param id 主键id
	 * @return
	 */
	public ${model} selectOne(Long id)

	{
		return  ${mapper1}.selectByPrimaryKey(id);
	}

	/**
	 * 通过主键删除
	 * @param id 主键id
	 * @return
	 */
	public int delete(Long id) {
		return  ${mapper1}.deleteByPrimaryKey(id);
	}

	/**
	 * 更新对象
	 * @param item 
	 * @return
	 */
	public int update(${model} item)

	{
		return  ${mapper1}.updateByPrimaryKeySelective(item);
	}

	/**
	 * 插入对象
	 * @param item
	 * @return
	 */
	public int insert(${model} item)

	{
		return  ${mapper1}.insertSelective(item);
	}

}
