package com.group4.ethazi_ad.modelo.clases;

import java.io.Serializable;
import com.group4.ethazi_ad.modelo.constantes.Literales;

public class Administrador implements Serializable {

	private static final long serialVersionUID = 2829577527646470799L;

	private int id;
	private String nick;
	private String pass;
	private TiposAdmin tipo;

	public static enum TiposAdmin {
		root, editor
	}

	public Administrador(int id, String nick, String pass, TiposAdmin tipo) {
		super();
		this.id = id;
		this.nick = nick;
		this.pass = pass;
		this.tipo = tipo;
	}

	public int getAdminId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public TiposAdmin getTipo() {
		return tipo;
	}

	public void setTipo(TiposAdmin tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		String datos = "";
		datos += Literales.ID + this.id + "\n";
		datos += Literales.NICK + this.nick + "\n";
		datos += Literales.T_ADMIN + this.tipo;
		return datos;
	}

}
