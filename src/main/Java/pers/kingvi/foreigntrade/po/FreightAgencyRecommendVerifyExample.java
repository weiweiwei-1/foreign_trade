package pers.kingvi.foreigntrade.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreightAgencyRecommendVerifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FreightAgencyRecommendVerifyExample() {
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

        public Criteria andFa_nameIsNull() {
            addCriterion("fa_name is null");
            return (Criteria) this;
        }

        public Criteria andFa_nameIsNotNull() {
            addCriterion("fa_name is not null");
            return (Criteria) this;
        }

        public Criteria andFa_nameEqualTo(String value) {
            addCriterion("fa_name =", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameNotEqualTo(String value) {
            addCriterion("fa_name <>", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameGreaterThan(String value) {
            addCriterion("fa_name >", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameGreaterThanOrEqualTo(String value) {
            addCriterion("fa_name >=", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameLessThan(String value) {
            addCriterion("fa_name <", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameLessThanOrEqualTo(String value) {
            addCriterion("fa_name <=", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameLike(String value) {
            addCriterion("fa_name like", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameNotLike(String value) {
            addCriterion("fa_name not like", value, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameIn(List<String> values) {
            addCriterion("fa_name in", values, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameNotIn(List<String> values) {
            addCriterion("fa_name not in", values, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameBetween(String value1, String value2) {
            addCriterion("fa_name between", value1, value2, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_nameNotBetween(String value1, String value2) {
            addCriterion("fa_name not between", value1, value2, "fa_name");
            return (Criteria) this;
        }

        public Criteria andFa_companyIsNull() {
            addCriterion("fa_company is null");
            return (Criteria) this;
        }

        public Criteria andFa_companyIsNotNull() {
            addCriterion("fa_company is not null");
            return (Criteria) this;
        }

        public Criteria andFa_companyEqualTo(String value) {
            addCriterion("fa_company =", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyNotEqualTo(String value) {
            addCriterion("fa_company <>", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyGreaterThan(String value) {
            addCriterion("fa_company >", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyGreaterThanOrEqualTo(String value) {
            addCriterion("fa_company >=", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyLessThan(String value) {
            addCriterion("fa_company <", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyLessThanOrEqualTo(String value) {
            addCriterion("fa_company <=", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyLike(String value) {
            addCriterion("fa_company like", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyNotLike(String value) {
            addCriterion("fa_company not like", value, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyIn(List<String> values) {
            addCriterion("fa_company in", values, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyNotIn(List<String> values) {
            addCriterion("fa_company not in", values, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyBetween(String value1, String value2) {
            addCriterion("fa_company between", value1, value2, "fa_company");
            return (Criteria) this;
        }

        public Criteria andFa_companyNotBetween(String value1, String value2) {
            addCriterion("fa_company not between", value1, value2, "fa_company");
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

        public Criteria andFa_cityIsNull() {
            addCriterion("fa_city is null");
            return (Criteria) this;
        }

        public Criteria andFa_cityIsNotNull() {
            addCriterion("fa_city is not null");
            return (Criteria) this;
        }

        public Criteria andFa_cityEqualTo(String value) {
            addCriterion("fa_city =", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityNotEqualTo(String value) {
            addCriterion("fa_city <>", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityGreaterThan(String value) {
            addCriterion("fa_city >", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityGreaterThanOrEqualTo(String value) {
            addCriterion("fa_city >=", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityLessThan(String value) {
            addCriterion("fa_city <", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityLessThanOrEqualTo(String value) {
            addCriterion("fa_city <=", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityLike(String value) {
            addCriterion("fa_city like", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityNotLike(String value) {
            addCriterion("fa_city not like", value, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityIn(List<String> values) {
            addCriterion("fa_city in", values, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityNotIn(List<String> values) {
            addCriterion("fa_city not in", values, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityBetween(String value1, String value2) {
            addCriterion("fa_city between", value1, value2, "fa_city");
            return (Criteria) this;
        }

        public Criteria andFa_cityNotBetween(String value1, String value2) {
            addCriterion("fa_city not between", value1, value2, "fa_city");
            return (Criteria) this;
        }

        public Criteria andKey_wordsIsNull() {
            addCriterion("key_words is null");
            return (Criteria) this;
        }

        public Criteria andKey_wordsIsNotNull() {
            addCriterion("key_words is not null");
            return (Criteria) this;
        }

        public Criteria andKey_wordsEqualTo(String value) {
            addCriterion("key_words =", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsNotEqualTo(String value) {
            addCriterion("key_words <>", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsGreaterThan(String value) {
            addCriterion("key_words >", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsGreaterThanOrEqualTo(String value) {
            addCriterion("key_words >=", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsLessThan(String value) {
            addCriterion("key_words <", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsLessThanOrEqualTo(String value) {
            addCriterion("key_words <=", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsLike(String value) {
            addCriterion("key_words like", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsNotLike(String value) {
            addCriterion("key_words not like", value, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsIn(List<String> values) {
            addCriterion("key_words in", values, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsNotIn(List<String> values) {
            addCriterion("key_words not in", values, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsBetween(String value1, String value2) {
            addCriterion("key_words between", value1, value2, "key_words");
            return (Criteria) this;
        }

        public Criteria andKey_wordsNotBetween(String value1, String value2) {
            addCriterion("key_words not between", value1, value2, "key_words");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andActivity_photoIsNull() {
            addCriterion("activity_photo is null");
            return (Criteria) this;
        }

        public Criteria andActivity_photoIsNotNull() {
            addCriterion("activity_photo is not null");
            return (Criteria) this;
        }

        public Criteria andActivity_photoEqualTo(String value) {
            addCriterion("activity_photo =", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoNotEqualTo(String value) {
            addCriterion("activity_photo <>", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoGreaterThan(String value) {
            addCriterion("activity_photo >", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoGreaterThanOrEqualTo(String value) {
            addCriterion("activity_photo >=", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoLessThan(String value) {
            addCriterion("activity_photo <", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoLessThanOrEqualTo(String value) {
            addCriterion("activity_photo <=", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoLike(String value) {
            addCriterion("activity_photo like", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoNotLike(String value) {
            addCriterion("activity_photo not like", value, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoIn(List<String> values) {
            addCriterion("activity_photo in", values, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoNotIn(List<String> values) {
            addCriterion("activity_photo not in", values, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoBetween(String value1, String value2) {
            addCriterion("activity_photo between", value1, value2, "activity_photo");
            return (Criteria) this;
        }

        public Criteria andActivity_photoNotBetween(String value1, String value2) {
            addCriterion("activity_photo not between", value1, value2, "activity_photo");
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