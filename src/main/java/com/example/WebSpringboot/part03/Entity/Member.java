package com.example.WebSpringboot.part03.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Member extends BaseEntity {

    @Id
    private String email;

    private String pw;

    private String name;

}
