package com.crescer.v1.model.enums;

public enum PerfilEnum {
	ADMIN("ADMIN"),
	CLIENTE("CLIENTE");
	
	private String tipo;
	
	PerfilEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static PerfilEnum toEnum(Object value) {
		PerfilEnum ret = null;
		for( PerfilEnum enumObj: PerfilEnum.values()) {
			if(value.equals(enumObj.tipo)) {
				ret =  enumObj;
			}
		}
		
		return ret;
	}


}