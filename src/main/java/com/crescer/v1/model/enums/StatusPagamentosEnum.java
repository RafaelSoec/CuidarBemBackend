package com.crescer.v1.model.enums;

public enum StatusPagamentosEnum {
	DISPONIVEL(1),INDISPONIVEL(2),  OFERTA(3);

	private Integer tipo;

	StatusPagamentosEnum(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getTipo() {
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