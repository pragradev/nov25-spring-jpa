package io.pragra.learning.novspringjpa.repo;

import io.pragra.learning.novspringjpa.entity.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailRepo extends JpaRepository<BankDetail, Integer> {
}
