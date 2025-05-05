package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.entities.Address;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.entities.Product;
import com.lavanderia.api.entities.Provider;
import com.lavanderia.api.repositories.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Address createAddress(CreateRecord createRecord, Applicant applicant, Provider provider) {

        // Record to Entity
        Address address =  new Address(
                createRecord.addressNumberApartment(),
                createRecord.addressFloor()
        );

        address.setApplicant(applicant);
        address.setProvider(provider);
        return addressRepository.save(address);
    }


}
