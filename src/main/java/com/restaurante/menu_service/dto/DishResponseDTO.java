package com.restaurante.menu_service.dto;

public class DishResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private boolean available;
    private int stock;

    public Integer getId() { 
        return id; 
    }

    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getDescription() { 
        return description; 
    }

    public void setDescription(String description) { 
        this.description = description; 
    }

    public double getPrice() { 
        return price; 
    }

    public void setPrice(double price) { 
        this.price = price; 
    }

    public boolean isAvailable() { 
        return available; 
    }

    public void setAvailable(boolean available) { 
        this.available = available; 
    }

    public int getStock() { 
        return stock; 
    }

    public void setStock(int stock) { 
        this.stock = stock; 
    }
}