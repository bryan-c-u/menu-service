package com.restaurante.menu_service.service;

import com.restaurante.menu_service.dto.DishRequestDTO;
import com.restaurante.menu_service.dto.DishResponseDTO;
import com.restaurante.menu_service.dto.MessageResponseDTO;
import com.restaurante.menu_service.entity.Dish;
import com.restaurante.menu_service.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository){
        this.repository = repository;
    }

    public List<DishResponseDTO> getAll(){

        List<Dish> list = repository.findAll();
        List<DishResponseDTO> response = new ArrayList<>();

        for(Dish dish : list){
            DishResponseDTO dishResponseDTO = new DishResponseDTO();
            dishResponseDTO.setId(dish.getId());
            dishResponseDTO.setName(dish.getName());
            dishResponseDTO.setDescription(dish.getDescription());
            dishResponseDTO.setPrice(dish.getPrice());
            dishResponseDTO.setAvailable(dish.isAvailable());
            dishResponseDTO.setStock(dish.getStock());
            response.add(dishResponseDTO);
        }

        return response;
    }

    public DishResponseDTO getById(Long id){

        Dish dish = repository.findById(id).orElse(null);

        if(dish == null){
            return null;
        }

        DishResponseDTO dishResponseDTO = new DishResponseDTO();
        dishResponseDTO.setId(dish.getId());
        dishResponseDTO.setName(dish.getName());
        dishResponseDTO.setDescription(dish.getDescription());
        dishResponseDTO.setPrice(dish.getPrice());
        dishResponseDTO.setAvailable(dish.isAvailable());
        dishResponseDTO.setStock(dish.getStock());

        return dishResponseDTO;
    }

    public MessageResponseDTO create(DishRequestDTO dishRequestDTO){

        Dish dish = new Dish();
        dish.setName(dishRequestDTO.getName());
        dish.setDescription(dishRequestDTO.getDescription());
        dish.setPrice(dishRequestDTO.getPrice());
        dish.setAvailable(dishRequestDTO.isAvailable());
        dish.setStock(dishRequestDTO.getStock());

        repository.save(dish);

        return new MessageResponseDTO("Plato creado");
    }

    public MessageResponseDTO update(Long id, DishRequestDTO req){

        Dish dish = repository.findById(id).orElse(null);

        if(dish == null){
            return new MessageResponseDTO("Plato no encontrado");
        }

        dish.setName(req.getName());
        dish.setDescription(req.getDescription());
        dish.setPrice(req.getPrice());
        dish.setAvailable(req.isAvailable());
        dish.setStock(req.getStock());

        repository.save(dish);

        return new MessageResponseDTO("Plato actualizado");
    }

    public MessageResponseDTO delete(long id){

        Dish dish = repository.findById(id).orElse(null);

        if(dish == null){
            return new MessageResponseDTO("Plato no encontrado");
        }

        repository.deleteById(id);

        return new MessageResponseDTO("Plato eliminado");
    }
}