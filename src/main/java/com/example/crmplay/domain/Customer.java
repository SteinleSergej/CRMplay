package com.example.crmplay.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotBlank(message = "Enter a first name please")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Enter a last name please")
    private String lastName;


    @Email(message = "need a valid email address")
    @NotBlank(message = "Need a customer email")
    private String email;


}
