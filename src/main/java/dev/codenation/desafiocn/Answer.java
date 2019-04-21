package dev.codenation.desafiocn;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Answer implements Serializable {

	private static final long serialVersionUID = 4129300008901532734L;

	@SerializedName("numero_casas")
	private int numeroCasas;

	private String token;

	private String cifrado;

	private String decifrado;

	@SerializedName("resumo_criptografico")
	private String resumoCriptografico;

	public int getNumeroCasas() {
		return numeroCasas;
	}

	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}

	public String getDecifrado() {
		return decifrado;
	}

	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}

	public String getResumoCriptografico() {
		return resumoCriptografico;
	}

	public void setResumoCriptografico(String resumoCriptografico) {
		this.resumoCriptografico = resumoCriptografico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cifrado == null) ? 0 : cifrado.hashCode());
		result = prime * result + ((decifrado == null) ? 0 : decifrado.hashCode());
		result = prime * result + numeroCasas;
		result = prime * result + ((resumoCriptografico == null) ? 0 : resumoCriptografico.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (cifrado == null) {
			if (other.cifrado != null)
				return false;
		} else if (!cifrado.equals(other.cifrado))
			return false;
		if (decifrado == null) {
			if (other.decifrado != null)
				return false;
		} else if (!decifrado.equals(other.decifrado))
			return false;
		if (numeroCasas != other.numeroCasas)
			return false;
		if (resumoCriptografico == null) {
			if (other.resumoCriptografico != null)
				return false;
		} else if (!resumoCriptografico.equals(other.resumoCriptografico))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [numeroCasas=" + numeroCasas + ", token=" + token + ", cifrado=" + cifrado + ", decifrado="
				+ decifrado + ", resumoCriptografico=" + resumoCriptografico + "]";
	}

}
