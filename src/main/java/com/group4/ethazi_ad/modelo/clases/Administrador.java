package com.group4.ethazi_ad.modelo.clases;

import com.group4.ethazi_ad.modelo.constantes.Literales;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;


public class Administrador implements Serializable {

	private static final long serialVersionUID = 1056505022894794374L;
	private int id;
	private String nick;
	private String pass;
	private String role;
	private String name;

	public Administrador(int id, String nick, String pass, String role, String name) {
		super();
		Object integer = new Integer(id);
		if (!integer.equals(null)) {
			this.id = id;		
		}
	
		this.nick = nick;
		this.pass = pass;
		this.role = role;
		this.name = name;
	}
	public Administrador() {}

	public Administrador(String nick, String pass, String role, String name) {
		this.nick = nick;
		this.pass = pass;
		this.role = role;
		this.name = name;
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
	public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
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
		datos += Literales.AdminsLiterals.ID + this.id + "\n";
		datos += Literales.AdminsLiterals.NICK + this.nick + "\n";
		datos += Literales.AdminsLiterals.NAME + this.name + "\n";
		datos += Literales.AdminsLiterals.T_ADMIN + this.role;
		return datos;
	}
	public String cifrar(){
		return DigestUtils.sha256Hex(this.pass);
	}

}
