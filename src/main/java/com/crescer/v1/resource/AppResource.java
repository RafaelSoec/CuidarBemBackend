package com.crescer.v1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescer.v1.model.dtos.EmailDTO;
import com.crescer.v1.utils.EmailUtils;

@RestController
@RequestMapping(value = "/util")
public class AppResource {

	@Value("${app.utils.whatsapp}")
	private String whatsapp;

	@Value("${app.utils.pix}")
	private String pix;

	@Autowired
	private EmailUtils emailUtils;

	@PostMapping("/enviarEmail")
	public void enviarEmail(EmailDTO email) {
		this.emailUtils.enviar(email);
	}

	@PostMapping("/recuperarSenhaEEnviarEmail")
	public String recuperarSenhaEEnviarEmail(EmailDTO email) {
		return this.emailUtils.recuperarSenhaEEnviarEmail(email);
	}

	@GetMapping("/whatsapp")
	public String recuperarWhatsapp() {
		return whatsapp;
	}

	@GetMapping("/pix")
	public String recuperarPix( ) {
		return pix;
	}

}
