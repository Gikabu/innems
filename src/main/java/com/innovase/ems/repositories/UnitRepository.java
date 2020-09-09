package com.innovase.ems.repositories;

import com.innovase.ems.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, String>{
    Unit findByName(String name);
}
