package com.mimicvm.vm;

public final class LocalVarArray {

    private final int[] slots;

    public LocalVarArray(int max) {
        this.slots = new int[max];
    }

    public int get(int index) {
        return slots[index];
    }

    public void set(int index, int value) {
        slots[index] = value;
    }
}
