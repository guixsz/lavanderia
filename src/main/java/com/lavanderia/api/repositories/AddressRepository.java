package com.lavanderia.api.repositories;

import com.lavanderia.api.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
