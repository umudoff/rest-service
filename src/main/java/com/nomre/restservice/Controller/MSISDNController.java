package main.java.com.nomre.restservice.Controller;


import main.java.com.nomre.restservice.Model.MsisdnCategory;
import main.java.com.nomre.restservice.Service.CategoryService;
import main.java.com.nomre.restservice.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MSISDNController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/search")
    public ResponseEntity<List<MsisdnCategory>> search(@RequestParam(defaultValue = "all") String category,
                                                       @RequestParam(defaultValue = "empty") String msisdn) {
        List<MsisdnCategory> msisdnList = categoryService.getMsisdnList(category, msisdn);
        return new ResponseEntity<>(msisdnList, HttpStatus.OK);
    }


    @GetMapping("/notreserved")
    public ResponseEntity<List<MsisdnCategory>> searchNotReserved(@RequestParam(defaultValue = "all") String category,
                                                       @RequestParam(defaultValue = "empty") String msisdn) {
        List<MsisdnCategory> msisdnList = categoryService.getMsisdnList(category, msisdn);
        return new ResponseEntity<>(msisdnList, HttpStatus.OK);
    }


    @PostMapping("/reserve/{msisdn}")
    public ResponseEntity<String> reserveMsisdn(@PathVariable("msisdn") String  msisdn, @RequestParam("cust_msisdn") String cust_msisdn) {
        boolean result= reservationService.saveReservation(msisdn,cust_msisdn);
        return ResponseEntity.status(HttpStatus.OK).body(  String.valueOf(result));
    }

}
