package com.mimicvm.shared.op;

public enum Opcodes {

    I32_CONST(0x1),
    LOCAL_GET(0x2),
    LOCAL_SET(0x3),

    I32_ADD(0x10),
    I32_SUB(0x11),
    I32_MUL(0x12),

    RETURN(0x20);

    private final int code;

    Opcodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
