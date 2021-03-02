package pers.kingvi.foreigntrade.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForeignTradeSalemanDemandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForeignTradeSalemanDemandExample() {
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

        public Criteria andFts_idIsNull() {
            addCriterion("fts_id is null");
            return (Criteria) this;
        }

        public Criteria andFts_idIsNotNull() {
            addCriterion("fts_id is not null");
            return (Criteria) this;
        }

        public Criteria andFts_idEqualTo(Integer value) {
            addCriterion("fts_id =", value, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idNotEqualTo(Integer value) {
            addCriterion("fts_id <>", value, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idGreaterThan(Integer value) {
            addCriterion("fts_id >", value, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("fts_id >=", value, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idLessThan(Integer value) {
            addCriterion("fts_id <", value, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idLessThanOrEqualTo(Integer value) {
            addCriterion("fts_id <=", value, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idIn(List<Integer> values) {
            addCriterion("fts_id in", values, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idNotIn(List<Integer> values) {
            addCriterion("fts_id not in", values, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idBetween(Integer value1, Integer value2) {
            addCriterion("fts_id between", value1, value2, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_idNotBetween(Integer value1, Integer value2) {
            addCriterion("fts_id not between", value1, value2, "fts_id");
            return (Criteria) this;
        }

        public Criteria andFts_nameIsNull() {
            addCriterion("fts_name is null");
            return (Criteria) this;
        }

        public Criteria andFts_nameIsNotNull() {
            addCriterion("fts_name is not null");
            return (Criteria) this;
        }

        public Criteria andFts_nameEqualTo(String value) {
            addCriterion("fts_name =", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameNotEqualTo(String value) {
            addCriterion("fts_name <>", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameGreaterThan(String value) {
            addCriterion("fts_name >", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameGreaterThanOrEqualTo(String value) {
            addCriterion("fts_name >=", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameLessThan(String value) {
            addCriterion("fts_name <", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameLessThanOrEqualTo(String value) {
            addCriterion("fts_name <=", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameLike(String value) {
            addCriterion("fts_name like", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameNotLike(String value) {
            addCriterion("fts_name not like", value, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameIn(List<String> values) {
            addCriterion("fts_name in", values, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameNotIn(List<String> values) {
            addCriterion("fts_name not in", values, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameBetween(String value1, String value2) {
            addCriterion("fts_name between", value1, value2, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_nameNotBetween(String value1, String value2) {
            addCriterion("fts_name not between", value1, value2, "fts_name");
            return (Criteria) this;
        }

        public Criteria andFts_companyIsNull() {
            addCriterion("fts_company is null");
            return (Criteria) this;
        }

        public Criteria andFts_companyIsNotNull() {
            addCriterion("fts_company is not null");
            return (Criteria) this;
        }

        public Criteria andFts_companyEqualTo(String value) {
            addCriterion("fts_company =", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyNotEqualTo(String value) {
            addCriterion("fts_company <>", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyGreaterThan(String value) {
            addCriterion("fts_company >", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyGreaterThanOrEqualTo(String value) {
            addCriterion("fts_company >=", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyLessThan(String value) {
            addCriterion("fts_company <", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyLessThanOrEqualTo(String value) {
            addCriterion("fts_company <=", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyLike(String value) {
            addCriterion("fts_company like", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyNotLike(String value) {
            addCriterion("fts_company not like", value, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyIn(List<String> values) {
            addCriterion("fts_company in", values, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyNotIn(List<String> values) {
            addCriterion("fts_company not in", values, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyBetween(String value1, String value2) {
            addCriterion("fts_company between", value1, value2, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_companyNotBetween(String value1, String value2) {
            addCriterion("fts_company not between", value1, value2, "fts_company");
            return (Criteria) this;
        }

        public Criteria andFts_cityIsNull() {
            addCriterion("fts_city is null");
            return (Criteria) this;
        }

        public Criteria andFts_cityIsNotNull() {
            addCriterion("fts_city is not null");
            return (Criteria) this;
        }

        public Criteria andFts_cityEqualTo(String value) {
            addCriterion("fts_city =", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityNotEqualTo(String value) {
            addCriterion("fts_city <>", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityGreaterThan(String value) {
            addCriterion("fts_city >", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityGreaterThanOrEqualTo(String value) {
            addCriterion("fts_city >=", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityLessThan(String value) {
            addCriterion("fts_city <", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityLessThanOrEqualTo(String value) {
            addCriterion("fts_city <=", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityLike(String value) {
            addCriterion("fts_city like", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityNotLike(String value) {
            addCriterion("fts_city not like", value, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityIn(List<String> values) {
            addCriterion("fts_city in", values, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityNotIn(List<String> values) {
            addCriterion("fts_city not in", values, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityBetween(String value1, String value2) {
            addCriterion("fts_city between", value1, value2, "fts_city");
            return (Criteria) this;
        }

        public Criteria andFts_cityNotBetween(String value1, String value2) {
            addCriterion("fts_city not between", value1, value2, "fts_city");
            return (Criteria) this;
        }

        public Criteria andMain_businessIsNull() {
            addCriterion("main_business is null");
            return (Criteria) this;
        }

        public Criteria andMain_businessIsNotNull() {
            addCriterion("main_business is not null");
            return (Criteria) this;
        }

        public Criteria andMain_businessEqualTo(String value) {
            addCriterion("main_business =", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessNotEqualTo(String value) {
            addCriterion("main_business <>", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessGreaterThan(String value) {
            addCriterion("main_business >", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessGreaterThanOrEqualTo(String value) {
            addCriterion("main_business >=", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessLessThan(String value) {
            addCriterion("main_business <", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessLessThanOrEqualTo(String value) {
            addCriterion("main_business <=", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessLike(String value) {
            addCriterion("main_business like", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessNotLike(String value) {
            addCriterion("main_business not like", value, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessIn(List<String> values) {
            addCriterion("main_business in", values, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessNotIn(List<String> values) {
            addCriterion("main_business not in", values, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessBetween(String value1, String value2) {
            addCriterion("main_business between", value1, value2, "main_business");
            return (Criteria) this;
        }

        public Criteria andMain_businessNotBetween(String value1, String value2) {
            addCriterion("main_business not between", value1, value2, "main_business");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNull() {
            addCriterion("requirement is null");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNotNull() {
            addCriterion("requirement is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementEqualTo(String value) {
            addCriterion("requirement =", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotEqualTo(String value) {
            addCriterion("requirement <>", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThan(String value) {
            addCriterion("requirement >", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("requirement >=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThan(String value) {
            addCriterion("requirement <", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThanOrEqualTo(String value) {
            addCriterion("requirement <=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLike(String value) {
            addCriterion("requirement like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotLike(String value) {
            addCriterion("requirement not like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementIn(List<String> values) {
            addCriterion("requirement in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotIn(List<String> values) {
            addCriterion("requirement not in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementBetween(String value1, String value2) {
            addCriterion("requirement between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotBetween(String value1, String value2) {
            addCriterion("requirement not between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionIsNull() {
            addCriterion("demand_description is null");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionIsNotNull() {
            addCriterion("demand_description is not null");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionEqualTo(String value) {
            addCriterion("demand_description =", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionNotEqualTo(String value) {
            addCriterion("demand_description <>", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionGreaterThan(String value) {
            addCriterion("demand_description >", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionGreaterThanOrEqualTo(String value) {
            addCriterion("demand_description >=", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionLessThan(String value) {
            addCriterion("demand_description <", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionLessThanOrEqualTo(String value) {
            addCriterion("demand_description <=", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionLike(String value) {
            addCriterion("demand_description like", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionNotLike(String value) {
            addCriterion("demand_description not like", value, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionIn(List<String> values) {
            addCriterion("demand_description in", values, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionNotIn(List<String> values) {
            addCriterion("demand_description not in", values, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionBetween(String value1, String value2) {
            addCriterion("demand_description between", value1, value2, "demand_description");
            return (Criteria) this;
        }

        public Criteria andDemand_descriptionNotBetween(String value1, String value2) {
            addCriterion("demand_description not between", value1, value2, "demand_description");
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

        public Criteria andVerify_statusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerify_statusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerify_statusEqualTo(String value) {
            addCriterion("verify_status =", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusNotEqualTo(String value) {
            addCriterion("verify_status <>", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusGreaterThan(String value) {
            addCriterion("verify_status >", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusGreaterThanOrEqualTo(String value) {
            addCriterion("verify_status >=", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusLessThan(String value) {
            addCriterion("verify_status <", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusLessThanOrEqualTo(String value) {
            addCriterion("verify_status <=", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusLike(String value) {
            addCriterion("verify_status like", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusNotLike(String value) {
            addCriterion("verify_status not like", value, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusIn(List<String> values) {
            addCriterion("verify_status in", values, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusNotIn(List<String> values) {
            addCriterion("verify_status not in", values, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusBetween(String value1, String value2) {
            addCriterion("verify_status between", value1, value2, "verify_status");
            return (Criteria) this;
        }

        public Criteria andVerify_statusNotBetween(String value1, String value2) {
            addCriterion("verify_status not between", value1, value2, "verify_status");
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