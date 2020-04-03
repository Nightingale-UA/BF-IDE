package com.nightingale.bf.model;

public class ExecutionData {
    private int swapReg = -1;
    private int pointer;
    private int countIn;
    private int nextIn = -1;
    private int countOut;
    private int nextOut;

    public int getSwapReg() {
        return swapReg;
    }

    public void setSwapReg(int swapReg) {
        this.swapReg = swapReg;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getCountIn() {
        return countIn;
    }

    public void setCountIn(int countIn) {
        this.countIn = countIn;
    }

    public int getNextIn() {
        return nextIn;
    }

    public void setNextIn(int nextIn) {
        this.nextIn = nextIn;
    }

    public int getCountOut() {
        return countOut;
    }

    public void setCountOut(int countOut) {
        this.countOut = countOut;
    }

    public int getNextOut() {
        return nextOut;
    }

    public void setNextOut(int nextOut) {
        this.nextOut = nextOut;
    }
}
