package com.allen.transactionmessageservice.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public MsgExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMsgKeyIsNull() {
            addCriterion("msg_key is null");
            return (Criteria) this;
        }

        public Criteria andMsgKeyIsNotNull() {
            addCriterion("msg_key is not null");
            return (Criteria) this;
        }

        public Criteria andMsgKeyEqualTo(String value) {
            addCriterion("msg_key =", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyNotEqualTo(String value) {
            addCriterion("msg_key <>", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyGreaterThan(String value) {
            addCriterion("msg_key >", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyGreaterThanOrEqualTo(String value) {
            addCriterion("msg_key >=", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyLessThan(String value) {
            addCriterion("msg_key <", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyLessThanOrEqualTo(String value) {
            addCriterion("msg_key <=", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyLike(String value) {
            addCriterion("msg_key like", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyNotLike(String value) {
            addCriterion("msg_key not like", value, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyIn(List<String> values) {
            addCriterion("msg_key in", values, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyNotIn(List<String> values) {
            addCriterion("msg_key not in", values, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyBetween(String value1, String value2) {
            addCriterion("msg_key between", value1, value2, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgKeyNotBetween(String value1, String value2) {
            addCriterion("msg_key not between", value1, value2, "msgKey");
            return (Criteria) this;
        }

        public Criteria andMsgBodyIsNull() {
            addCriterion("msg_body is null");
            return (Criteria) this;
        }

        public Criteria andMsgBodyIsNotNull() {
            addCriterion("msg_body is not null");
            return (Criteria) this;
        }

        public Criteria andMsgBodyEqualTo(String value) {
            addCriterion("msg_body =", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotEqualTo(String value) {
            addCriterion("msg_body <>", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyGreaterThan(String value) {
            addCriterion("msg_body >", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyGreaterThanOrEqualTo(String value) {
            addCriterion("msg_body >=", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyLessThan(String value) {
            addCriterion("msg_body <", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyLessThanOrEqualTo(String value) {
            addCriterion("msg_body <=", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyLike(String value) {
            addCriterion("msg_body like", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotLike(String value) {
            addCriterion("msg_body not like", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyIn(List<String> values) {
            addCriterion("msg_body in", values, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotIn(List<String> values) {
            addCriterion("msg_body not in", values, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyBetween(String value1, String value2) {
            addCriterion("msg_body between", value1, value2, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotBetween(String value1, String value2) {
            addCriterion("msg_body not between", value1, value2, "msgBody");
            return (Criteria) this;
        }

        public Criteria andSourceServiceIsNull() {
            addCriterion("source_service is null");
            return (Criteria) this;
        }

        public Criteria andSourceServiceIsNotNull() {
            addCriterion("source_service is not null");
            return (Criteria) this;
        }

        public Criteria andSourceServiceEqualTo(String value) {
            addCriterion("source_service =", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceNotEqualTo(String value) {
            addCriterion("source_service <>", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceGreaterThan(String value) {
            addCriterion("source_service >", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceGreaterThanOrEqualTo(String value) {
            addCriterion("source_service >=", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceLessThan(String value) {
            addCriterion("source_service <", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceLessThanOrEqualTo(String value) {
            addCriterion("source_service <=", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceLike(String value) {
            addCriterion("source_service like", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceNotLike(String value) {
            addCriterion("source_service not like", value, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceIn(List<String> values) {
            addCriterion("source_service in", values, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceNotIn(List<String> values) {
            addCriterion("source_service not in", values, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceBetween(String value1, String value2) {
            addCriterion("source_service between", value1, value2, "sourceService");
            return (Criteria) this;
        }

        public Criteria andSourceServiceNotBetween(String value1, String value2) {
            addCriterion("source_service not between", value1, value2, "sourceService");
            return (Criteria) this;
        }

        public Criteria andQueueNameIsNull() {
            addCriterion("queue_name is null");
            return (Criteria) this;
        }

        public Criteria andQueueNameIsNotNull() {
            addCriterion("queue_name is not null");
            return (Criteria) this;
        }

        public Criteria andQueueNameEqualTo(String value) {
            addCriterion("queue_name =", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotEqualTo(String value) {
            addCriterion("queue_name <>", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameGreaterThan(String value) {
            addCriterion("queue_name >", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameGreaterThanOrEqualTo(String value) {
            addCriterion("queue_name >=", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameLessThan(String value) {
            addCriterion("queue_name <", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameLessThanOrEqualTo(String value) {
            addCriterion("queue_name <=", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameLike(String value) {
            addCriterion("queue_name like", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotLike(String value) {
            addCriterion("queue_name not like", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameIn(List<String> values) {
            addCriterion("queue_name in", values, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotIn(List<String> values) {
            addCriterion("queue_name not in", values, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameBetween(String value1, String value2) {
            addCriterion("queue_name between", value1, value2, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotBetween(String value1, String value2) {
            addCriterion("queue_name not between", value1, value2, "queueName");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountIsNull() {
            addCriterion("max_retry_count is null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountIsNotNull() {
            addCriterion("max_retry_count is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountEqualTo(Integer value) {
            addCriterion("max_retry_count =", value, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountNotEqualTo(Integer value) {
            addCriterion("max_retry_count <>", value, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountGreaterThan(Integer value) {
            addCriterion("max_retry_count >", value, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_retry_count >=", value, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountLessThan(Integer value) {
            addCriterion("max_retry_count <", value, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountLessThanOrEqualTo(Integer value) {
            addCriterion("max_retry_count <=", value, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountIn(List<Integer> values) {
            addCriterion("max_retry_count in", values, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountNotIn(List<Integer> values) {
            addCriterion("max_retry_count not in", values, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_count between", value1, value2, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andMaxRetryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("max_retry_count not between", value1, value2, "maxRetryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNull() {
            addCriterion("retry_count is null");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNotNull() {
            addCriterion("retry_count is not null");
            return (Criteria) this;
        }

        public Criteria andRetryCountEqualTo(Integer value) {
            addCriterion("retry_count =", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotEqualTo(Integer value) {
            addCriterion("retry_count <>", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThan(Integer value) {
            addCriterion("retry_count >", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry_count >=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThan(Integer value) {
            addCriterion("retry_count <", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThanOrEqualTo(Integer value) {
            addCriterion("retry_count <=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountIn(List<Integer> values) {
            addCriterion("retry_count in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotIn(List<Integer> values) {
            addCriterion("retry_count not in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountBetween(Integer value1, Integer value2) {
            addCriterion("retry_count between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("retry_count not between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriIsNull() {
            addCriterion("source_states_uri is null");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriIsNotNull() {
            addCriterion("source_states_uri is not null");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriEqualTo(String value) {
            addCriterion("source_states_uri =", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriNotEqualTo(String value) {
            addCriterion("source_states_uri <>", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriGreaterThan(String value) {
            addCriterion("source_states_uri >", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriGreaterThanOrEqualTo(String value) {
            addCriterion("source_states_uri >=", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriLessThan(String value) {
            addCriterion("source_states_uri <", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriLessThanOrEqualTo(String value) {
            addCriterion("source_states_uri <=", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriLike(String value) {
            addCriterion("source_states_uri like", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriNotLike(String value) {
            addCriterion("source_states_uri not like", value, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriIn(List<String> values) {
            addCriterion("source_states_uri in", values, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriNotIn(List<String> values) {
            addCriterion("source_states_uri not in", values, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriBetween(String value1, String value2) {
            addCriterion("source_states_uri between", value1, value2, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andSourceStatesUriNotBetween(String value1, String value2) {
            addCriterion("source_states_uri not between", value1, value2, "sourceStatesUri");
            return (Criteria) this;
        }

        public Criteria andMsgStateIsNull() {
            addCriterion("msg_state is null");
            return (Criteria) this;
        }

        public Criteria andMsgStateIsNotNull() {
            addCriterion("msg_state is not null");
            return (Criteria) this;
        }

        public Criteria andMsgStateEqualTo(Integer value) {
            addCriterion("msg_state =", value, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateNotEqualTo(Integer value) {
            addCriterion("msg_state <>", value, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateGreaterThan(Integer value) {
            addCriterion("msg_state >", value, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_state >=", value, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateLessThan(Integer value) {
            addCriterion("msg_state <", value, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateLessThanOrEqualTo(Integer value) {
            addCriterion("msg_state <=", value, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateIn(List<Integer> values) {
            addCriterion("msg_state in", values, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateNotIn(List<Integer> values) {
            addCriterion("msg_state not in", values, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateBetween(Integer value1, Integer value2) {
            addCriterion("msg_state between", value1, value2, "msgState");
            return (Criteria) this;
        }

        public Criteria andMsgStateNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_state not between", value1, value2, "msgState");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayIsNull() {
            addCriterion("timeout_delay is null");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayIsNotNull() {
            addCriterion("timeout_delay is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayEqualTo(Integer value) {
            addCriterion("timeout_delay =", value, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayNotEqualTo(Integer value) {
            addCriterion("timeout_delay <>", value, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayGreaterThan(Integer value) {
            addCriterion("timeout_delay >", value, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeout_delay >=", value, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayLessThan(Integer value) {
            addCriterion("timeout_delay <", value, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayLessThanOrEqualTo(Integer value) {
            addCriterion("timeout_delay <=", value, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayIn(List<Integer> values) {
            addCriterion("timeout_delay in", values, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayNotIn(List<Integer> values) {
            addCriterion("timeout_delay not in", values, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayBetween(Integer value1, Integer value2) {
            addCriterion("timeout_delay between", value1, value2, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("timeout_delay not between", value1, value2, "timeoutDelay");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeIsNull() {
            addCriterion("timeout_time is null");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeIsNotNull() {
            addCriterion("timeout_time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeEqualTo(Date value) {
            addCriterion("timeout_time =", value, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeNotEqualTo(Date value) {
            addCriterion("timeout_time <>", value, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeGreaterThan(Date value) {
            addCriterion("timeout_time >", value, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("timeout_time >=", value, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeLessThan(Date value) {
            addCriterion("timeout_time <", value, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeLessThanOrEqualTo(Date value) {
            addCriterion("timeout_time <=", value, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeIn(List<Date> values) {
            addCriterion("timeout_time in", values, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeNotIn(List<Date> values) {
            addCriterion("timeout_time not in", values, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeBetween(Date value1, Date value2) {
            addCriterion("timeout_time between", value1, value2, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutTimeNotBetween(Date value1, Date value2) {
            addCriterion("timeout_time not between", value1, value2, "timeoutTime");
            return (Criteria) this;
        }

        public Criteria andIsDeadIsNull() {
            addCriterion("is_dead is null");
            return (Criteria) this;
        }

        public Criteria andIsDeadIsNotNull() {
            addCriterion("is_dead is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeadEqualTo(Boolean value) {
            addCriterion("is_dead =", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadNotEqualTo(Boolean value) {
            addCriterion("is_dead <>", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadGreaterThan(Boolean value) {
            addCriterion("is_dead >", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_dead >=", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadLessThan(Boolean value) {
            addCriterion("is_dead <", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadLessThanOrEqualTo(Boolean value) {
            addCriterion("is_dead <=", value, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadIn(List<Boolean> values) {
            addCriterion("is_dead in", values, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadNotIn(List<Boolean> values) {
            addCriterion("is_dead not in", values, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadBetween(Boolean value1, Boolean value2) {
            addCriterion("is_dead between", value1, value2, "isDead");
            return (Criteria) this;
        }

        public Criteria andIsDeadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_dead not between", value1, value2, "isDead");
            return (Criteria) this;
        }
    }

    /**
     */
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