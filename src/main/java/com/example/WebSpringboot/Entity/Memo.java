package com.example.WebSpringboot.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_memo")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;


}
