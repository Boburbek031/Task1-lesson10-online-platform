package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.Hotel;
import uz.pdp.task1.repository.HotelRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Autowired
    HotelRepo hotelRepo;


    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }


    @PostMapping("/add")
    public String addHotel(@RequestBody Hotel hotel) {
        hotelRepo.save(hotel);
        return "New Hotel added!";
    }


    @PutMapping("/update/{id}")
    public String updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepo.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel1 = hotelOptional.get();
            hotel1.setName(hotel.getName());
            hotelRepo.save(hotel1);
            return "Hotel Updated!";
        }
        return "Hotel not found";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        try {
            hotelRepo.deleteById(id);
            return "Deleted!";
        } catch (Exception e) {
            return "Cannot be found and Deleted!";
        }
    }


}
