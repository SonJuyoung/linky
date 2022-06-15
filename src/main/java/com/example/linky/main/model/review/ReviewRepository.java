package com.example.linky.main.model.review;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

    List<ReviewEntity> findAllByOrderByRdtDesc();

    @Query(value = "DELETE from t_review WHERE id in (SELECT temp.id FROM (SELECT * FROM t_review order by rdt LIMIT 1) AS temp)", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteOldReview();

    @Query(value = "SELECT * from t_review WHERE id in (SELECT temp.id FROM (SELECT * FROM t_review order by rdt LIMIT 1) AS temp)", nativeQuery = true)
    ReviewEntity delTargetReview();
}