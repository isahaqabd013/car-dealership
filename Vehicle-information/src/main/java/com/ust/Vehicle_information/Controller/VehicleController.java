package com.ust.Vehicle_information.Controller;

import com.ust.Vehicle_information.Entity.Vehicle;
import com.ust.Vehicle_information.Entity.VehicleBooking;
import com.ust.Vehicle_information.Service.VehicleService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/find")
    public ResponseEntity<?> findByRegistrationNumberAndOwnerName(
            @RequestParam String registrationNumber,
            @RequestParam String ownerName) {
        Optional<Vehicle> vehicle = Optional.ofNullable(vehicleService.findByRegistrationNumberAndOwnerName(registrationNumber, ownerName));
        return vehicle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/booking/{id}/price")
    public ResponseEntity<VehicleBooking> updateExpectedPrice(
            @PathVariable Long id,
            @RequestParam Long expectedPrice) throws Exception {
        Optional<VehicleBooking> optionalBooking = vehicleService.getVehicleBookingById(id);
        if (optionalBooking.isPresent()) {
            VehicleBooking booking = optionalBooking.get();
            booking.setExpectedPrice(expectedPrice);
            VehicleBooking updatedBooking = vehicleService.saveVehiclePrice(booking);
            return ResponseEntity.ok(updatedBooking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/booking")
    public ResponseEntity<?> saveVehicleBooking(@RequestBody VehicleBooking vehicleBooking) {
        try {
            VehicleBooking savedBooking = vehicleService.saveVehicle(vehicleBooking);
            System.out.println(savedBooking.toString());
            return ResponseEntity.ok(savedBooking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
//    @PostMapping("/booking/images")
//    public ResponseEntity<?> addImages(
//            @RequestParam("vehicleId") Long vehicleId,
//            @RequestParam("images") List<MultipartFile> images) {
//        try {
//            Optional<VehicleBooking> optionalBooking = vehicleService.getVehicleBookingById(vehicleId);
//            if (optionalBooking.isPresent()) {
//                VehicleBooking updatedBooking = vehicleService.addImagesToVehicleBooking(optionalBooking.get(), images);
//                return ResponseEntity.ok(updatedBooking);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle booking not found");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error processing the images: " + e.getMessage());
//        }
//    }
    @PostMapping("/booking/image")
    public ResponseEntity<?> addImage(
            @RequestParam("vehicleId") Long vehicleId,
            @RequestParam("image") MultipartFile image) {
        try {
            Optional<VehicleBooking> optionalBooking = vehicleService.getVehicleBookingById(vehicleId);
            if (optionalBooking.isPresent()) {
                VehicleBooking updatedBooking = vehicleService.addImageToVehicleBooking(optionalBooking.get(), image);
                return ResponseEntity.ok(updatedBooking);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle booking not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the image: " + e.getMessage());
        }
    }

    @GetMapping("/booking/image/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        try {
            VehicleBooking vehicle = vehicleService.getVehicleBookingById(id)
                    .orElseThrow(() -> new RuntimeException("VehicleBooking not found for ID: " + id));

            byte[] imageFile = vehicle.getImages().get(0); // Retrieve the first image (modify as needed)

            if (imageFile == null || imageFile.length == 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Assuming the image is in JPEG format
                    .body(imageFile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

//
//    @GetMapping("/booking/image/{id}")
//    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
//        try {
//            VehicleBooking vehicle = vehicleService.getVehicleBookingById(id)
//                    .orElseThrow(() -> new RuntimeException("VehicleBooking not found for ID: " + id));
//
//            byte[] imageFile = vehicle.getImages();
//
//            if (imageFile == null || imageFile.length == 0) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//            }
//
//            return ResponseEntity.ok()
//                    .contentType(MediaType.IMAGE_JPEG) // Assuming the image is in JPEG format
//                    .body(imageFile);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }



}