package com.ust.Vehicle_information.Service;

import com.ust.Vehicle_information.Entity.Vehicle;
import com.ust.Vehicle_information.Entity.VehicleBooking;
import com.ust.Vehicle_information.Repository.VehicleBookingRepository;
import com.ust.Vehicle_information.Repository.VehicleRepository;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.events.Event;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleBookingRepository vehicleBookingRepository;

    //booking
    public VehicleBooking saveVehicle(VehicleBooking vehicleBooking) throws Exception {
        Vehicle vehicle = vehicleRepository.findByRegistrationNumberAndOwnerName(vehicleBooking.getRegistrationNumber(), vehicleBooking.getOwnerName());
        if(vehicle == null) {
            throw new Exception("Registration number and owner name does not match");
        }
        VehicleBooking vehicleBookingData = vehicleBookingRepository.findByRegistrationNumberAndOwnerName(vehicleBooking.getRegistrationNumber(), vehicleBooking.getOwnerName());
        if (vehicleBookingData != null) {
            throw new Exception("Registration number and owner name already exist ");
        }
        return vehicleBookingRepository.save(vehicleBooking);
    }

    public VehicleBooking saveVehiclePrice(VehicleBooking vehicleBooking) throws Exception {
        return vehicleBookingRepository.save(vehicleBooking);
    }


    public Vehicle findByRegistrationNumberAndOwnerName(String registrationNumber, String ownerName) {
        return vehicleRepository.findByRegistrationNumberAndOwnerName(registrationNumber, ownerName);
    }

    // Get vehicle booking by Event.ID
    public Optional<VehicleBooking> getVehicleBookingById(Long id) {
        return vehicleBookingRepository.findById(id);
    }
    //image adding
    public VehicleBooking addImageToVehicleBooking(VehicleBooking vehicleBooking, MultipartFile image) {
        try {
            vehicleBooking.setImages(image.getBytes());

            return vehicleBookingRepository.save(vehicleBooking);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process the image file", e);
        }
    }
    public List<VehicleBooking> findAll() {
        return vehicleBookingRepository.findAll();
    }

}
