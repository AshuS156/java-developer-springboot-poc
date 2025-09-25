package com.javatechie.transaction.demo.services;

import com.javatechie.transaction.demo.dto.RequestDto;
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
public class BookMovieTicketService{

    private static final Logger logger = LoggerFactory.getLogger(BookMovieTicketTestService.class);

    @Autowired
    private SeatRepository seatRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Seat bookMovieTicketusingOptimisticlock(Long id) {
         Seat seatObj = seatRepository.findById(id).orElseThrow(() -> new RuntimeException("No ticket available for given id :" + id));
        if("TRUE".equalsIgnoreCase(seatObj.getStatus())) {
            throw new RuntimeException("Seat is already booked !!!!!");
        }
        seatObj.setStatus("true");
        return seatRepository.save(seatObj);
    }



    @Transactional
    public void bookMovieTicketusingPessimisticlock(Long id) {
        logger.info(Thread.currentThread().getName() + "trying to book the Seat");
        Seat seatObj = seatRepository.findByIdandLock(id);
        logger.info(Thread.currentThread().getName() + "Acquired the lock for seat id :{} ", id);
        if("TRUE".equalsIgnoreCase(seatObj.getStatus())) {
            logger.info(Thread.currentThread().getName() + "failed to book  the Seat for id :{} ", id);
            throw new RuntimeException("Seat is already booked !!!!!");
        }
        logger.info(Thread.currentThread().getName() + "booking the Seat for id :{} ", id);
        seatObj.setStatus("true");
         seatRepository.save(seatObj);
        logger.info(Thread.currentThread().getName() + "Successfully book the Seat for id :{} "+ seatObj.getId());
    }

    public Seat updateStatus(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat saveData(RequestDto requestDto) {
        Seat seat = new Seat();
        seat.setMovieName(requestDto.getMovieName());
        seat.setVersion(requestDto.getVersion());
       seat.setStatus(requestDto.getStatus());
        return seatRepository.save(seat);
    }
}
