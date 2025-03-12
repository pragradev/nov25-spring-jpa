package io.pragra.learning.novspringjpa.repo;

import io.pragra.learning.novspringjpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
}
