package com.codesignal.deepseektutor;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeepSeekTutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeepSeekTutorApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ChatModel chatModel, ApplicationContext context) {
        return args -> {
            // TODO: Define a simple user message as a prompt
            String prompt = "How to show all the subjects from a student even if they have have that subject in table examinations from a student in mysqsl, the subjects are: Mathm, Physics and Programing";
            // TODO: Send the prompt to the AI model and get its reply
            String reply = chatModel.call(prompt);
            // TODO: Print both the user's prompt and the AI's reply
            System.out.println("User's prompt: '" + prompt);
            System.out.println("DeepSeek's reply: '" + reply);
            // Exit application
            SpringApplication.exit(context, () -> 0);
        };
    }
}