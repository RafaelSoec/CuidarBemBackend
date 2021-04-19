const nodemailer = require('nodemailer');

async function enviarEmail(email) {
  try{
      // create reusable transporter object using the default SMTP transport
      let transporter = nodemailer.createTransport({
        host: "smtp.gmail.com",
        port: 587,
        secure: false, // true for 465, false for other ports
        auth: {
          user: email.usuario, // generated ethereal user
          pass: email.senha, // generated ethereal password
        },
      });
  
    // send mail with defined transport object
    let info = await transporter.sendMail({
      from: `"Crescer Bem" <${email.usuario}>`, // sender address
      to: `${email.destinatarios}`, // list of receivers
      subject: `${email.assunto}`, // Subject line
      text: `${email.mensagem}`, // plain text body
      html: `${email.mensagem}`, // html body
    });

    return info;
    
  }
  catch (e) {
    return new ErrorResponse("Usuario ou senha inválido.");
  }
}

const ErrorResponse = function(msg) {
  this.mensagem = msg;
  this.status = 500;
};


module.exports = {enviarEmail}
