package com.driagon.services.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AddressResponse {

    private String id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}