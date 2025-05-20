package com.driagon.ecommerce.services.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private AddressRequest address;
}