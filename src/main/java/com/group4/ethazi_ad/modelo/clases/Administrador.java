package com.group4.ethazi_ad.modelo.clases;

import java.io.Serializable;
import com.group4.ethazi_ad.modelo.constantes.Literales;

/**
 * Clase Administrador.
 *
 * @author : Jon
 * @version : 19/12/2018
 * @see : com.group4.ethazi_ad.modelo.constantes.Literales
 *
 * Administradores de la base de datos,  pueden ser root y editor:
 * El root se encarga de administrar los usuarios, el editor los alojamientos
 */
public class Administrador implements Serializable {

	private static final long serialVersionUID = 2829577527646470799L;

	private int id;
	private String nick;
	private String pass;
	private TiposAdmin tipo;

	/**
	 * Los tipos de Administrador posibles Tiposadmin.
	 */
	public  enum TiposAdmin { root, editor }

	/**
	 * Constructor de Administrador.
	 *
	 * @param id   el numero de identificacion
	 * @param nick el nombre de usuario
	 * @param pass la contraseña
	 * @param tipo el tipo de usuario
	 */
	public Administrador(int id, String nick, String pass, TiposAdmin tipo) {
		super();
		this.id = id;
		this.nick = nick;
		this.pass = pass;
		this.tipo = tipo;
	}


	/**
	 * Getters de Administrador
	 *
	 *
	 * @return id   el numero de identificacion
	 */
	public int getid() {
		return id;
	}
	/**
	 * @return nick el nombre de usuario
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * @return pass la contraseña
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @return tipo el tipo de usuario
	 */
	public TiposAdmin getTipo() {
		return tipo;
	}

	/**


	/**
     * Setters de Administrador
	 *
	 * @param id   el numero de identificacion
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param nick el nombre de usuario
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * @param pass la contraseña
	 */
	public void setPass(String pass) { this.pass = pass; }
	/**
	 * @param tipo el tipo de usuario
	 */
	public void setTipo(TiposAdmin tipo) {
		this.tipo = tipo;
	}


	/**
	 * Metodo sobreescrito toString
	 * @return los datos de el usuario, salvo la contraseña
	 */
	@Override
	public String toString() {
		String datos = "";
		datos += Literales.ID + this.id + "\n";
		datos += Literales.NICK + this.nick + "\n";
		datos += Literales.T_ADMIN + this.tipo;
		return datos;
	}

}
