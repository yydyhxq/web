package com.caocao.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerBillInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public CustomerBillInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
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
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
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

        public Criteria andOrderIdIsNull() {
            addCriterion("_order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("_order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("_order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("_order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("_order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("_order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("_order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("_order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("_order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("_start_price is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("_start_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(Double value) {
            addCriterion("_start_price =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(Double value) {
            addCriterion("_start_price <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(Double value) {
            addCriterion("_start_price >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("_start_price >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(Double value) {
            addCriterion("_start_price <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(Double value) {
            addCriterion("_start_price <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(List<Double> values) {
            addCriterion("_start_price in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(List<Double> values) {
            addCriterion("_start_price not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(Double value1, Double value2) {
            addCriterion("_start_price between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(Double value1, Double value2) {
            addCriterion("_start_price not between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("_distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("_distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Double value) {
            addCriterion("_distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Double value) {
            addCriterion("_distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Double value) {
            addCriterion("_distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Double value) {
            addCriterion("_distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Double value) {
            addCriterion("_distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Double value) {
            addCriterion("_distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Double> values) {
            addCriterion("_distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Double> values) {
            addCriterion("_distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Double value1, Double value2) {
            addCriterion("_distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Double value1, Double value2) {
            addCriterion("_distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteIsNull() {
            addCriterion("_driver_minute is null");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteIsNotNull() {
            addCriterion("_driver_minute is not null");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteEqualTo(Double value) {
            addCriterion("_driver_minute =", value, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteNotEqualTo(Double value) {
            addCriterion("_driver_minute <>", value, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteGreaterThan(Double value) {
            addCriterion("_driver_minute >", value, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteGreaterThanOrEqualTo(Double value) {
            addCriterion("_driver_minute >=", value, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteLessThan(Double value) {
            addCriterion("_driver_minute <", value, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteLessThanOrEqualTo(Double value) {
            addCriterion("_driver_minute <=", value, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteIn(List<Double> values) {
            addCriterion("_driver_minute in", values, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteNotIn(List<Double> values) {
            addCriterion("_driver_minute not in", values, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteBetween(Double value1, Double value2) {
            addCriterion("_driver_minute between", value1, value2, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDriverMinuteNotBetween(Double value1, Double value2) {
            addCriterion("_driver_minute not between", value1, value2, "driverMinute");
            return (Criteria) this;
        }

        public Criteria andDistancePerIsNull() {
            addCriterion("_distance_per is null");
            return (Criteria) this;
        }

        public Criteria andDistancePerIsNotNull() {
            addCriterion("_distance_per is not null");
            return (Criteria) this;
        }

        public Criteria andDistancePerEqualTo(Double value) {
            addCriterion("_distance_per =", value, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerNotEqualTo(Double value) {
            addCriterion("_distance_per <>", value, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerGreaterThan(Double value) {
            addCriterion("_distance_per >", value, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerGreaterThanOrEqualTo(Double value) {
            addCriterion("_distance_per >=", value, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerLessThan(Double value) {
            addCriterion("_distance_per <", value, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerLessThanOrEqualTo(Double value) {
            addCriterion("_distance_per <=", value, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerIn(List<Double> values) {
            addCriterion("_distance_per in", values, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerNotIn(List<Double> values) {
            addCriterion("_distance_per not in", values, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerBetween(Double value1, Double value2) {
            addCriterion("_distance_per between", value1, value2, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistancePerNotBetween(Double value1, Double value2) {
            addCriterion("_distance_per not between", value1, value2, "distancePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerIsNull() {
            addCriterion("_distance_time_per is null");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerIsNotNull() {
            addCriterion("_distance_time_per is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerEqualTo(Double value) {
            addCriterion("_distance_time_per =", value, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerNotEqualTo(Double value) {
            addCriterion("_distance_time_per <>", value, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerGreaterThan(Double value) {
            addCriterion("_distance_time_per >", value, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerGreaterThanOrEqualTo(Double value) {
            addCriterion("_distance_time_per >=", value, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerLessThan(Double value) {
            addCriterion("_distance_time_per <", value, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerLessThanOrEqualTo(Double value) {
            addCriterion("_distance_time_per <=", value, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerIn(List<Double> values) {
            addCriterion("_distance_time_per in", values, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerNotIn(List<Double> values) {
            addCriterion("_distance_time_per not in", values, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerBetween(Double value1, Double value2) {
            addCriterion("_distance_time_per between", value1, value2, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andDistanceTimePerNotBetween(Double value1, Double value2) {
            addCriterion("_distance_time_per not between", value1, value2, "distanceTimePer");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIsNull() {
            addCriterion("_cost_money is null");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIsNotNull() {
            addCriterion("_cost_money is not null");
            return (Criteria) this;
        }

        public Criteria andCostMoneyEqualTo(Double value) {
            addCriterion("_cost_money =", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotEqualTo(Double value) {
            addCriterion("_cost_money <>", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyGreaterThan(Double value) {
            addCriterion("_cost_money >", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("_cost_money >=", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyLessThan(Double value) {
            addCriterion("_cost_money <", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyLessThanOrEqualTo(Double value) {
            addCriterion("_cost_money <=", value, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyIn(List<Double> values) {
            addCriterion("_cost_money in", values, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotIn(List<Double> values) {
            addCriterion("_cost_money not in", values, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyBetween(Double value1, Double value2) {
            addCriterion("_cost_money between", value1, value2, "costMoney");
            return (Criteria) this;
        }

        public Criteria andCostMoneyNotBetween(Double value1, Double value2) {
            addCriterion("_cost_money not between", value1, value2, "costMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNull() {
            addCriterion("_discount_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNotNull() {
            addCriterion("_discount_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyEqualTo(Double value) {
            addCriterion("_discount_money =", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotEqualTo(Double value) {
            addCriterion("_discount_money <>", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThan(Double value) {
            addCriterion("_discount_money >", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("_discount_money >=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThan(Double value) {
            addCriterion("_discount_money <", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThanOrEqualTo(Double value) {
            addCriterion("_discount_money <=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIn(List<Double> values) {
            addCriterion("_discount_money in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotIn(List<Double> values) {
            addCriterion("_discount_money not in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyBetween(Double value1, Double value2) {
            addCriterion("_discount_money between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotBetween(Double value1, Double value2) {
            addCriterion("_discount_money not between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyIsNull() {
            addCriterion("_cost_real_money is null");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyIsNotNull() {
            addCriterion("_cost_real_money is not null");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyEqualTo(Double value) {
            addCriterion("_cost_real_money =", value, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyNotEqualTo(Double value) {
            addCriterion("_cost_real_money <>", value, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyGreaterThan(Double value) {
            addCriterion("_cost_real_money >", value, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("_cost_real_money >=", value, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyLessThan(Double value) {
            addCriterion("_cost_real_money <", value, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyLessThanOrEqualTo(Double value) {
            addCriterion("_cost_real_money <=", value, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyIn(List<Double> values) {
            addCriterion("_cost_real_money in", values, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyNotIn(List<Double> values) {
            addCriterion("_cost_real_money not in", values, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyBetween(Double value1, Double value2) {
            addCriterion("_cost_real_money between", value1, value2, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andCostRealMoneyNotBetween(Double value1, Double value2) {
            addCriterion("_cost_real_money not between", value1, value2, "costRealMoney");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeIsNull() {
            addCriterion("_privilege_code is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeIsNotNull() {
            addCriterion("_privilege_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeEqualTo(String value) {
            addCriterion("_privilege_code =", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeNotEqualTo(String value) {
            addCriterion("_privilege_code <>", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeGreaterThan(String value) {
            addCriterion("_privilege_code >", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_privilege_code >=", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeLessThan(String value) {
            addCriterion("_privilege_code <", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeLessThanOrEqualTo(String value) {
            addCriterion("_privilege_code <=", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeLike(String value) {
            addCriterion("_privilege_code like", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeNotLike(String value) {
            addCriterion("_privilege_code not like", value, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeIn(List<String> values) {
            addCriterion("_privilege_code in", values, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeNotIn(List<String> values) {
            addCriterion("_privilege_code not in", values, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeBetween(String value1, String value2) {
            addCriterion("_privilege_code between", value1, value2, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andPrivilegeCodeNotBetween(String value1, String value2) {
            addCriterion("_privilege_code not between", value1, value2, "privilegeCode");
            return (Criteria) this;
        }

        public Criteria andCostOtherIsNull() {
            addCriterion("_cost_other is null");
            return (Criteria) this;
        }

        public Criteria andCostOtherIsNotNull() {
            addCriterion("_cost_other is not null");
            return (Criteria) this;
        }

        public Criteria andCostOtherEqualTo(Double value) {
            addCriterion("_cost_other =", value, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherNotEqualTo(Double value) {
            addCriterion("_cost_other <>", value, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherGreaterThan(Double value) {
            addCriterion("_cost_other >", value, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherGreaterThanOrEqualTo(Double value) {
            addCriterion("_cost_other >=", value, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherLessThan(Double value) {
            addCriterion("_cost_other <", value, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherLessThanOrEqualTo(Double value) {
            addCriterion("_cost_other <=", value, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherIn(List<Double> values) {
            addCriterion("_cost_other in", values, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherNotIn(List<Double> values) {
            addCriterion("_cost_other not in", values, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherBetween(Double value1, Double value2) {
            addCriterion("_cost_other between", value1, value2, "costOther");
            return (Criteria) this;
        }

        public Criteria andCostOtherNotBetween(Double value1, Double value2) {
            addCriterion("_cost_other not between", value1, value2, "costOther");
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("_customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("_customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("_customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("_customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("_customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("_customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("_customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("_customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("_customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("_customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("_customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("_customer_id not between", value1, value2, "customerId");
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
     * This class corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 16 10:42:40 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tsp_caocao_customer_bill_info
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
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