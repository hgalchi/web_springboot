package com.example.WebSpringboot.part05.Entity;

import com.example.WebSpringboot.part03.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.generator.internal.GeneratedGeneration;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Note extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClubMember writer;

    public void changeTitle(String title) {
        this.title=title;
    }
    public void changeContent(String content) {
        this.content=content;
    }
}
