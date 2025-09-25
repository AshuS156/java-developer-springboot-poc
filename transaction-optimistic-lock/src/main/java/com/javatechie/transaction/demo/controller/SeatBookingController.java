package com.javatechie.transaction.demo.controller;

import com.javatechie.transaction.demo.dto.RequestDto;
import com.javatechie.transaction.demo.model.Seat;
import com.javatechie.transaction.demo.services.BookMovieTicketService;
import com.javatechie.transaction.demo.services.BookMovieTicketTestService;
import com.javatechie.transaction.demo.services.BookMovieTicketTestUsingPessimisticLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class SeatBookingController{

    private static  final Logger logger = LoggerFactory.getLogger(SeatBookingController.class);

    @Autowired
    BookMovieTicketService bookMovieTicketService;
    @Autowired
    BookMovieTicketTestService bookMovieTicketTestService;

    @Autowired
    BookMovieTicketTestUsingPessimisticLockService bookMovieTicketTestUsingPessimisticLockService;

    @GetMapping("/bookmovieticket/{ticketid}")
    public ResponseEntity<?> bookMovieTicket(@PathVariable("ticketid") String ticketid){
        try {
             bookMovieTicketTestService.bookTicketusingOptimisticLock(Long.parseLong(ticketid));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success!!!!!");
    }

    @GetMapping("/bookmovieticketusingpessimistic/{ticketid}")
    public ResponseEntity<?> bookMovieTicketUsingPessimistic(@PathVariable("ticketid") String ticketid){
        try {
            bookMovieTicketTestUsingPessimisticLockService.bookTicketusingPessimisticLock(Long.parseLong(ticketid));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success!!!!!");
    }

    @PostMapping(value = "/insertdata" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertDataIntoDB(@RequestBody RequestDto requestpayload){
        logger.info("request paylaod : {}" , requestpayload);
        final Seat seat1 = bookMovieTicketService.saveData(requestpayload);
        logger.info("Seat addded with data : {}" , seat1);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(seat1);
    }
}
