package com.mimicvm.vm;

import com.mimicvm.shared.type.Value;

public final class LocalVarArray {

    private final Value[] slots;

    public LocalVarArray(int max) {
        this.slots = new Value[max];
    }

    public Value get(int index) {
        return slots[index];
    }

    public void set(int index, Value value) {
        slots[index] = value;
    }
}
