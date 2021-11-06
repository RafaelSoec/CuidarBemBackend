package com.crescer.v1.model.enums;

public enum StatusPagamentosEnum {
	APROVADO("APROVADO"), PENDENTE("PENDENTE"), REJEITADO("REJEITADO");

	private String tipo;

	StatusPagamentosEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static StatusPagamentosEnum toEnum(Object value) {
		StatusPagamentosEnum ret = null;
		for (StatusPagamentosEnum enumObj : StatusPagamentosEnum.values()) {
			if (value.equals(enumObj.tipo)) {
				ret = enumObj;
			}
		}

		return ret;
	}

}