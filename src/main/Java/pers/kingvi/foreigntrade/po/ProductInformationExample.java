package pers.kingvi.foreigntrade.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductInformationExample() {
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

        public Criteria andProduct_nameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameEqualTo(String value) {
            addCriterion("product_name =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThan(String value) {
            addCriterion("product_name >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThan(String value) {
            addCriterion("product_name <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLike(String value) {
            addCriterion("product_name like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotLike(String value) {
            addCriterion("product_name not like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIn(List<String> values) {
            addCriterion("product_name in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(String value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(String value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(String value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(String value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(String value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(String value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLike(String value) {
            addCriterion("origin like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotLike(String value) {
            addCriterion("origin not like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<String> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<String> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(String value1, String value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(String value1, String value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andVolumnIsNull() {
            addCriterion("volumn is null");
            return (Criteria) this;
        }

        public Criteria andVolumnIsNotNull() {
            addCriterion("volumn is not null");
            return (Criteria) this;
        }

        public Criteria andVolumnEqualTo(String value) {
            addCriterion("volumn =", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotEqualTo(String value) {
            addCriterion("volumn <>", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnGreaterThan(String value) {
            addCriterion("volumn >", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnGreaterThanOrEqualTo(String value) {
            addCriterion("volumn >=", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLessThan(String value) {
            addCriterion("volumn <", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLessThanOrEqualTo(String value) {
            addCriterion("volumn <=", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLike(String value) {
            addCriterion("volumn like", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotLike(String value) {
            addCriterion("volumn not like", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnIn(List<String> values) {
            addCriterion("volumn in", values, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotIn(List<String> values) {
            addCriterion("volumn not in", values, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnBetween(String value1, String value2) {
            addCriterion("volumn between", value1, value2, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotBetween(String value1, String value2) {
            addCriterion("volumn not between", value1, value2, "volumn");
            return (Criteria) this;
        }

        public Criteria andTime_requirementIsNull() {
            addCriterion("time_requirement is null");
            return (Criteria) this;
        }

        public Criteria andTime_requirementIsNotNull() {
            addCriterion("time_requirement is not null");
            return (Criteria) this;
        }

        public Criteria andTime_requirementEqualTo(String value) {
            addCriterion("time_requirement =", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementNotEqualTo(String value) {
            addCriterion("time_requirement <>", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementGreaterThan(String value) {
            addCriterion("time_requirement >", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementGreaterThanOrEqualTo(String value) {
            addCriterion("time_requirement >=", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementLessThan(String value) {
            addCriterion("time_requirement <", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementLessThanOrEqualTo(String value) {
            addCriterion("time_requirement <=", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementLike(String value) {
            addCriterion("time_requirement like", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementNotLike(String value) {
            addCriterion("time_requirement not like", value, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementIn(List<String> values) {
            addCriterion("time_requirement in", values, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementNotIn(List<String> values) {
            addCriterion("time_requirement not in", values, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementBetween(String value1, String value2) {
            addCriterion("time_requirement between", value1, value2, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andTime_requirementNotBetween(String value1, String value2) {
            addCriterion("time_requirement not between", value1, value2, "time_requirement");
            return (Criteria) this;
        }

        public Criteria andChargerIsNull() {
            addCriterion("charger is null");
            return (Criteria) this;
        }

        public Criteria andChargerIsNotNull() {
            addCriterion("charger is not null");
            return (Criteria) this;
        }

        public Criteria andChargerEqualTo(String value) {
            addCriterion("charger =", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerNotEqualTo(String value) {
            addCriterion("charger <>", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerGreaterThan(String value) {
            addCriterion("charger >", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerGreaterThanOrEqualTo(String value) {
            addCriterion("charger >=", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerLessThan(String value) {
            addCriterion("charger <", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerLessThanOrEqualTo(String value) {
            addCriterion("charger <=", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerLike(String value) {
            addCriterion("charger like", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerNotLike(String value) {
            addCriterion("charger not like", value, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerIn(List<String> values) {
            addCriterion("charger in", values, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerNotIn(List<String> values) {
            addCriterion("charger not in", values, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerBetween(String value1, String value2) {
            addCriterion("charger between", value1, value2, "charger");
            return (Criteria) this;
        }

        public Criteria andChargerNotBetween(String value1, String value2) {
            addCriterion("charger not between", value1, value2, "charger");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("certificate like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("certificate not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andReal_orderIsNull() {
            addCriterion("real_order is null");
            return (Criteria) this;
        }

        public Criteria andReal_orderIsNotNull() {
            addCriterion("real_order is not null");
            return (Criteria) this;
        }

        public Criteria andReal_orderEqualTo(String value) {
            addCriterion("real_order =", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderNotEqualTo(String value) {
            addCriterion("real_order <>", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderGreaterThan(String value) {
            addCriterion("real_order >", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderGreaterThanOrEqualTo(String value) {
            addCriterion("real_order >=", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderLessThan(String value) {
            addCriterion("real_order <", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderLessThanOrEqualTo(String value) {
            addCriterion("real_order <=", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderLike(String value) {
            addCriterion("real_order like", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderNotLike(String value) {
            addCriterion("real_order not like", value, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderIn(List<String> values) {
            addCriterion("real_order in", values, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderNotIn(List<String> values) {
            addCriterion("real_order not in", values, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderBetween(String value1, String value2) {
            addCriterion("real_order between", value1, value2, "real_order");
            return (Criteria) this;
        }

        public Criteria andReal_orderNotBetween(String value1, String value2) {
            addCriterion("real_order not between", value1, value2, "real_order");
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

        public Criteria andQuote_countIsNull() {
            addCriterion("quote_count is null");
            return (Criteria) this;
        }

        public Criteria andQuote_countIsNotNull() {
            addCriterion("quote_count is not null");
            return (Criteria) this;
        }

        public Criteria andQuote_countEqualTo(Byte value) {
            addCriterion("quote_count =", value, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countNotEqualTo(Byte value) {
            addCriterion("quote_count <>", value, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countGreaterThan(Byte value) {
            addCriterion("quote_count >", value, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countGreaterThanOrEqualTo(Byte value) {
            addCriterion("quote_count >=", value, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countLessThan(Byte value) {
            addCriterion("quote_count <", value, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countLessThanOrEqualTo(Byte value) {
            addCriterion("quote_count <=", value, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countIn(List<Byte> values) {
            addCriterion("quote_count in", values, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countNotIn(List<Byte> values) {
            addCriterion("quote_count not in", values, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countBetween(Byte value1, Byte value2) {
            addCriterion("quote_count between", value1, value2, "quote_count");
            return (Criteria) this;
        }

        public Criteria andQuote_countNotBetween(Byte value1, Byte value2) {
            addCriterion("quote_count not between", value1, value2, "quote_count");
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