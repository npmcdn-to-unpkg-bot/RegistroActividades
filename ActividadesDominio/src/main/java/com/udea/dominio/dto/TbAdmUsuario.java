package com.udea.dominio.dto;
// Generated 28/04/2016 10:30:44 PM by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmUsuario generated by hbm2java
 */
public class TbAdmUsuario implements java.io.Serializable {

	private long nbId;
	private TbPersona tbPersona;
	private String vrLogin;
	private Boolean nbActivo;
	private Set tbAdmUsuarioxrols = new HashSet(0);

	public TbAdmUsuario() {
	}

	public TbAdmUsuario(long nbId, TbPersona tbPersona, String vrLogin) {
		this.nbId = nbId;
		this.tbPersona = tbPersona;
		this.vrLogin = vrLogin;
	}

	public TbAdmUsuario(long nbId, TbPersona tbPersona, String vrLogin, Boolean nbActivo, Set tbAdmUsuarioxrols) {
		this.nbId = nbId;
		this.tbPersona = tbPersona;
		this.vrLogin = vrLogin;
		this.nbActivo = nbActivo;
		this.tbAdmUsuarioxrols = tbAdmUsuarioxrols;
	}

	public long getNbId() {
		return this.nbId;
	}

	public void setNbId(long nbId) {
		this.nbId = nbId;
	}

	public TbPersona getTbPersona() {
		return this.tbPersona;
	}

	public void setTbPersona(TbPersona tbPersona) {
		this.tbPersona = tbPersona;
	}

	public String getVrLogin() {
		return this.vrLogin;
	}

	public void setVrLogin(String vrLogin) {
		this.vrLogin = vrLogin;
	}

	public Boolean getNbActivo() {
		return this.nbActivo;
	}

	public void setNbActivo(Boolean nbActivo) {
		this.nbActivo = nbActivo;
	}

	public Set getTbAdmUsuarioxrols() {
		return this.tbAdmUsuarioxrols;
	}

	public void setTbAdmUsuarioxrols(Set tbAdmUsuarioxrols) {
		this.tbAdmUsuarioxrols = tbAdmUsuarioxrols;
	}

}
