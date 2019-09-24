package com.zte.mapper;

import com.zte.model.TSysParameter;
import com.zte.model.TSysParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysParameterMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	long countByExample(TSysParameterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int deleteByExample(TSysParameterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int deleteByPrimaryKey(Long parameterId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int insert(TSysParameter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int insertSelective(TSysParameter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	List<TSysParameter> selectByExample(TSysParameterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	TSysParameter selectByPrimaryKey(Long parameterId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int updateByExampleSelective(@Param("record") TSysParameter record, @Param("example") TSysParameterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int updateByExample(@Param("record") TSysParameter record, @Param("example") TSysParameterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int updateByPrimaryKeySelective(TSysParameter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	int updateByPrimaryKey(TSysParameter record);
}