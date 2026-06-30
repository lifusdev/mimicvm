package com.mimicvm.vm;

import com.mimicvm.shared.method.VMethod;

public final class Frame {

    private final Stack stack;
    private final LocalVarArray locals;

    public Frame(VMethod method) {
        this.stack = new Stack(method.maxStack());
        this.locals = new LocalVarArray(method.maxLocals());
    }

    public Stack getStack() {
        return stack;
    }

    public LocalVarArray getLocals() {
        return locals;
    }
}
