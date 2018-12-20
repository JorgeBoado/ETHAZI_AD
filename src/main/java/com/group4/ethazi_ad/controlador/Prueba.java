package com.group4.ethazi_ad.controlador;

        import com.group4.ethazi_ad.modelo.clases.Cliente;

public class Prueba {
    public static void main(String[] args) {
        Cliente c = new Cliente(1212, "nick",
                "11111111J", "11111111", "jon@gmail.com");
Cliente b = new Cliente( 1212);


        b = SentenciasHQL.select_User(b);
        System.out.println(b.toString());

    }


}
