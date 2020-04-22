package meetingroom;

import javax.persistence.*;

import meetingroom.config.kafka.KafkaProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

@Entity
@Table(name="Enrollment_table")
public class Enrollment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer roomNo;
    private String roomPlace;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @PostPersist
    public void onPostPersist(){
        Registered registered = new Registered();
        BeanUtils.copyProperties(this, registered);
        registered.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        meetingroom.external.Reservation reservation = new meetingroom.external.Reservation();
        // mappings goes here
        Application.applicationContext.getBean(meetingroom.external.ReservationService.class)
            .reserve(reservation);
    }

    @PrePersist
    public void onPrePersist(){
        Removed removed = new Removed();
        BeanUtils.copyProperties(this, removed);
        removed.publish();


    }

    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void onEvent(@Payload Registered registered) {
        try {

             //회의실 등록이 발생시, 회의실을 등록한다.

            if (registered.isMe()) {
                System.out.println("##### 회의실 등록 : " + registered.toJson());
                Enrollment enrollment = new Enrollment();
                enrollment.setRoomNo(registered.getRoomNo());
                enrollmentRepository.save(enrollment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */



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
