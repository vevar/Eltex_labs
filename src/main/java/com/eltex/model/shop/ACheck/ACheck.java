package com.eltex.model.shop.ACheck;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 *  Abstract class for check orders.
 *  Work as <i>thread</i>
 * @see Thread
 */
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

    /**
     * Toggle work of object
     */
    public void toggleWork(){
        lock = !lock;

        if (!lock){
            notify();
        }
    }

    /**
     * Turn on or turn off work of this check
     * @param work
     */
    public void setWork(boolean work){
        this.fWork = work;
    }

    /**
     * Check time for check
     * @return
     */
    private boolean isTimeCheck(){
        return lastTimeCheck.plus(timeBetweenCheck).isBefore(LocalDateTime.now());
    }

    private void mainLoop() throws InterruptedException {
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

    /**
     * Method that implementation of check
     */
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
