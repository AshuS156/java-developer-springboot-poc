package com.javatechie.transaction.demo.services;


import com.javatechie.transaction.demo.model.Seat;
import com.javatechie.transaction.demo.repository.SeatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookMovieTicketTestUsingPessimisticLockService{

    private  static final Logger log = LoggerFactory.getLogger(BookMovieTicketTestUsingPessimisticLockService.class);

    @Autowired
    BookMovieTicketService bookMovieTicketService;

    @Autowired
    SeatRepository seatRepository;

    @Transactional
    public void bookTicketusingPessimisticLock(Long id) throws InterruptedException{


        Thread th1 = new Thread(() -> {
            try{
               log.info(Thread.currentThread().getName() + "trying to book the ticket using id : " +id);
                bookMovieTicketService.bookMovieTicketusingPessimisticlock(id);
                log.info(Thread.currentThread().getName() + "Successfully book the ticket with id : {}", id);
            }catch (Exception e) {
                log.error(Thread.currentThread().getName() + "Error occurred while booking the seat for id : {} , by Thread : {} , exception : {}", id , Thread.currentThread().getName() , e.getMessage());
            }

        });

        Thread th2 = new Thread(() -> {
            try{
                log.info(Thread.currentThread().getName() + "trying to book the ticket using id : " +id);
                 bookMovieTicketService.bookMovieTicketusingPessimisticlock(id);
                log.info(Thread.currentThread().getName() + "Successfully book the ticket with id : {}", id);
            }catch (Exception e) {
                log.error(Thread.currentThread().getName() + "Error occurred while booking the seat for id : {} , by Thread : {} , exception : {}", id , Thread.currentThread().getName() , e.getMessage());
            }
        });

        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}
