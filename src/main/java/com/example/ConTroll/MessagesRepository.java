package com.example.ConTroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MessagesRepository extends JpaRepository<Messages, Long>, JpaSpecificationExecutor<Messages> {


    public List<Messages> findByMid(long id);

    @Query(value="select * from messages where messages_timing beetween :first and :second", nativeQuery = true)
    public List<Messages> findByDates (@Param("first")Date first, @Param("second") Date second);

    public List<Messages> findByTimingBetween(Date first, Date second);

    public List<Messages> findByQueue(String queue);

    List<Messages> findByTiming(Date date2);
}