package com.group4.ethazi_ad.controlador;

        import com.group4.ethazi_ad.modelo.clases.Administrador;
        import com.group4.ethazi_ad.modelo.clases.Cliente;
        import com.group4.ethazi_ad.modelo.constantes.Literales;

        import java.util.ArrayList;

public class Prueba {
    public static void main(String[] args) {
        Cliente c = new Cliente(1212, "nick",
                "11111111J", "11111111", "jon@gmail.com");
       // Administrador a = new Administrador((Integer) 2,"du","ro","editor");
        ArrayList<Cliente> clients = new ArrayList<>();
        ArrayList<Administrador> admins = new ArrayList<>();

   /* clients = SentenciasHQL.select_Clients_Contain_Search("Jo");
        clientesToString(clients);

        clients = new ArrayList<>();
    clients = SentenciasHQL.select_Clients_Contain_Client(c);
        clientesToString(clients);

        admins = SentenciasHQL.select_Admins_Contain_Nick("du", Literales.EDITOR);
        adminsToString(admins);
*/
   admins = SentenciasHQL.select_all_Admins();
   adminsToString(admins);
    }

    private static void clientesToString(ArrayList<Cliente> clients) {
        if (clients.size() == 0 ){
            System.out.println("select_clientes_contains_search 0");
        }
        for (int i = 0;i < clients.size(); i++ ){
            System.out.println(clients.get(i).toString());
        }
    }
    private static void adminsToString(ArrayList<Administrador> admins) {
        if (admins.size() == 0 ){
            System.out.println("select_clientes_contains_search 0");
        }
        for (int i = 0;i < admins.size(); i++ ){
            System.out.println(admins.get(i).toString());
        }
    }


}
