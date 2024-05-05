package org.projet.projetWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.projet.projetWeb.model.Car;
import org.projet.projetWeb.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @GetMapping("/findCarByDriverId/{driverID}")
    public ResponseEntity<Car> getCarByDriverID(@PathVariable int driverID) {
        Optional<Car> carOptional = carRepository.findCarByDriver_userID(driverID);
        return carOptional.map(car -> ResponseEntity.ok().body(car))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        try {
            // Check if a car already exists for the driver
            ResponseEntity<Car> carResponseEntity = getCarByDriverID(car.getDriver().getUserID());

            // Extract the Car object from the response entity
            Car carExists = carResponseEntity.getBody();

            // If a car already exists, delete it
            if (carExists != null) {
                deleteCarByDriverId(carExists.getDriver().getUserID());
            }

            // Save the new car
            Car createdCar = carRepository.save(car);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
        } catch (Exception e) {
            // Handle any exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car updatedCar) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedCar.setCarID(id);
        Car savedCar = carRepository.save(updatedCar);
        return ResponseEntity.ok().body(savedCar);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            carRepository.delete(car);
            return ResponseEntity.ok("Voiture supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Voiture non trouvée avec l'ID : " + id);
        }
    }
    @DeleteMapping("/delete/{driverID}")
    public ResponseEntity<String> deleteCarByDriverId(@PathVariable int driverID) {
        Optional<Car> carOptional = carRepository.findCarByDriver_userID(driverID);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            carRepository.delete(car);
            return ResponseEntity.ok("Voiture supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Voiture non trouvée avec l'ID : " + driverID);
        }
    }

}
