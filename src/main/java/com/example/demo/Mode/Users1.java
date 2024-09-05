package com.example.demo.Mode;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Users1 {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;
}
