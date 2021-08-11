package main.java.com.nomre.restservice.Service;

import main.java.com.nomre.restservice.Model.Reservation;
import main.java.com.nomre.restservice.Repository.CategoryRepository;
import main.java.com.nomre.restservice.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean saveReservation(String msisdn, String cust_msisdn){
        boolean reserved=false;
        List<Reservation> activeReservations=reservationRepository.msisdnListActiveReservation(msisdn);
        if(activeReservations.size() == 0){
        int count=    reservationRepository.countDailyActiveReservation(cust_msisdn);
            if(count<5){
                reservationRepository.save(new Reservation(msisdn,cust_msisdn,categoryRepository.findByMsisdn(msisdn)));
                reserved=true;
            }
        }else{
            reserved=false;
        }

        return reserved;
    }
}
