package com.example.performancetester;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.performancetester.QTestEntity.testEntity;

@Repository
public class QuerydslRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public QuerydslRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public List<TestEntity> selectAll() {
        return query.selectFrom(testEntity)
                .fetch();
    }

    public List<TestEntityDto> selectAllDto() {
        return query.select(Projections.constructor(TestEntityDto.class,
                        testEntity.id,
                        testEntity.value1,
                        testEntity.value2,
                        testEntity.value3,
                        testEntity.value4,
                        testEntity.value5
                ))
                .from(testEntity)
                .fetch();
    }
}
