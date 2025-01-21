package com.ust.Vehicle_information.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class VehicleBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String registrationNumber;


    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String carMake;

    @Column(nullable = false)
    private String carModel;

    private String variant;

    @Column(name = "manufacture_year")
    private int manufactureYear;

    private Long kms;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "number_of_owners")
    private int numberOfOwners;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "transmission_type")
    private String transmissionType;

    @Column(nullable = false, unique = true)
    private String vin;  // Vehicle Identification Number

    private Long expectedPrice;

    private String description;
    private Boolean sparekey;
    private String insurance;
    //
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Lob
    private byte[] images;




    public VehicleBooking(Long id,String insurance, Boolean sparekey,String registrationNumber, String ownerName, String carMake, String carModel, String variant, int manufactureYear, Long kms, String bodyType, int numberOfOwners, String fuelType, String transmissionType, String vin, Long expectedPrice, String description, byte[] images, LocalDateTime createdAt) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.carMake = carMake;
        this.carModel = carModel;
        this.variant = variant;
        this.manufactureYear = manufactureYear;
        this.kms = kms;
        this.bodyType = bodyType;
        this.numberOfOwners = numberOfOwners;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.vin = vin;
        this.expectedPrice = expectedPrice;
        this.description = description;
        this.images = images;
        this.createdAt = createdAt;
        this.insurance=insurance;
        this.sparekey=sparekey;
    }

    public VehicleBooking(Long expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public VehicleBooking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Long getKms() {
        return kms;
    }

    public void setKms(Long kms) {
        this.kms = kms;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public void setNumberOfOwners(int numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Long expectedPrice) {
        this.expectedPrice = expectedPrice;
    }


    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Boolean getSparekey() {
        return sparekey;
    }

    public void setSparekey(Boolean sparekey) {
        this.sparekey = sparekey;
    }
}
