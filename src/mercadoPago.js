const mercadopago = require ('mercadopago');

function comprarProdutos(produtos) {
    // Configura credenciais
  
    // Add Your credentials
    mercadopago.configure({
      access_token: 'PROD_ACCESS_TOKEN'
      //   access_token: 'TEST-7778485648018849-033021-620875813a4ef7e99485798a12728185-410460126'
    });
  
    // Create a preference object
    let preference = {
      items: [
        {
          title: 'My Item',
          unit_price: 100,
          quantity: 1,
        }
      ]
    };
  
    mercadopago.preferences.create(preference)
    .then(function(response){
    // This value replaces the String "<%= global.id %>" in your HTML
      global.id = response.body.id;
    }).catch(function(error){
      console.log(error);
    });
}
  
const ErrorResponse = function(msg) {
    this.mensagem = msg;
    this.status = 500;
  };
  
module.exports = {comprarProdutos}