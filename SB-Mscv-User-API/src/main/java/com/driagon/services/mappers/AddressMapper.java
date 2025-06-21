package com.driagon.services.mappers;

import com.driagon.services.dto.requests.AddressRequest;
import com.driagon.services.dto.responses.AddressResponse;
import com.driagon.services.entities.Address;

public class AddressMapper {

    public static AddressResponse mapAddressToAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(String.valueOf(address.getId()))
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .build();
    }

    public static Address mapAddressRequestToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .street(addressRequest.getStreet())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .zipCode(addressRequest.getZipCode())
                .build();
    }
}