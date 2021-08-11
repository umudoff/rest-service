package main.java.com.nomre.restservice.test;

import main.java.com.nomre.restservice.Model.Customer;
import main.java.com.nomre.restservice.Model.Reservation;
import main.java.com.nomre.restservice.Repository.CustomerRepository;
import main.java.com.nomre.restservice.Repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;


   @Test
    public void test_MsisdnHasActiveReservations() {
       Reservation r=new Reservation("997002392","557002392");
       entityManager.persist(r);
       entityManager.flush();

       List<Reservation> reservationList=reservationRepository.msisdnListActiveReservation(r.getMsisdn());

       assertEquals(1, reservationList.size());
    }

    @Test
    public void test_CountCustomerActiveReservationsToday() {
        Reservation r1=new Reservation("995722244","557002392");
        Reservation r2=new Reservation("995575885","557002392");
        Reservation r3=new Reservation("993221717","557002392");
        entityManager.persist(r1);
        entityManager.persist(r2);
        entityManager.persist(r3);
        entityManager.flush();

       int activeDailyReservationCount= reservationRepository.countDailyActiveReservation(r1.getCust_msisdn());

        assertEquals(3, activeDailyReservationCount);
    }



}
