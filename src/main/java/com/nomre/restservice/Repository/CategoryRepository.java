package main.java.com.nomre.restservice.Repository;

import main.java.com.nomre.restservice.Model.MsisdnCategory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<MsisdnCategory,Long>, JpaSpecificationExecutor<MsisdnCategory>
{
    public List<MsisdnCategory> findAll(Specification<MsisdnCategory> spec);


    @Query( value =  "select * from CATEGORY c " +
            "where NOT EXISTS (SELECT  CUST_MSISDN FROM RESERVATION r " +
            " WHERE  r.START_DATE <= CURRENT_TIMESTAMP() and " +
            " CURRENT_TIMESTAMP()<= r.END_DATE " +
            " AND r.MSISDN = c.MSISDN ) and (c.CATEGORY= :category OR :category='all'  OR :category ='') and lower(c.MSISDN) like  CONCAT('%', :pattern,'%') ", nativeQuery = true)
    List<MsisdnCategory> getMsisdnCategoryWithOutReservation(@Param("category") String category , @Param("pattern")  String pattern);


    @Query("SELECT c FROM MsisdnCategory c WHERE c.msisdn=:msisdn")
    public MsisdnCategory findByMsisdn(@Param("msisdn")  String msisdn);


}
