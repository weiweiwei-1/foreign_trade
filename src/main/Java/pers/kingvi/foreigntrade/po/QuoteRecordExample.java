package pers.kingvi.foreigntrade.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuoteRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuoteRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_idEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andFa_idIsNull() {
            addCriterion("fa_id is null");
            return (Criteria) this;
        }

        public Criteria andFa_idIsNotNull() {
            addCriterion("fa_id is not null");
            return (Criteria) this;
        }

        public Criteria andFa_idEqualTo(Integer value) {
            addCriterion("fa_id =", value, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idNotEqualTo(Integer value) {
            addCriterion("fa_id <>", value, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idGreaterThan(Integer value) {
            addCriterion("fa_id >", value, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("fa_id >=", value, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idLessThan(Integer value) {
            addCriterion("fa_id <", value, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idLessThanOrEqualTo(Integer value) {
            addCriterion("fa_id <=", value, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idIn(List<Integer> values) {
            addCriterion("fa_id in", values, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idNotIn(List<Integer> values) {
            addCriterion("fa_id not in", values, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idBetween(Integer value1, Integer value2) {
            addCriterion("fa_id between", value1, value2, "fa_id");
            return (Criteria) this;
        }

        public Criteria andFa_idNotBetween(Integer value1, Integer value2) {
            addCriterion("fa_id not between", value1, value2, "fa_id");
            return (Criteria) this;
        }

        public Criteria andShipping_wayIsNull() {
            addCriterion("shipping_way is null");
            return (Criteria) this;
        }

        public Criteria andShipping_wayIsNotNull() {
            addCriterion("shipping_way is not null");
            return (Criteria) this;
        }

        public Criteria andShipping_wayEqualTo(String value) {
            addCriterion("shipping_way =", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayNotEqualTo(String value) {
            addCriterion("shipping_way <>", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayGreaterThan(String value) {
            addCriterion("shipping_way >", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_way >=", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayLessThan(String value) {
            addCriterion("shipping_way <", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayLessThanOrEqualTo(String value) {
            addCriterion("shipping_way <=", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayLike(String value) {
            addCriterion("shipping_way like", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayNotLike(String value) {
            addCriterion("shipping_way not like", value, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayIn(List<String> values) {
            addCriterion("shipping_way in", values, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayNotIn(List<String> values) {
            addCriterion("shipping_way not in", values, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayBetween(String value1, String value2) {
            addCriterion("shipping_way between", value1, value2, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andShipping_wayNotBetween(String value1, String value2) {
            addCriterion("shipping_way not between", value1, value2, "shipping_way");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andArrange_timeIsNull() {
            addCriterion("arrange_time is null");
            return (Criteria) this;
        }

        public Criteria andArrange_timeIsNotNull() {
            addCriterion("arrange_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrange_timeEqualTo(String value) {
            addCriterion("arrange_time =", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeNotEqualTo(String value) {
            addCriterion("arrange_time <>", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeGreaterThan(String value) {
            addCriterion("arrange_time >", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeGreaterThanOrEqualTo(String value) {
            addCriterion("arrange_time >=", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeLessThan(String value) {
            addCriterion("arrange_time <", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeLessThanOrEqualTo(String value) {
            addCriterion("arrange_time <=", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeLike(String value) {
            addCriterion("arrange_time like", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeNotLike(String value) {
            addCriterion("arrange_time not like", value, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeIn(List<String> values) {
            addCriterion("arrange_time in", values, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeNotIn(List<String> values) {
            addCriterion("arrange_time not in", values, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeBetween(String value1, String value2) {
            addCriterion("arrange_time between", value1, value2, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andArrange_timeNotBetween(String value1, String value2) {
            addCriterion("arrange_time not between", value1, value2, "arrange_time");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeIsNull() {
            addCriterion("deliver_tiime is null");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeIsNotNull() {
            addCriterion("deliver_tiime is not null");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeEqualTo(String value) {
            addCriterion("deliver_tiime =", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeNotEqualTo(String value) {
            addCriterion("deliver_tiime <>", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeGreaterThan(String value) {
            addCriterion("deliver_tiime >", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_tiime >=", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeLessThan(String value) {
            addCriterion("deliver_tiime <", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeLessThanOrEqualTo(String value) {
            addCriterion("deliver_tiime <=", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeLike(String value) {
            addCriterion("deliver_tiime like", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeNotLike(String value) {
            addCriterion("deliver_tiime not like", value, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeIn(List<String> values) {
            addCriterion("deliver_tiime in", values, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeNotIn(List<String> values) {
            addCriterion("deliver_tiime not in", values, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeBetween(String value1, String value2) {
            addCriterion("deliver_tiime between", value1, value2, "deliver_tiime");
            return (Criteria) this;
        }

        public Criteria andDeliver_tiimeNotBetween(String value1, String value2) {
            addCriterion("deliver_tiime not between", value1, value2, "deliver_tiime");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSend_timeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSend_timeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSend_timeEqualTo(Date value) {
            addCriterion("send_time =", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeGreaterThan(Date value) {
            addCriterion("send_time >", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeLessThan(Date value) {
            addCriterion("send_time <", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeIn(List<Date> values) {
            addCriterion("send_time in", values, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "send_time");
            return (Criteria) this;
        }

        public Criteria andSend_timeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "send_time");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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