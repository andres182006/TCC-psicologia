package com.Unicartagena.TCC.base.exceptions;

public class AlreadyExists extends RuntimeException {
    private static final String DESCRIPCION = "dato ya existe";
    public AlreadyExists(String mensaje) {
        super(String.format("%s. %s", DESCRIPCION, mensaje));
    }
}
