package com.group4.ethazi_ad.controlador;

        import com.group4.ethazi_ad.modelo.clases.Administrador;
        import com.group4.ethazi_ad.modelo.clases.Cliente;
        import com.group4.ethazi_ad.modelo.clases.TiposAdmin;

public class Prueba {
    public static void main(String[] args) {
        Cliente c = new Cliente(1212, "nick",
                "11111111J", "11111111", "jon@gmail.com");
Cliente b = new Cliente( 1212);
        Administrador ins = new Administrador(11111, "aaabbb", "passsss", TiposAdmin.EDITOR.toString());
//SentenciasHQL.insert_User(ins);
        Administrador ad = new Administrador(2, "du", null, TiposAdmin.EDITOR.toString());

//SentenciasHQL.select_Users_Contain_Search("jo");



    }


}
