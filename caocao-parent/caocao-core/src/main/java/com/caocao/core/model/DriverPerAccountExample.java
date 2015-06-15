package com.caocao.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriverPerAccountExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public DriverPerAccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
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
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
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

        public Criteria andDriverIdIsNull() {
            addCriterion("_driver_id is null");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNotNull() {
            addCriterion("_driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriverIdEqualTo(String value) {
            addCriterion("_driver_id =", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotEqualTo(String value) {
            addCriterion("_driver_id <>", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThan(String value) {
            addCriterion("_driver_id >", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThanOrEqualTo(String value) {
            addCriterion("_driver_id >=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThan(String value) {
            addCriterion("_driver_id <", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThanOrEqualTo(String value) {
            addCriterion("_driver_id <=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLike(String value) {
            addCriterion("_driver_id like", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotLike(String value) {
            addCriterion("_driver_id not like", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIn(List<String> values) {
            addCriterion("_driver_id in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotIn(List<String> values) {
            addCriterion("_driver_id not in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdBetween(String value1, String value2) {
            addCriterion("_driver_id between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotBetween(String value1, String value2) {
            addCriterion("_driver_id not between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeIsNull() {
            addCriterion("_base_income is null");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeIsNotNull() {
            addCriterion("_base_income is not null");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeEqualTo(Double value) {
            addCriterion("_base_income =", value, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeNotEqualTo(Double value) {
            addCriterion("_base_income <>", value, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeGreaterThan(Double value) {
            addCriterion("_base_income >", value, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("_base_income >=", value, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeLessThan(Double value) {
            addCriterion("_base_income <", value, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeLessThanOrEqualTo(Double value) {
            addCriterion("_base_income <=", value, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeIn(List<Double> values) {
            addCriterion("_base_income in", values, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeNotIn(List<Double> values) {
            addCriterion("_base_income not in", values, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeBetween(Double value1, Double value2) {
            addCriterion("_base_income between", value1, value2, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andBaseIncomeNotBetween(Double value1, Double value2) {
            addCriterion("_base_income not between", value1, value2, "baseIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeIsNull() {
            addCriterion("_award_income is null");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeIsNotNull() {
            addCriterion("_award_income is not null");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeEqualTo(Double value) {
            addCriterion("_award_income =", value, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeNotEqualTo(Double value) {
            addCriterion("_award_income <>", value, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeGreaterThan(Double value) {
            addCriterion("_award_income >", value, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("_award_income >=", value, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeLessThan(Double value) {
            addCriterion("_award_income <", value, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeLessThanOrEqualTo(Double value) {
            addCriterion("_award_income <=", value, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeIn(List<Double> values) {
            addCriterion("_award_income in", values, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeNotIn(List<Double> values) {
            addCriterion("_award_income not in", values, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeBetween(Double value1, Double value2) {
            addCriterion("_award_income between", value1, value2, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andAwardIncomeNotBetween(Double value1, Double value2) {
            addCriterion("_award_income not between", value1, value2, "awardIncome");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("_createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("_createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("_createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("_createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("_createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("_createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("_createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("_createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("_createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("_createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("_version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("_version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Double value) {
            addCriterion("_version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Double value) {
            addCriterion("_version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Double value) {
            addCriterion("_version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Double value) {
            addCriterion("_version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Double value) {
            addCriterion("_version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Double value) {
            addCriterion("_version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Double> values) {
            addCriterion("_version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Double> values) {
            addCriterion("_version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Double value1, Double value2) {
            addCriterion("_version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Double value1, Double value2) {
            addCriterion("_version not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated do_not_delete_during_merge Wed Jun 10 11:11:27 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
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