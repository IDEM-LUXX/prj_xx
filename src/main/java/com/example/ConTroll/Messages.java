package com.example.ConTroll;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "messages")
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "messages_seq", sequenceName = "messages_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_seq")
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name = "mid", nullable = false)
    private Long mid;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "queue", nullable = false)
    private String queue;

    @Column(name = "timing", nullable = false)
    private Date timing;

}
