package main.java.com.nomre.restservice.Repository;

import main.java.com.nomre.restservice.Model.MsisdnCategory;
import main.java.com.nomre.restservice.Model.Reservation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query( value = " SELECT  *  FROM RESERVATION r " +
            " WHERE  r.START_DATE <= CURRENT_TIMESTAMP() and " +
            " CURRENT_TIMESTAMP()<= r.END_DATE " +
            " AND r.MSISDN = :msisdn ", nativeQuery = true)
     List<Reservation> msisdnListActiveReservation(@Param("msisdn")  String msisdn);

    @Query( value = " SELECT  COUNT(1)  FROM RESERVATION r " +
            " WHERE FORMATDATETIME(r.START_DATE,'yyyy-MM-dd') =  FORMATDATETIME(CURRENT_TIMESTAMP(),'yyyy-MM-dd') " +
            " AND r.CUST_MSISDN = :cust_msisdn ", nativeQuery = true)
    int countDailyActiveReservation(@Param("cust_msisdn")  String cust_msisdn);

}

