package main.java.com.nomre.restservice.Model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="MSISDN")
    private String msisdn;

    @ManyToOne(fetch = FetchType.LAZY)
    private MsisdnCategory msisdnCategory;

    @Column(name="CUST_MSISDN")
    private String cust_msisdn;

    @Column(name="START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Column(name="END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;

    public Reservation() {
    }

    public Reservation(String msisdn, String cust_msisdn) {
        this.msisdn = msisdn;
        this.cust_msisdn = cust_msisdn;
        this.start_date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.start_date);
        calendar.add(Calendar.HOUR_OF_DAY, 5);
        this.end_date=calendar.getTime();
    }

    public Reservation(String msisdn, String cust_msisdn, MsisdnCategory msisdnCategory) {
        this.msisdn = msisdn;
        this.cust_msisdn = cust_msisdn;
        this.msisdnCategory=msisdnCategory;
        this.start_date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.start_date);
        calendar.add(Calendar.HOUR_OF_DAY, 5);
        this.end_date=calendar.getTime();
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setCust_msisdn(String cust_msisdn) {
        this.cust_msisdn = cust_msisdn;
    }
    public String getMsisdn() {
        return msisdn;
    }

    public String getCust_msisdn() {
        return cust_msisdn;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }
    public Long getId() {
        return id;
    }

}
