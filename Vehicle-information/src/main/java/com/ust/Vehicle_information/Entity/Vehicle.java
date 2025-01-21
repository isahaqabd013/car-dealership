package com.ust.Vehicle_information.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.time.LocalDateTime;

@Entity

public class Vehicle {
    @Id
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


    public Vehicle(Long id, String registrationNumber, String ownerName, String carMake, String carModel, String variant, int manufactureYear, Long kms, String bodyType, int numberOfOwners, String fuelType, String transmissionType, String vin) {
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
    }

    public Vehicle() {
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

}
