package com.example.clientcoreapi.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "client_model")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ClientEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "clientID can not be empty")
    private String clientID;
    @NotNull(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Surname can not be empty")
    private String surname;
    @NotNull(message = "email can not be empty")
    private String email;
    private String delivery_option;
    private String address;
}
