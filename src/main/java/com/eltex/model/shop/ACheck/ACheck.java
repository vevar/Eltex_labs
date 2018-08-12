package com.eltex.model.shop.ACheck;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class ACheck extends Thread{

    private boolean fWork;
    private boolean lock;
    Duration timeBetweenCheck;
    private LocalDateTime lastTimeCheck;

    ACheck(){
        timeBetweenCheck = Duration.ofSeconds(60);
        setDaemon(true);
        fWork = true;
    }

    public void toggleWork(){
        lock = !lock;

        if (!lock){
            notify();
        }
    }

    public void setWork(boolean work){
        this.fWork = work;
    }

    private boolean isTimeCheck(){
        return lastTimeCheck.plus(timeBetweenCheck).isBefore(LocalDateTime.now());
    }

    void mainLoop() throws InterruptedException {
        while (fWork) {
            while (lock) {
                wait();
            }
            if (isTimeCheck()) {
                check();
                lastTimeCheck = LocalDateTime.now();
            }
        }
    }

    abstract void check();

    @Override
    public void run() {
        lastTimeCheck = LocalDateTime.now();
        try {
            mainLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
