package com.example.WebSpringboot.part04.Entity;

import com.example.WebSpringboot.part03.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"movie", "member"})
@Getter
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reviewer reviewer;


    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    private int grade;

    private String text;


}
