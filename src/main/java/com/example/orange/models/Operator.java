package com.example.orange.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator {

    @Id
    Long id;

    String lastName;
    String firstName;

}
