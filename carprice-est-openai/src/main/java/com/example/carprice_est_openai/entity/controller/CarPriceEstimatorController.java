package com.example.carprice_est_openai.entity.controller;

import com.example.carprice_est_openai.entity.CarDetails;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car-pricing")
public class CarPriceEstimatorController {

    private final ChatModel chatModel;

    public CarPriceEstimatorController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping("/estimate")
    public ResponseEntity<String> estimateCarPrice(@RequestBody CarDetails carDetails) {
        String prompt = buildPrompt(carDetails);
        System.out.println("Sending prompt to ChatGPT: " + prompt);

        // Sending prompt to ChatGPT and getting the response
        String response = chatModel.call(prompt);

        System.out.println("ChatGPT Response: " + response);
        return ResponseEntity.ok(response);
    }

    private String buildPrompt(CarDetails carDetails) {
        return String.format(
                "Estimate the price of a car with the following details in one line: " +
                        "Model: %s, Year: %d, Location: %s.",
                carDetails.getModel(), carDetails.getYear(), carDetails.getLocation()
        );
    }
}