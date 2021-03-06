package kr.re.kribb.model;

import java.util.ArrayList;
import java.util.List;

public class GeneInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected int limitStart = -1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected int limitMaxSize = -1;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public GeneInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public int getLimitStart() {
		return limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setLimitMaxSize(int limitMaxSize) {
		this.limitMaxSize = limitMaxSize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public int getLimitMaxSize() {
		return limitMaxSize;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andChromIsNull() {
			addCriterion("chrom is null");
			return (Criteria) this;
		}

		public Criteria andChromIsNotNull() {
			addCriterion("chrom is not null");
			return (Criteria) this;
		}

		public Criteria andChromEqualTo(String value) {
			addCriterion("chrom =", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromNotEqualTo(String value) {
			addCriterion("chrom <>", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromGreaterThan(String value) {
			addCriterion("chrom >", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromGreaterThanOrEqualTo(String value) {
			addCriterion("chrom >=", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromLessThan(String value) {
			addCriterion("chrom <", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromLessThanOrEqualTo(String value) {
			addCriterion("chrom <=", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromLike(String value) {
			addCriterion("chrom like", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromNotLike(String value) {
			addCriterion("chrom not like", value, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromIn(List<String> values) {
			addCriterion("chrom in", values, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromNotIn(List<String> values) {
			addCriterion("chrom not in", values, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromBetween(String value1, String value2) {
			addCriterion("chrom between", value1, value2, "chrom");
			return (Criteria) this;
		}

		public Criteria andChromNotBetween(String value1, String value2) {
			addCriterion("chrom not between", value1, value2, "chrom");
			return (Criteria) this;
		}

		public Criteria andStartIsNull() {
			addCriterion("start is null");
			return (Criteria) this;
		}

		public Criteria andStartIsNotNull() {
			addCriterion("start is not null");
			return (Criteria) this;
		}

		public Criteria andStartEqualTo(Integer value) {
			addCriterion("start =", value, "start");
			return (Criteria) this;
		}

		public Criteria andStartNotEqualTo(Integer value) {
			addCriterion("start <>", value, "start");
			return (Criteria) this;
		}

		public Criteria andStartGreaterThan(Integer value) {
			addCriterion("start >", value, "start");
			return (Criteria) this;
		}

		public Criteria andStartGreaterThanOrEqualTo(Integer value) {
			addCriterion("start >=", value, "start");
			return (Criteria) this;
		}

		public Criteria andStartLessThan(Integer value) {
			addCriterion("start <", value, "start");
			return (Criteria) this;
		}

		public Criteria andStartLessThanOrEqualTo(Integer value) {
			addCriterion("start <=", value, "start");
			return (Criteria) this;
		}

		public Criteria andStartIn(List<Integer> values) {
			addCriterion("start in", values, "start");
			return (Criteria) this;
		}

		public Criteria andStartNotIn(List<Integer> values) {
			addCriterion("start not in", values, "start");
			return (Criteria) this;
		}

		public Criteria andStartBetween(Integer value1, Integer value2) {
			addCriterion("start between", value1, value2, "start");
			return (Criteria) this;
		}

		public Criteria andStartNotBetween(Integer value1, Integer value2) {
			addCriterion("start not between", value1, value2, "start");
			return (Criteria) this;
		}

		public Criteria andEndIsNull() {
			addCriterion("end is null");
			return (Criteria) this;
		}

		public Criteria andEndIsNotNull() {
			addCriterion("end is not null");
			return (Criteria) this;
		}

		public Criteria andEndEqualTo(Integer value) {
			addCriterion("end =", value, "end");
			return (Criteria) this;
		}

		public Criteria andEndNotEqualTo(Integer value) {
			addCriterion("end <>", value, "end");
			return (Criteria) this;
		}

		public Criteria andEndGreaterThan(Integer value) {
			addCriterion("end >", value, "end");
			return (Criteria) this;
		}

		public Criteria andEndGreaterThanOrEqualTo(Integer value) {
			addCriterion("end >=", value, "end");
			return (Criteria) this;
		}

		public Criteria andEndLessThan(Integer value) {
			addCriterion("end <", value, "end");
			return (Criteria) this;
		}

		public Criteria andEndLessThanOrEqualTo(Integer value) {
			addCriterion("end <=", value, "end");
			return (Criteria) this;
		}

		public Criteria andEndIn(List<Integer> values) {
			addCriterion("end in", values, "end");
			return (Criteria) this;
		}

		public Criteria andEndNotIn(List<Integer> values) {
			addCriterion("end not in", values, "end");
			return (Criteria) this;
		}

		public Criteria andEndBetween(Integer value1, Integer value2) {
			addCriterion("end between", value1, value2, "end");
			return (Criteria) this;
		}

		public Criteria andEndNotBetween(Integer value1, Integer value2) {
			addCriterion("end not between", value1, value2, "end");
			return (Criteria) this;
		}

		public Criteria andStrandIsNull() {
			addCriterion("strand is null");
			return (Criteria) this;
		}

		public Criteria andStrandIsNotNull() {
			addCriterion("strand is not null");
			return (Criteria) this;
		}

		public Criteria andStrandEqualTo(String value) {
			addCriterion("strand =", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandNotEqualTo(String value) {
			addCriterion("strand <>", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandGreaterThan(String value) {
			addCriterion("strand >", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandGreaterThanOrEqualTo(String value) {
			addCriterion("strand >=", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandLessThan(String value) {
			addCriterion("strand <", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandLessThanOrEqualTo(String value) {
			addCriterion("strand <=", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandLike(String value) {
			addCriterion("strand like", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandNotLike(String value) {
			addCriterion("strand not like", value, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandIn(List<String> values) {
			addCriterion("strand in", values, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandNotIn(List<String> values) {
			addCriterion("strand not in", values, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandBetween(String value1, String value2) {
			addCriterion("strand between", value1, value2, "strand");
			return (Criteria) this;
		}

		public Criteria andStrandNotBetween(String value1, String value2) {
			addCriterion("strand not between", value1, value2, "strand");
			return (Criteria) this;
		}

		public Criteria andGeneIsNull() {
			addCriterion("gene is null");
			return (Criteria) this;
		}

		public Criteria andGeneIsNotNull() {
			addCriterion("gene is not null");
			return (Criteria) this;
		}

		public Criteria andGeneEqualTo(String value) {
			addCriterion("gene =", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneNotEqualTo(String value) {
			addCriterion("gene <>", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneGreaterThan(String value) {
			addCriterion("gene >", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneGreaterThanOrEqualTo(String value) {
			addCriterion("gene >=", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneLessThan(String value) {
			addCriterion("gene <", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneLessThanOrEqualTo(String value) {
			addCriterion("gene <=", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneLike(String value) {
			addCriterion("gene like", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneNotLike(String value) {
			addCriterion("gene not like", value, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneIn(List<String> values) {
			addCriterion("gene in", values, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneNotIn(List<String> values) {
			addCriterion("gene not in", values, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneBetween(String value1, String value2) {
			addCriterion("gene between", value1, value2, "gene");
			return (Criteria) this;
		}

		public Criteria andGeneNotBetween(String value1, String value2) {
			addCriterion("gene not between", value1, value2, "gene");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2,
					"description");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table GeneInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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
     * This class corresponds to the database table GeneInfo
     *
     * @mbggenerated do_not_delete_during_merge Mon Feb 10 16:44:02 KST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}