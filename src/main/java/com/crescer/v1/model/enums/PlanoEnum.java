package com.crescer.v1.model.enums;

public enum PlanoEnum {
	DIARIO(1L),
	SEMANAL(2L),
	MENSAL(3L);
	
	private Long tipo;
	
	PlanoEnum(Long tipo) {
		this.tipo = tipo;
	}

	public Long getTipo() {
		return tipo;
	}

	public static PlanoEnum toEnum(Object value) {
		PlanoEnum ret = null;
		for( PlanoEnum enumObj: PlanoEnum.values()) {
			if(value.equals(enumObj.tipo)) {
				ret =  enumObj;
			}
		}
		
		return ret;
	}


}