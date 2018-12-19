package com.group4.ethazi_ad.controlador;

        import com.group4.ethazi_ad.modelo.clases.Cliente;

public class Prueba {
    public static void main(String[] args) {
        Cliente c = new Cliente(1212, "nick",
                "123456789J", "11111111", "jon@gmail.com");

        SentenciasHQL.ins_Cliente(c);
    }
}
