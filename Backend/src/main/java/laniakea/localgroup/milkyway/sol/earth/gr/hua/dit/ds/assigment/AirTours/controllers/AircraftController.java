package laniakea.localgroup.milkyway.sol.earth.gr.hua.dit.ds.assigment.AirTours.controllers;

import laniakea.localgroup.milkyway.sol.earth.gr.hua.dit.ds.assigment.AirTours.entities.Aircraft;
import laniakea.localgroup.milkyway.sol.earth.gr.hua.dit.ds.assigment.AirTours.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    @Autowired
    AircraftRepository aircraftRepository;

    @GetMapping("")
    List<Aircraft> getAll() {
        return aircraftRepository.findAll();
    }

    @GetMapping("/{id}")
    Aircraft get(@PathVariable int id) {
        return aircraftRepository.findById(id);
    }

    @PostMapping("")
    Aircraft save(@RequestBody Aircraft aircraft) {
        aircraft.setId(0);
        aircraftRepository.save(aircraft);
        return aircraft;
    }

    @PutMapping("/{id}")
    Aircraft updateAircraft(@PathVariable int id, @RequestBody Aircraft aircraft) {
        Aircraft existingAircraft = aircraftRepository.findById(id);
        existingAircraft.setType(aircraft.getType());
        existingAircraft.setNoSeats(aircraft.getNoSeats());
        existingAircraft.setRegistration(aircraft.getRegistration());
        aircraftRepository.save(existingAircraft);
        return existingAircraft;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        aircraftRepository.deleteById(id);
    }

}