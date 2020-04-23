package meetingroom;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="Enrollment_table")
public class Enrollment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer roomNo;
    private String roomPlace;

    @PostPersist
    public void onPostPersist(){
        Registered registered = new Registered();
        BeanUtils.copyProperties(this, registered);
        registered.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        meetingroom.external.Reservation reservation = new meetingroom.external.Reservation();
        // mappings goes here
        reservation.setRoomNo(registered.getRoomNo());
        reservation.setRoomPlace(registered.getRoomPlace());
        Application.applicationContext.getBean(meetingroom.external.ReservationService.class)
            .reserve(reservation);
    }

    @PrePersist
    public void onPrePersist(){
        Removed removed = new Removed();
        BeanUtils.copyProperties(this, removed);
        removed.publish();
    }

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
