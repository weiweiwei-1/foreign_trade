package pers.kingvi.foreigntrade.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreightAgencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FreightAgencyExample() {
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeIsNull() {
            addCriterion("main_bussiness_scope is null");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeIsNotNull() {
            addCriterion("main_bussiness_scope is not null");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeEqualTo(String value) {
            addCriterion("main_bussiness_scope =", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeNotEqualTo(String value) {
            addCriterion("main_bussiness_scope <>", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeGreaterThan(String value) {
            addCriterion("main_bussiness_scope >", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeGreaterThanOrEqualTo(String value) {
            addCriterion("main_bussiness_scope >=", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeLessThan(String value) {
            addCriterion("main_bussiness_scope <", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeLessThanOrEqualTo(String value) {
            addCriterion("main_bussiness_scope <=", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeLike(String value) {
            addCriterion("main_bussiness_scope like", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeNotLike(String value) {
            addCriterion("main_bussiness_scope not like", value, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeIn(List<String> values) {
            addCriterion("main_bussiness_scope in", values, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeNotIn(List<String> values) {
            addCriterion("main_bussiness_scope not in", values, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeBetween(String value1, String value2) {
            addCriterion("main_bussiness_scope between", value1, value2, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andMain_bussiness_scopeNotBetween(String value1, String value2) {
            addCriterion("main_bussiness_scope not between", value1, value2, "main_bussiness_scope");
            return (Criteria) this;
        }

        public Criteria andWorking_timeIsNull() {
            addCriterion("working_time is null");
            return (Criteria) this;
        }

        public Criteria andWorking_timeIsNotNull() {
            addCriterion("working_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorking_timeEqualTo(Byte value) {
            addCriterion("working_time =", value, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeNotEqualTo(Byte value) {
            addCriterion("working_time <>", value, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeGreaterThan(Byte value) {
            addCriterion("working_time >", value, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeGreaterThanOrEqualTo(Byte value) {
            addCriterion("working_time >=", value, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeLessThan(Byte value) {
            addCriterion("working_time <", value, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeLessThanOrEqualTo(Byte value) {
            addCriterion("working_time <=", value, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeIn(List<Byte> values) {
            addCriterion("working_time in", values, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeNotIn(List<Byte> values) {
            addCriterion("working_time not in", values, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeBetween(Byte value1, Byte value2) {
            addCriterion("working_time between", value1, value2, "working_time");
            return (Criteria) this;
        }

        public Criteria andWorking_timeNotBetween(Byte value1, Byte value2) {
            addCriterion("working_time not between", value1, value2, "working_time");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Byte value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Byte value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Byte value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Byte value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Byte value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Byte> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Byte> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Byte value1, Byte value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andService_advantageIsNull() {
            addCriterion("service_advantage is null");
            return (Criteria) this;
        }

        public Criteria andService_advantageIsNotNull() {
            addCriterion("service_advantage is not null");
            return (Criteria) this;
        }

        public Criteria andService_advantageEqualTo(String value) {
            addCriterion("service_advantage =", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageNotEqualTo(String value) {
            addCriterion("service_advantage <>", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageGreaterThan(String value) {
            addCriterion("service_advantage >", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageGreaterThanOrEqualTo(String value) {
            addCriterion("service_advantage >=", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageLessThan(String value) {
            addCriterion("service_advantage <", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageLessThanOrEqualTo(String value) {
            addCriterion("service_advantage <=", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageLike(String value) {
            addCriterion("service_advantage like", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageNotLike(String value) {
            addCriterion("service_advantage not like", value, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageIn(List<String> values) {
            addCriterion("service_advantage in", values, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageNotIn(List<String> values) {
            addCriterion("service_advantage not in", values, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageBetween(String value1, String value2) {
            addCriterion("service_advantage between", value1, value2, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andService_advantageNotBetween(String value1, String value2) {
            addCriterion("service_advantage not between", value1, value2, "service_advantage");
            return (Criteria) this;
        }

        public Criteria andCompany_linkIsNull() {
            addCriterion("company_link is null");
            return (Criteria) this;
        }

        public Criteria andCompany_linkIsNotNull() {
            addCriterion("company_link is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_linkEqualTo(String value) {
            addCriterion("company_link =", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkNotEqualTo(String value) {
            addCriterion("company_link <>", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkGreaterThan(String value) {
            addCriterion("company_link >", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkGreaterThanOrEqualTo(String value) {
            addCriterion("company_link >=", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkLessThan(String value) {
            addCriterion("company_link <", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkLessThanOrEqualTo(String value) {
            addCriterion("company_link <=", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkLike(String value) {
            addCriterion("company_link like", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkNotLike(String value) {
            addCriterion("company_link not like", value, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkIn(List<String> values) {
            addCriterion("company_link in", values, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkNotIn(List<String> values) {
            addCriterion("company_link not in", values, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkBetween(String value1, String value2) {
            addCriterion("company_link between", value1, value2, "company_link");
            return (Criteria) this;
        }

        public Criteria andCompany_linkNotBetween(String value1, String value2) {
            addCriterion("company_link not between", value1, value2, "company_link");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countIsNull() {
            addCriterion("send_quote_count is null");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countIsNotNull() {
            addCriterion("send_quote_count is not null");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countEqualTo(Byte value) {
            addCriterion("send_quote_count =", value, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countNotEqualTo(Byte value) {
            addCriterion("send_quote_count <>", value, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countGreaterThan(Byte value) {
            addCriterion("send_quote_count >", value, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_quote_count >=", value, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countLessThan(Byte value) {
            addCriterion("send_quote_count <", value, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countLessThanOrEqualTo(Byte value) {
            addCriterion("send_quote_count <=", value, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countIn(List<Byte> values) {
            addCriterion("send_quote_count in", values, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countNotIn(List<Byte> values) {
            addCriterion("send_quote_count not in", values, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countBetween(Byte value1, Byte value2) {
            addCriterion("send_quote_count between", value1, value2, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andSend_quote_countNotBetween(Byte value1, Byte value2) {
            addCriterion("send_quote_count not between", value1, value2, "send_quote_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countIsNull() {
            addCriterion("advertise_count is null");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countIsNotNull() {
            addCriterion("advertise_count is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countEqualTo(Byte value) {
            addCriterion("advertise_count =", value, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countNotEqualTo(Byte value) {
            addCriterion("advertise_count <>", value, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countGreaterThan(Byte value) {
            addCriterion("advertise_count >", value, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countGreaterThanOrEqualTo(Byte value) {
            addCriterion("advertise_count >=", value, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countLessThan(Byte value) {
            addCriterion("advertise_count <", value, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countLessThanOrEqualTo(Byte value) {
            addCriterion("advertise_count <=", value, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countIn(List<Byte> values) {
            addCriterion("advertise_count in", values, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countNotIn(List<Byte> values) {
            addCriterion("advertise_count not in", values, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countBetween(Byte value1, Byte value2) {
            addCriterion("advertise_count between", value1, value2, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andAdvertise_countNotBetween(Byte value1, Byte value2) {
            addCriterion("advertise_count not between", value1, value2, "advertise_count");
            return (Criteria) this;
        }

        public Criteria andUser_statusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUser_statusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUser_statusEqualTo(String value) {
            addCriterion("user_status =", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusNotEqualTo(String value) {
            addCriterion("user_status <>", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusGreaterThan(String value) {
            addCriterion("user_status >", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusGreaterThanOrEqualTo(String value) {
            addCriterion("user_status >=", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusLessThan(String value) {
            addCriterion("user_status <", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusLessThanOrEqualTo(String value) {
            addCriterion("user_status <=", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusLike(String value) {
            addCriterion("user_status like", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusNotLike(String value) {
            addCriterion("user_status not like", value, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusIn(List<String> values) {
            addCriterion("user_status in", values, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusNotIn(List<String> values) {
            addCriterion("user_status not in", values, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusBetween(String value1, String value2) {
            addCriterion("user_status between", value1, value2, "user_status");
            return (Criteria) this;
        }

        public Criteria andUser_statusNotBetween(String value1, String value2) {
            addCriterion("user_status not between", value1, value2, "user_status");
            return (Criteria) this;
        }

        public Criteria andRegister_timeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegister_timeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegister_timeEqualTo(Date value) {
            addCriterion("register_time =", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeGreaterThan(Date value) {
            addCriterion("register_time >", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeLessThan(Date value) {
            addCriterion("register_time <", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeIn(List<Date> values) {
            addCriterion("register_time in", values, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "register_time");
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