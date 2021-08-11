package main.java.com.nomre.restservice.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CATEGORY")
public class MsisdnCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="MSISDN")
    private String msisdn;

    @Column(name="CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;


    @OneToMany(mappedBy = "msisdnCategory", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public MsisdnCategory() {
    }

    public MsisdnCategory(String msisdn, Category category) {
        this.msisdn = msisdn;
        this.category = category;
    }

    public MsisdnCategory(String msisdn, Category category, List<Reservation> reservations) {
        this.msisdn = msisdn;
        this.category = category;
        this.reservations=reservations;
    }

    public Long getId() {
        return id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public Category getCategory() {
        return category;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
