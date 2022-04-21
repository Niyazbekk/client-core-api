package com.example.clientcoreapi.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponse {
    private Long id;
    private String clientID;
    private String name;
    private String surname;
    private String email;
    private String delivery_option;
    private String address;
}
