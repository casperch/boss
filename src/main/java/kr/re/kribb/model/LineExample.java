package kr.re.kribb.model;

import java.util.ArrayList;
import java.util.List;

public class LineExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    protected int limitStart = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    protected int limitMaxSize = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public LineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public int getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public void setLimitMaxSize(int limitMaxSize) {
        this.limitMaxSize=limitMaxSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    public int getLimitMaxSize() {
        return limitMaxSize;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGtIsNull() {
            addCriterion("GT is null");
            return (Criteria) this;
        }

        public Criteria andGtIsNotNull() {
            addCriterion("GT is not null");
            return (Criteria) this;
        }

        public Criteria andGtEqualTo(String value) {
            addCriterion("GT =", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtNotEqualTo(String value) {
            addCriterion("GT <>", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtGreaterThan(String value) {
            addCriterion("GT >", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtGreaterThanOrEqualTo(String value) {
            addCriterion("GT >=", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtLessThan(String value) {
            addCriterion("GT <", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtLessThanOrEqualTo(String value) {
            addCriterion("GT <=", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtLike(String value) {
            addCriterion("GT like", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtNotLike(String value) {
            addCriterion("GT not like", value, "gt");
            return (Criteria) this;
        }

        public Criteria andGtIn(List<String> values) {
            addCriterion("GT in", values, "gt");
            return (Criteria) this;
        }

        public Criteria andGtNotIn(List<String> values) {
            addCriterion("GT not in", values, "gt");
            return (Criteria) this;
        }

        public Criteria andGtBetween(String value1, String value2) {
            addCriterion("GT between", value1, value2, "gt");
            return (Criteria) this;
        }

        public Criteria andGtNotBetween(String value1, String value2) {
            addCriterion("GT not between", value1, value2, "gt");
            return (Criteria) this;
        }

        public Criteria andLineIsNull() {
            addCriterion("Line is null");
            return (Criteria) this;
        }

        public Criteria andLineIsNotNull() {
            addCriterion("Line is not null");
            return (Criteria) this;
        }

        public Criteria andLineEqualTo(String value) {
            addCriterion("Line =", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotEqualTo(String value) {
            addCriterion("Line <>", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThan(String value) {
            addCriterion("Line >", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThanOrEqualTo(String value) {
            addCriterion("Line >=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThan(String value) {
            addCriterion("Line <", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThanOrEqualTo(String value) {
            addCriterion("Line <=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLike(String value) {
            addCriterion("Line like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotLike(String value) {
            addCriterion("Line not like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineIn(List<String> values) {
            addCriterion("Line in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotIn(List<String> values) {
            addCriterion("Line not in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineBetween(String value1, String value2) {
            addCriterion("Line between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotBetween(String value1, String value2) {
            addCriterion("Line not between", value1, value2, "line");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table line
     *
     * @mbggenerated do_not_delete_during_merge Sat Feb 22 17:43:26 KST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
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
}