package com.crescer.v1.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {
	@Value("${app.utils.whatsapp}")
	private String whatsapp;

	@Value("${app.utils.pix}")
	private String pix;

	public String recuperarWhatsapp() {
		return whatsapp;
	}

	public String recuperarPix() {
		return pix;
	}
}
