package com.example.carprice_est_openai;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarPriceEstimatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPriceEstimatorApplication.class, args);
	}

	@Bean
	public ChatModel chatModel(@Value("${spring.ai.openai.api-key}") String apiKey) {
		return new OpenAiChatModel(new OpenAiApi(apiKey));
	}
}