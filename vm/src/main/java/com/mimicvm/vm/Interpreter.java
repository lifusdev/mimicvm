package com.mimicvm.vm;

import com.mimicvm.shared.method.VMethod;
import com.mimicvm.shared.op.Opcodes;

public final class Interpreter implements Opcodes {

    private final VMethod method;
    private final Frame frame;

    public Interpreter(VMethod method) {
        this.method = method;
        this.frame = new Frame(method);
    }

    public int run() {
        final byte[] insns = method.insns();
        int pc = 0;

        while (pc < insns.length) {
            final byte opc = insns[pc++];

            if (opc == I32_CONST) {
                final int value = ((insns[pc] & 0xFF) << 24) | ((insns[pc + 1] & 0xFF) << 16) | ((insns[pc + 2] & 0xFF) << 8) | (insns[pc + 3] & 0xFF);
                pc += 4;
                frame.getStack().push(value);
            } else if (opc == LOCAL_GET) {
                final int index = insns[pc++] & 0xFF;
                frame.getStack().push(frame.getLocals().get(index));
            } else if (opc == LOCAL_SET) {
                final int index = insns[pc++] & 0xFF;
                frame.getLocals().set(index, frame.getStack().pop());
            } else if (opc == I32_ADD) {
                final int b = frame.getStack().pop();
                final int a = frame.getStack().pop();
                frame.getStack().push(a + b);
            } else if (opc == I32_SUB) {
                final int b = frame.getStack().pop();
                final int a = frame.getStack().pop();
                frame.getStack().push(a - b);
            } else if (opc == I32_MUL) {
                final int b = frame.getStack().pop();
                final int a = frame.getStack().pop();
                frame.getStack().push(a * b);
            } else if (opc == RETURN) {
                return frame.getStack().pop();
            }
        }

        throw new IllegalStateException("missing RETURN");
    }
}
