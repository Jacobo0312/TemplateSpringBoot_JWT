package com.Jacobo0312.templateSpringBoot.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="users")
public class UserModel {
    @Id @Column(name="id", nullable = false)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="lastname", nullable = false)
    private String lastName;
    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;


}
