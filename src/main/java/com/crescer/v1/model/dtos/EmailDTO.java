package com.crescer.v1.model.dtos;

public class EmailDTO {
    private String usuario;
    private String senha;
    private String mensagem;
    private String destinatarios;
    private String assunto;
    
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
}
