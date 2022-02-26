package uz.pdp.task1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task1.entity.Room;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Long> {


    Page<Room> findAllByHotelId(Long hotelId, Pageable pageable);
}
