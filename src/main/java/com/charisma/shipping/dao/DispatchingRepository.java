package com.charisma.shipping.dao;


import com.charisma.shipping.entities.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DispatchingRepository extends JpaRepository<Dispatch,Long> {

    Optional<Dispatch> findByDispatchReference(String reference);
}
