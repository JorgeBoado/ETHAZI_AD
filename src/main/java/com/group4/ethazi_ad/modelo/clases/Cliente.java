package com.group4.ethazi_ad.modelo.clases;

import com.group4.ethazi_ad.modelo.constantes.Literales;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = -8355922957048928946L;

	private int id;
	private String nick;
	private String dni;
	private String pass;
	private String email;

	public Cliente(int id, String nick, String dni, String pass, String email) {
		super();
		this.id = id;
		this.nick = nick;
		this.dni = dni;
		this.pass = pass;
		this.email = email;
	}

	public Cliente() {
	}

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		String datos = "";
		datos += Literales.ClientsLiterals.ID + this.id + "\n";
		datos += Literales.ClientsLiterals.DNI + this.dni + "\n";
		datos += Literales.ClientsLiterals.NICK + this.nick + "\n";
		datos += Literales.ClientsLiterals.EMAIL + this.email;
		return datos;
	}

	public void cifrar() {
		this.pass = DigestUtils.sha256Hex(this.pass);

	}
}