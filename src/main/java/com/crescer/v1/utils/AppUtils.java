package com.crescer.v1.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.crescer.v1.model.dtos.PixDTO;
import com.crescer.v1.model.dtos.WhatsappDTO;

@Component
public class AppUtils {
	@Value("${app.utils.whatsapp}")
	private String whatsappLink;

	@Value("${app.utils.chavePix}")
	private String chavePix;

	@Value("${app.utils.nomePix}")
	private String nomePix;

	public WhatsappDTO recuperarWhatsapp() {
		WhatsappDTO whatsappDTO = new WhatsappDTO();
		whatsappDTO.setLink(whatsappLink);
		
		return whatsappDTO;
	}

	public PixDTO recuperarPix() {
		return new PixDTO(nomePix, chavePix);
	}
	
}
