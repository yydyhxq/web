package com.caocao.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public CouponExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
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
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
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
            addCriterion("_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("_num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("_num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("_num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("_num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("_num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("_num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("_num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("_num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("_num like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("_num not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("_num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("_num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("_num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("_num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("_money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("_money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("_money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("_money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("_money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("_money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("_money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("_money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("_money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("_money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("_money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("_money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginIsNull() {
            addCriterion("_effective_begin is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginIsNotNull() {
            addCriterion("_effective_begin is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginEqualTo(Date value) {
            addCriterion("_effective_begin =", value, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginNotEqualTo(Date value) {
            addCriterion("_effective_begin <>", value, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginGreaterThan(Date value) {
            addCriterion("_effective_begin >", value, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("_effective_begin >=", value, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginLessThan(Date value) {
            addCriterion("_effective_begin <", value, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginLessThanOrEqualTo(Date value) {
            addCriterion("_effective_begin <=", value, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginIn(List<Date> values) {
            addCriterion("_effective_begin in", values, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginNotIn(List<Date> values) {
            addCriterion("_effective_begin not in", values, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginBetween(Date value1, Date value2) {
            addCriterion("_effective_begin between", value1, value2, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveBeginNotBetween(Date value1, Date value2) {
            addCriterion("_effective_begin not between", value1, value2, "effectiveBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndIsNull() {
            addCriterion("_effective_end is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndIsNotNull() {
            addCriterion("_effective_end is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndEqualTo(Date value) {
            addCriterion("_effective_end =", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndNotEqualTo(Date value) {
            addCriterion("_effective_end <>", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndGreaterThan(Date value) {
            addCriterion("_effective_end >", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndGreaterThanOrEqualTo(Date value) {
            addCriterion("_effective_end >=", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndLessThan(Date value) {
            addCriterion("_effective_end <", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndLessThanOrEqualTo(Date value) {
            addCriterion("_effective_end <=", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndIn(List<Date> values) {
            addCriterion("_effective_end in", values, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndNotIn(List<Date> values) {
            addCriterion("_effective_end not in", values, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndBetween(Date value1, Date value2) {
            addCriterion("_effective_end between", value1, value2, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndNotBetween(Date value1, Date value2) {
            addCriterion("_effective_end not between", value1, value2, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("_customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("_customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("_customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("_customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("_customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("_customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("_customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("_customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 16 15:48:53 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_coupon
     *
     * @mbggenerated Tue Jun 16 15:48:53 CST 2015
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