package com.group4.ethazi_ad.modelo.clases;

import java.io.Serializable;

public class Alojamiento implements Serializable {

    private static final long serialVersionUID = 3204711617677271886L;

    private String signatura;
    private String nombre;
    private TiposAloj tipo;
    private String municipio;
    private int postcode;

    public static enum TiposAloj {
        Agroturismos, Casas_Rurales, Albergues, Campings
    }

    public Alojamiento(String signatura, String nombre, TiposAloj tipo, String municipio, int postcode) {
        super();
        this.signatura = signatura;
        this.nombre = nombre;
        this.tipo = tipo;
        this.municipio = municipio;
        this.postcode = postcode;
    }

    public String getSignatura() {
        return signatura;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TiposAloj getTipo() {
        return tipo;
    }

    public void setTipo(TiposAloj tipo) {
        this.tipo = tipo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        String datos = "";
        datos += "Numero de alojamiento:" + this.signatura + "\n";
        datos += "Nombre:               " + this.nombre + "\n";
        datos += "Tipo de alojamiento:  " + this.tipo + "\n";
        datos += "Municipio:            " + this.municipio + "\n";
        datos += "Codigo de municipio:  " + this.postcode;
        return datos;
    }

}
