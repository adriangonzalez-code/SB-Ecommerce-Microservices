package com.driagon.ecommerce.services.app.mappers;

import com.driagon.ecommerce.services.app.dto.AddressResponse;
import com.driagon.ecommerce.services.app.models.Address;

public class MapToAddress {

    public static AddressResponse mapToAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(String.valueOf(address.getId()))
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .build();
    }
}