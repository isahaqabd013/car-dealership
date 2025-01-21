package com.ust.Vehicle_information.Repository;

import com.ust.Vehicle_information.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByRegistrationNumberAndOwnerName(String registrationNumber, String ownerName);
}