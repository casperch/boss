package kr.re.kribb.model;

import java.util.ArrayList;
import java.util.List;

public class TraitExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected int limitStart = -1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected int limitMaxSize = -1;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public TraitExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public int getLimitStart() {
		return limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public void setLimitMaxSize(int limitMaxSize) {
		this.limitMaxSize = limitMaxSize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trait
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	public int getLimitMaxSize() {
		return limitMaxSize;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table trait
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

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCommonnameIsNull() {
			addCriterion("commonName is null");
			return (Criteria) this;
		}

		public Criteria andCommonnameIsNotNull() {
			addCriterion("commonName is not null");
			return (Criteria) this;
		}

		public Criteria andCommonnameEqualTo(String value) {
			addCriterion("commonName =", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameNotEqualTo(String value) {
			addCriterion("commonName <>", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameGreaterThan(String value) {
			addCriterion("commonName >", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameGreaterThanOrEqualTo(String value) {
			addCriterion("commonName >=", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameLessThan(String value) {
			addCriterion("commonName <", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameLessThanOrEqualTo(String value) {
			addCriterion("commonName <=", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameLike(String value) {
			addCriterion("commonName like", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameNotLike(String value) {
			addCriterion("commonName not like", value, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameIn(List<String> values) {
			addCriterion("commonName in", values, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameNotIn(List<String> values) {
			addCriterion("commonName not in", values, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameBetween(String value1, String value2) {
			addCriterion("commonName between", value1, value2, "commonname");
			return (Criteria) this;
		}

		public Criteria andCommonnameNotBetween(String value1, String value2) {
			addCriterion("commonName not between", value1, value2, "commonname");
			return (Criteria) this;
		}

		public Criteria andTraitIsNull() {
			addCriterion("trait is null");
			return (Criteria) this;
		}

		public Criteria andTraitIsNotNull() {
			addCriterion("trait is not null");
			return (Criteria) this;
		}

		public Criteria andTraitEqualTo(String value) {
			addCriterion("trait =", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitNotEqualTo(String value) {
			addCriterion("trait <>", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitGreaterThan(String value) {
			addCriterion("trait >", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitGreaterThanOrEqualTo(String value) {
			addCriterion("trait >=", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitLessThan(String value) {
			addCriterion("trait <", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitLessThanOrEqualTo(String value) {
			addCriterion("trait <=", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitLike(String value) {
			addCriterion("trait like", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitNotLike(String value) {
			addCriterion("trait not like", value, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitIn(List<String> values) {
			addCriterion("trait in", values, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitNotIn(List<String> values) {
			addCriterion("trait not in", values, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitBetween(String value1, String value2) {
			addCriterion("trait between", value1, value2, "trait");
			return (Criteria) this;
		}

		public Criteria andTraitNotBetween(String value1, String value2) {
			addCriterion("trait not between", value1, value2, "trait");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table trait
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
     * This class corresponds to the database table trait
     *
     * @mbggenerated do_not_delete_during_merge Tue Jul 29 20:54:18 KST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}