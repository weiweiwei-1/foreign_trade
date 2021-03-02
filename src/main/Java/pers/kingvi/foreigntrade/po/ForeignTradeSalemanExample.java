package pers.kingvi.foreigntrade.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForeignTradeSalemanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForeignTradeSalemanExample() {
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

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
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

        public Criteria andMain_productIsNull() {
            addCriterion("main_product is null");
            return (Criteria) this;
        }

        public Criteria andMain_productIsNotNull() {
            addCriterion("main_product is not null");
            return (Criteria) this;
        }

        public Criteria andMain_productEqualTo(String value) {
            addCriterion("main_product =", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productNotEqualTo(String value) {
            addCriterion("main_product <>", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productGreaterThan(String value) {
            addCriterion("main_product >", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productGreaterThanOrEqualTo(String value) {
            addCriterion("main_product >=", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productLessThan(String value) {
            addCriterion("main_product <", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productLessThanOrEqualTo(String value) {
            addCriterion("main_product <=", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productLike(String value) {
            addCriterion("main_product like", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productNotLike(String value) {
            addCriterion("main_product not like", value, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productIn(List<String> values) {
            addCriterion("main_product in", values, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productNotIn(List<String> values) {
            addCriterion("main_product not in", values, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productBetween(String value1, String value2) {
            addCriterion("main_product between", value1, value2, "main_product");
            return (Criteria) this;
        }

        public Criteria andMain_productNotBetween(String value1, String value2) {
            addCriterion("main_product not between", value1, value2, "main_product");
            return (Criteria) this;
        }

        public Criteria andStore_linkIsNull() {
            addCriterion("store_link is null");
            return (Criteria) this;
        }

        public Criteria andStore_linkIsNotNull() {
            addCriterion("store_link is not null");
            return (Criteria) this;
        }

        public Criteria andStore_linkEqualTo(String value) {
            addCriterion("store_link =", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkNotEqualTo(String value) {
            addCriterion("store_link <>", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkGreaterThan(String value) {
            addCriterion("store_link >", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkGreaterThanOrEqualTo(String value) {
            addCriterion("store_link >=", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkLessThan(String value) {
            addCriterion("store_link <", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkLessThanOrEqualTo(String value) {
            addCriterion("store_link <=", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkLike(String value) {
            addCriterion("store_link like", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkNotLike(String value) {
            addCriterion("store_link not like", value, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkIn(List<String> values) {
            addCriterion("store_link in", values, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkNotIn(List<String> values) {
            addCriterion("store_link not in", values, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkBetween(String value1, String value2) {
            addCriterion("store_link between", value1, value2, "store_link");
            return (Criteria) this;
        }

        public Criteria andStore_linkNotBetween(String value1, String value2) {
            addCriterion("store_link not between", value1, value2, "store_link");
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

        public Criteria andSend_product_countIsNull() {
            addCriterion("send_product_count is null");
            return (Criteria) this;
        }

        public Criteria andSend_product_countIsNotNull() {
            addCriterion("send_product_count is not null");
            return (Criteria) this;
        }

        public Criteria andSend_product_countEqualTo(Byte value) {
            addCriterion("send_product_count =", value, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countNotEqualTo(Byte value) {
            addCriterion("send_product_count <>", value, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countGreaterThan(Byte value) {
            addCriterion("send_product_count >", value, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_product_count >=", value, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countLessThan(Byte value) {
            addCriterion("send_product_count <", value, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countLessThanOrEqualTo(Byte value) {
            addCriterion("send_product_count <=", value, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countIn(List<Byte> values) {
            addCriterion("send_product_count in", values, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countNotIn(List<Byte> values) {
            addCriterion("send_product_count not in", values, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countBetween(Byte value1, Byte value2) {
            addCriterion("send_product_count between", value1, value2, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andSend_product_countNotBetween(Byte value1, Byte value2) {
            addCriterion("send_product_count not between", value1, value2, "send_product_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countIsNull() {
            addCriterion("demand_count is null");
            return (Criteria) this;
        }

        public Criteria andDemand_countIsNotNull() {
            addCriterion("demand_count is not null");
            return (Criteria) this;
        }

        public Criteria andDemand_countEqualTo(Byte value) {
            addCriterion("demand_count =", value, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countNotEqualTo(Byte value) {
            addCriterion("demand_count <>", value, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countGreaterThan(Byte value) {
            addCriterion("demand_count >", value, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countGreaterThanOrEqualTo(Byte value) {
            addCriterion("demand_count >=", value, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countLessThan(Byte value) {
            addCriterion("demand_count <", value, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countLessThanOrEqualTo(Byte value) {
            addCriterion("demand_count <=", value, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countIn(List<Byte> values) {
            addCriterion("demand_count in", values, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countNotIn(List<Byte> values) {
            addCriterion("demand_count not in", values, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countBetween(Byte value1, Byte value2) {
            addCriterion("demand_count between", value1, value2, "demand_count");
            return (Criteria) this;
        }

        public Criteria andDemand_countNotBetween(Byte value1, Byte value2) {
            addCriterion("demand_count not between", value1, value2, "demand_count");
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