package com.group4.ethazi_ad.controlador;


import org.hibernate.Transaction;
import org.hibernate.Session;

import com.group4.ethazi_ad.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Cliente;

public class SentenciasHQL {

    public static void ins_Cliente (Cliente cliente){
        Session session = SessionManager.getSession();
        //genera una transaccion
        Transaction tx = session.beginTransaction();
        //Inserta los clientes
        session.save(cliente);
        tx.commit();
        session.close();
    }


}
