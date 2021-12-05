package com.example.performancetester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestJdbcRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TestEntity> selectAll() {
        String query = "SELECT id, value_1, value_2, value_3, value_4, value_5 FROM test_entity";
        return namedParameterJdbcTemplate.query(query, new BeanPropertyRowMapper(TestEntity.class));
    }
}
