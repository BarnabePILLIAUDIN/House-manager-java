package com.rendu.agence.services;

import com.rendu.agence.models.House;
import com.rendu.agence.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServices {

    @Autowired
    private HouseRepository repository;

    public House save(House house) {
        return repository.save(house);
    }

    public List<House> findAll() {
        return repository.findByIsActiveTrue();
    }

    public House findById(Integer id) {
        Optional<House> house = repository.findById(id);

        // If there is no house with this id we return an empty one
        return house.orElseGet(House::new);

    }

    public void delete(Integer id) {
        House house = this.findById(id);
        house.setIsActive(false);

        this.save(house);
    }
}
