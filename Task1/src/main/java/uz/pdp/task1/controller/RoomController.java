package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.Hotel;
import uz.pdp.task1.entity.Room;
import uz.pdp.task1.payload.RoomDto;
import uz.pdp.task1.repository.HotelRepo;
import uz.pdp.task1.repository.RoomRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {


    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelRepo hotelRepo;

    // Group Head Uchun:
    @GetMapping("/roomsByHotelId/{hotelId}")
    public Page<Room> getRoomsByHotelId(@PathVariable Long hotelId, @RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Room> roomPage = roomRepo.findAllByHotelId(hotelId, pageable);
        return roomPage;
    }


    @PostMapping("addOrEdit")
    public String addOrEditRoom(@RequestBody RoomDto dto) {
        Room room = new Room();
        if (dto.getId() != null) {
            room = roomRepo.getById(dto.getId());
        }
        Optional<Hotel> hotelOptional = hotelRepo.findById(dto.getHotelId());
        if (!hotelOptional.isPresent()) {
            return "Hotel not Found";
        }
        room.setNumber(dto.getNumber());
        room.setFloor(dto.getFloor());
        room.setSize(dto.getSize());
        room.setHotel(hotelOptional.get());
        roomRepo.save(room);
        return dto.getId() != null ? "Edited" : "Saved";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        try {
            roomRepo.deleteById(id);
            return "Deleted!";
        } catch (Exception e) {
            return "Error in Deleting!";
        }
    }


}
