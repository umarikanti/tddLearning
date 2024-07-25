package com.neoteric.javatdd.AOP;

import org.springframework.stereotype.Service;

@Service
public class BookingProcess {


    @TimeExecution
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }

}
