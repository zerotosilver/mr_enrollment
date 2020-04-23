package meetingroom.external;

public class Reservation {

    private Long id;
    private Integer roomNo;
    private String roomPlace;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNo() {
        return roomNo;
    }
    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomPlace() { return roomPlace; }
    public void setRoomPlace(String roomPlace) {
        this.roomPlace = roomPlace;
    }

}

