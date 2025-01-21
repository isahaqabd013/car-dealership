package com.ust.Vehicle_information.Repository;

import com.ust.Vehicle_information.Entity.VehicleBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBookingRepository extends JpaRepository<VehicleBooking, Long> {
    VehicleBooking findByRegistrationNumberAndOwnerName(String registrationNumber, String ownerName);
}
