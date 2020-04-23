
package meetingroom.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="Reserve", url="${api.url.reserve}")
public interface ReservationService {

    @RequestMapping(method= RequestMethod.POST, path="/reservations")
    public void reserve(@RequestBody Reservation reservation);

}