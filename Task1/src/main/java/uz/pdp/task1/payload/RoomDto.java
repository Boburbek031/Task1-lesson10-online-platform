package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {


    private Long id;
    private Integer number;
    private Integer floor;
    private Double size;
    private Long hotelId;

}
