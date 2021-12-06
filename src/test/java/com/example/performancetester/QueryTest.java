package com.example.performancetester;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class QueryTest {

    @Autowired
    TestJdbcRepository testJdbcRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestMapper testMapper;

    @Autowired
    EntityManager em;

    @Autowired
    QuerydslRepository querydslRepository;

//    @BeforeEach
//    void init() {
//        List<TestEntity> datas = new ArrayList<>();
//
//        for (int i = 0; i < 10_000; i++) {
//            datas.add(new TestEntity("data1", "data2", "data3", "data4", "data5"));
//        }
//
//        testRepository.saveAllAndFlush(datas);
//    }

    @Test
    void jdbc_mybatis_jpa_querydsl_querydslDto() {
        long jdbcStart = System.currentTimeMillis();
        testJdbcRepository.selectAll();
        long jdbcPerformance = System.currentTimeMillis() - jdbcStart;

        long mybatisStart = System.currentTimeMillis();
        testMapper.selectAll();
        long mybatisPerformance = System.currentTimeMillis() - mybatisStart;

        long jpaStart = System.currentTimeMillis();
        testRepository.findAll();
        long jpaPerformance = System.currentTimeMillis() - jpaStart;

        em.clear();
        em.flush();

        long querydslStart = System.currentTimeMillis();
        querydslRepository.selectAll();
        long querydslPerformance = System.currentTimeMillis() - querydslStart;

        long querydslDtoStart = System.currentTimeMillis();
        querydslRepository.selectAllDto();
        long querydslDtoPerformance = System.currentTimeMillis() - querydslDtoStart;

        System.out.println("jdbcPerformance = " + jdbcPerformance);
        System.out.println("mybatisPerformance = " + mybatisPerformance);
        System.out.println("jpaPerformance = " + jpaPerformance);
        System.out.println("querydslPerformance = " + querydslPerformance);
        System.out.println("querydslDtoPerformance = " + querydslDtoPerformance);
    }

}
