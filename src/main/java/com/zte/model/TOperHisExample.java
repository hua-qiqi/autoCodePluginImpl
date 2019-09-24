package com.zte.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOperHisExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public TOperHisExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andOperHisIdIsNull() {
			addCriterion("oper_his_id is null");
			return (Criteria) this;
		}

		public Criteria andOperHisIdIsNotNull() {
			addCriterion("oper_his_id is not null");
			return (Criteria) this;
		}

		public Criteria andOperHisIdEqualTo(Long value) {
			addCriterion("oper_his_id =", value, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdNotEqualTo(Long value) {
			addCriterion("oper_his_id <>", value, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdGreaterThan(Long value) {
			addCriterion("oper_his_id >", value, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdGreaterThanOrEqualTo(Long value) {
			addCriterion("oper_his_id >=", value, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdLessThan(Long value) {
			addCriterion("oper_his_id <", value, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdLessThanOrEqualTo(Long value) {
			addCriterion("oper_his_id <=", value, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdIn(List<Long> values) {
			addCriterion("oper_his_id in", values, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdNotIn(List<Long> values) {
			addCriterion("oper_his_id not in", values, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdBetween(Long value1, Long value2) {
			addCriterion("oper_his_id between", value1, value2, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperHisIdNotBetween(Long value1, Long value2) {
			addCriterion("oper_his_id not between", value1, value2, "operHisId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdIsNull() {
			addCriterion("oper_user_id is null");
			return (Criteria) this;
		}

		public Criteria andOperUserIdIsNotNull() {
			addCriterion("oper_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andOperUserIdEqualTo(Long value) {
			addCriterion("oper_user_id =", value, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdNotEqualTo(Long value) {
			addCriterion("oper_user_id <>", value, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdGreaterThan(Long value) {
			addCriterion("oper_user_id >", value, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("oper_user_id >=", value, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdLessThan(Long value) {
			addCriterion("oper_user_id <", value, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdLessThanOrEqualTo(Long value) {
			addCriterion("oper_user_id <=", value, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdIn(List<Long> values) {
			addCriterion("oper_user_id in", values, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdNotIn(List<Long> values) {
			addCriterion("oper_user_id not in", values, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdBetween(Long value1, Long value2) {
			addCriterion("oper_user_id between", value1, value2, "operUserId");
			return (Criteria) this;
		}

		public Criteria andOperUserIdNotBetween(Long value1, Long value2) {
			addCriterion("oper_user_id not between", value1, value2, "operUserId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdIsNull() {
			addCriterion("function_id is null");
			return (Criteria) this;
		}

		public Criteria andFunctionIdIsNotNull() {
			addCriterion("function_id is not null");
			return (Criteria) this;
		}

		public Criteria andFunctionIdEqualTo(Long value) {
			addCriterion("function_id =", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotEqualTo(Long value) {
			addCriterion("function_id <>", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdGreaterThan(Long value) {
			addCriterion("function_id >", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("function_id >=", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdLessThan(Long value) {
			addCriterion("function_id <", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdLessThanOrEqualTo(Long value) {
			addCriterion("function_id <=", value, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdIn(List<Long> values) {
			addCriterion("function_id in", values, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotIn(List<Long> values) {
			addCriterion("function_id not in", values, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdBetween(Long value1, Long value2) {
			addCriterion("function_id between", value1, value2, "functionId");
			return (Criteria) this;
		}

		public Criteria andFunctionIdNotBetween(Long value1, Long value2) {
			addCriterion("function_id not between", value1, value2, "functionId");
			return (Criteria) this;
		}

		public Criteria andOperTimeIsNull() {
			addCriterion("oper_time is null");
			return (Criteria) this;
		}

		public Criteria andOperTimeIsNotNull() {
			addCriterion("oper_time is not null");
			return (Criteria) this;
		}

		public Criteria andOperTimeEqualTo(Date value) {
			addCriterion("oper_time =", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeNotEqualTo(Date value) {
			addCriterion("oper_time <>", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeGreaterThan(Date value) {
			addCriterion("oper_time >", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("oper_time >=", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeLessThan(Date value) {
			addCriterion("oper_time <", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeLessThanOrEqualTo(Date value) {
			addCriterion("oper_time <=", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeIn(List<Date> values) {
			addCriterion("oper_time in", values, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeNotIn(List<Date> values) {
			addCriterion("oper_time not in", values, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeBetween(Date value1, Date value2) {
			addCriterion("oper_time between", value1, value2, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeNotBetween(Date value1, Date value2) {
			addCriterion("oper_time not between", value1, value2, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperContentIsNull() {
			addCriterion("oper_content is null");
			return (Criteria) this;
		}

		public Criteria andOperContentIsNotNull() {
			addCriterion("oper_content is not null");
			return (Criteria) this;
		}

		public Criteria andOperContentEqualTo(String value) {
			addCriterion("oper_content =", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentNotEqualTo(String value) {
			addCriterion("oper_content <>", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentGreaterThan(String value) {
			addCriterion("oper_content >", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentGreaterThanOrEqualTo(String value) {
			addCriterion("oper_content >=", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentLessThan(String value) {
			addCriterion("oper_content <", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentLessThanOrEqualTo(String value) {
			addCriterion("oper_content <=", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentLike(String value) {
			addCriterion("oper_content like", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentNotLike(String value) {
			addCriterion("oper_content not like", value, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentIn(List<String> values) {
			addCriterion("oper_content in", values, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentNotIn(List<String> values) {
			addCriterion("oper_content not in", values, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentBetween(String value1, String value2) {
			addCriterion("oper_content between", value1, value2, "operContent");
			return (Criteria) this;
		}

		public Criteria andOperContentNotBetween(String value1, String value2) {
			addCriterion("oper_content not between", value1, value2, "operContent");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_oper_his
	 * @mbg.generated  Mon Sep 23 16:37:18 CST 2019
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_oper_his
     *
     * @mbg.generated do_not_delete_during_merge Mon Sep 23 16:35:24 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}