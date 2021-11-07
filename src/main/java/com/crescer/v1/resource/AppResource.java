package com.crescer.v1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescer.v1.model.dtos.EmailDTO;
import com.crescer.v1.model.dtos.PixDTO;
import com.crescer.v1.service.EmailService;
import com.crescer.v1.utils.AppUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/util")
public class AppResource {

	@Autowired
	private EmailService emailService;

	@Autowired
	private AppUtils appUtils;

	@PostMapping("/enviarEmail")
	public void enviarEmail(EmailDTO email) {
		this.emailService.enviarEmail(email);
	}

	@GetMapping("/whatsapp")
	public String recuperarWhatsapp() {
		return appUtils.recuperarWhatsapp();
	}

	@GetMapping("/pix")
	public PixDTO recuperarPix( ) {
		return appUtils.recuperarPix();
	}

}
