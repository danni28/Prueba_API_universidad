package com.universidad.cruduniversidad.result;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Respuesta<T> {
    public boolean status;
    public Object message;
    public T data;

    public Respuesta() { }

    public Respuesta(boolean status, Object message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Respuesta Success(Object data)
    {
        var result = new Respuesta(true, null, data);
        return result;
    }

    public Respuesta NoSuccess(Object mensaje)
    {
        if (mensaje == null) {
            mensaje = "No se puedo Realizar la solicitud";
        }
        var result = new Respuesta(true, mensaje, new ArrayList<>());
        return result;
    }

    public Respuesta Error(Object mensaje)
    {
        if (mensaje == null) {
            mensaje = "Bad Request";
        }
        return new Respuesta(false, mensaje, new ArrayList<>());
    }

    public Respuesta NoEncontrado()
    {
        return new Respuesta(true, "No se encontraron datos", new ArrayList<>());
    }
}
