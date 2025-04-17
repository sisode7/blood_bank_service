package com.bbank.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "login_users")
public class LoginUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginUserId;

    @Column(name = "name")
    private String name;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public LoginUser() {
        //Provided default constructor since we have included parameterised one
    }

    public LoginUser(Long loginUserId, String name, String userName, String password) {
        this.loginUserId = loginUserId;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

}
