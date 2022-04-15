package com.example.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    @NotNull(message = "clientID can not be empty")
    private String clientID;
    @NotNull(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Surname can not be empty")
    private String surname;
    @NotNull(message = "Surname can not be empty")
    private String email;
    private String deliveryOption;
    private String address;
}
