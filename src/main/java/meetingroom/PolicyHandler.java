package meetingroom;

import meetingroom.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;



@Service
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_ChangeMeetingRoomStatus(@Payload Reserved reserved) {

        if (reserved.isMe()) {
            System.out.println("##### listener ChangeMeetingRoomStatus : " + reserved.toJson());
        }
    }



}
