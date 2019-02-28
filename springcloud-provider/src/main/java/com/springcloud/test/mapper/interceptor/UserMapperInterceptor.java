package com.springcloud.test.mapper.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-12-3 8:45
 * @Company www.midea.com
 */
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )})
@Component
public class UserMapperInterceptor implements Interceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("intercept|经过拦截器处理");
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            String selectId = mappedStatement.getId();
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            // 分页参数作为参数对象parameterObject的一个属性
            String sql = boundSql.getSql();
            sql = appendSql(sql);
            metaStatementHandler.setValue("delegate.boundSql.sql", sql);
            logger.info("intercept|selectId={},sql={}", selectId, sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        logger.info("intercept|经过拦截器处理1");
        if (o instanceof StatementHandler) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("intercept|经过拦截器处理2");
    }

    private String appendSql(String sql) {
        StringBuilder sb = new StringBuilder();
        if (sql.toLowerCase().indexOf("order") > 0) {
            String[] array = sql.split("order");
            sb.append(array[0]);
            sb.append(" AND id > 5");
            sb.append(" order ");
            sb.append(array[1]);
        } else {
            if (sql.toLowerCase().indexOf("where") > 0) {
                sb.append(sql);
                sb.append(" AND id > 5");
            }
        }
        return sb.toString();
    }
}
