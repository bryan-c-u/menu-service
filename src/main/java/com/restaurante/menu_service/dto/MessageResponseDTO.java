package com.restaurante.menu_service.dto;

public class MessageResponseDTO {

    private String message;

    public MessageResponseDTO(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}