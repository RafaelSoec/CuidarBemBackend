package com.crescer.v1.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.crescer.v1.model.dtos.PixDTO;

@Component
public class AppUtils {
	@Value("${app.utils.whatsapp}")
	private String whatsapp;

	@Value("${app.utils.chavePix}")
	private String chavePix;

	@Value("${app.utils.nomePix}")
	private String nomePix;

	public String recuperarWhatsapp() {
		return whatsapp;
	}

	public PixDTO recuperarPix() {
		return new PixDTO(nomePix, chavePix);
	}
	
}
