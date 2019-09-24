package com.zte.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
        
public class TSysParameter implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_parameter.parameter_id
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	private Long parameterId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_parameter.parameter_name
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	private String parameterName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_parameter.parameter_value
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	private String parameterValue;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_parameter.remark
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_parameter.parameter_id
	 * @return  the value of t_sys_parameter.parameter_id
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public Long getParameterId() {
		return parameterId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_parameter.parameter_id
	 * @param parameterId  the value for t_sys_parameter.parameter_id
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_parameter.parameter_name
	 * @return  the value of t_sys_parameter.parameter_name
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_parameter.parameter_name
	 * @param parameterName  the value for t_sys_parameter.parameter_name
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName == null ? null : parameterName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_parameter.parameter_value
	 * @return  the value of t_sys_parameter.parameter_value
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public String getParameterValue() {
		return parameterValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_parameter.parameter_value
	 * @param parameterValue  the value for t_sys_parameter.parameter_value
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue == null ? null : parameterValue.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_parameter.remark
	 * @return  the value of t_sys_parameter.remark
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_parameter.remark
	 * @param remark  the value for t_sys_parameter.remark
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		TSysParameter other = (TSysParameter) that;
		return (this.getParameterId() == null ? other.getParameterId() == null
				: this.getParameterId().equals(other.getParameterId()))
				&& (this.getParameterName() == null ? other.getParameterName() == null
						: this.getParameterName().equals(other.getParameterName()))
				&& (this.getParameterValue() == null ? other.getParameterValue() == null
						: this.getParameterValue().equals(other.getParameterValue()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getParameterId() == null) ? 0 : getParameterId().hashCode());
		result = prime * result + ((getParameterName() == null) ? 0 : getParameterName().hashCode());
		result = prime * result + ((getParameterValue() == null) ? 0 : getParameterValue().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_sys_parameter
	 * @mbg.generated  Mon Sep 23 17:26:31 CST 2019
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", parameterId=").append(parameterId);
		sb.append(", parameterName=").append(parameterName);
		sb.append(", parameterValue=").append(parameterValue);
		sb.append(", remark=").append(remark);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}