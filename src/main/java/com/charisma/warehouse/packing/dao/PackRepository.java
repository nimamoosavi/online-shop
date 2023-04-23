package com.charisma.warehouse.packing.dao;

import com.charisma.warehouse.packing.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PackRepository extends JpaRepository<Pack,Long> {

    Optional<Pack> findByPackReference(String reference);

    List<Pack> findAllBy(String trackingCode);
}
