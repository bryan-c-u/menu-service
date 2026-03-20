package com.restaurante.menu_service.controller;

import com.restaurante.menu_service.dto.DishRequestDTO;
import com.restaurante.menu_service.dto.DishResponseDTO;
import com.restaurante.menu_service.dto.MessageResponseDTO;
import com.restaurante.menu_service.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService service;

    public DishController(DishService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DishResponseDTO>> getAll(){
        try {
            List<DishResponseDTO> list = service.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishResponseDTO> getById(@PathVariable Long id){
        try {
            DishResponseDTO dishResponseDTO = service.getById(id);
            if(dishResponseDTO == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(dishResponseDTO);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<MessageResponseDTO> create(@RequestBody DishRequestDTO dishRequestDTO){
        try {
            MessageResponseDTO messageResponseDTO = service.create(dishRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageResponseDTO);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponseDTO("Error al crear el plato"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody DishRequestDTO dishRequestDTO){
        try {
            MessageResponseDTO messageResponseDTO = service.update(id, dishRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(messageResponseDTO);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponseDTO("Error al actualizar el plato"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> delete(@PathVariable Long id){
        try {
            MessageResponseDTO messageResponseDTO = service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(messageResponseDTO);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponseDTO("Error al eliminar el plato"));
        }
    }
}