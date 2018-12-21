package com.group4.ethazi_ad.modelo.clases;

import java.io.Serializable;
import com.group4.ethazi_ad.modelo.constantes.Literales;


public class Administrador implements Serializable {

	private static final long serialVersionUID = 1056505022894794374L;
	private int id;
	private String nick;
	private String pass;
	private String role;

	public Administrador(int id, String nick, String pass, String role) {
		super();
		this.id = id;
		this.nick = nick;
		this.pass = pass;
		this.role = role;
	}
	public Administrador() {}

	public int getId() {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		String datos = "";
		datos += Literales.ID + this.id + "\n";
		datos += Literales.NICK + this.nick + "\n";
		datos += Literales.T_ADMIN + this.role;
		return datos;
	}

}
