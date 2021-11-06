package com.crescer.v1.model.enums;

public enum SituacaoProdutoEnum {
	APROVADO("APROVADO"), PENDENTE("PENDENTE"), REJEITADO("REJEITADO");

	private String tipo;

	SituacaoProdutoEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static SituacaoProdutoEnum toEnum(Object value) {
		SituacaoProdutoEnum ret = null;
		for (SituacaoProdutoEnum enumObj : SituacaoProdutoEnum.values()) {
			if (value.equals(enumObj.tipo)) {
				ret = enumObj;
			}
		}

		return ret;
	}

}