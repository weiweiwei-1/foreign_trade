package pers.kingvi.foreigntrade.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendApplyExample() {
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

        public Criteria andSender_idIsNull() {
            addCriterion("sender_id is null");
            return (Criteria) this;
        }

        public Criteria andSender_idIsNotNull() {
            addCriterion("sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andSender_idEqualTo(Integer value) {
            addCriterion("sender_id =", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idNotEqualTo(Integer value) {
            addCriterion("sender_id <>", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idGreaterThan(Integer value) {
            addCriterion("sender_id >", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("sender_id >=", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idLessThan(Integer value) {
            addCriterion("sender_id <", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idLessThanOrEqualTo(Integer value) {
            addCriterion("sender_id <=", value, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idIn(List<Integer> values) {
            addCriterion("sender_id in", values, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idNotIn(List<Integer> values) {
            addCriterion("sender_id not in", values, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idBetween(Integer value1, Integer value2) {
            addCriterion("sender_id between", value1, value2, "sender_id");
            return (Criteria) this;
        }

        public Criteria andSender_idNotBetween(Integer value1, Integer value2) {
            addCriterion("sender_id not between", value1, value2, "sender_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idIsNull() {
            addCriterion("receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiver_idIsNotNull() {
            addCriterion("receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiver_idEqualTo(Integer value) {
            addCriterion("receiver_id =", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idNotEqualTo(Integer value) {
            addCriterion("receiver_id <>", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idGreaterThan(Integer value) {
            addCriterion("receiver_id >", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_id >=", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idLessThan(Integer value) {
            addCriterion("receiver_id <", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_id <=", value, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idIn(List<Integer> values) {
            addCriterion("receiver_id in", values, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idNotIn(List<Integer> values) {
            addCriterion("receiver_id not in", values, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idBetween(Integer value1, Integer value2) {
            addCriterion("receiver_id between", value1, value2, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andReceiver_idNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_id not between", value1, value2, "receiver_id");
            return (Criteria) this;
        }

        public Criteria andSender_nameIsNull() {
            addCriterion("sender_name is null");
            return (Criteria) this;
        }

        public Criteria andSender_nameIsNotNull() {
            addCriterion("sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andSender_nameEqualTo(String value) {
            addCriterion("sender_name =", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotEqualTo(String value) {
            addCriterion("sender_name <>", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameGreaterThan(String value) {
            addCriterion("sender_name >", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_name >=", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameLessThan(String value) {
            addCriterion("sender_name <", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameLessThanOrEqualTo(String value) {
            addCriterion("sender_name <=", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameLike(String value) {
            addCriterion("sender_name like", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotLike(String value) {
            addCriterion("sender_name not like", value, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameIn(List<String> values) {
            addCriterion("sender_name in", values, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotIn(List<String> values) {
            addCriterion("sender_name not in", values, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameBetween(String value1, String value2) {
            addCriterion("sender_name between", value1, value2, "sender_name");
            return (Criteria) this;
        }

        public Criteria andSender_nameNotBetween(String value1, String value2) {
            addCriterion("sender_name not between", value1, value2, "sender_name");
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