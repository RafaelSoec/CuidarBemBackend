// SDK de Mercado Pago
const mercadopago = require ('mercadopago');
const express = require('express');
const cors = require('cors');
const fs = require('fs');
const app = express();


app.use(express.json());
app.use(cors());
// app.options('*', cors())

const db = require("./db");
const pdf = require('html-pdf');
const mercadoPago = require("./mercadoPago");


app.get('/pedido/todos', async(req, res) =>{
  const todos = await db.getEntidade('Pedido');
  return Response(todos, res);
});

app.delete('/pedido/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Pedido', id);
  return Response(todos, res);
});

app.post('/pedido/salvar', async(req, res) =>{
  const user = await db.criarPedido(req.body);

  return Response(user, res);
});

app.put('/pedido/atualizar', async(req, res) =>{
  const user = await db.atualizarPedido(req.body);

  return Response(user, res);
});

app.get('/imagem/getImagensPorDiretorio', async(req, res) =>{
  const img = await db.getImagensPorDiretorio(req.query.diretorio);
  return Response(img, res);
});

app.get('/imagem/getImagensPorId', async(req, res) =>{
  const img = await db.getImagensPorId(req.query.id);
  return Response(img, res);
});

app.delete('/produto/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Produto', id);
  return Response(todos, res);
});


app.post('/produto/vincularImagem', async(req, res) =>{
  const prod = await db.vincularImagemProduto(req.body);
  return Response(prod, res);
});

app.get('/produto/todos', async(req, res) =>{
    const todos = await db.getEntidade('Produto');

    return Response(todos, res);
});

app.post('/produto', async(req, res) =>{
  const user = await db.criarProduto(req.body);

  return Response(user, res);
});

app.get('/pacote/todos', async(req, res) =>{
  const todos = await db.getEntidade('Locacao');
  return Response(todos, res);
});

app.delete('/pacote/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Pacote', id);
  return Response(todos, res);
});

app.post('/pacote', async(req, res) =>{
  const user = await db.criarPacote(req.body);

  return Response(user, res);
});

app.get('/faixa/todos', async(req, res) =>{
  const todos = await db.getEntidade('Faixa');
  return Response(todos, res);
});

app.delete('/faixa/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Faixa', id);
  return Response(todos, res);
});

app.post('/faixa', async(req, res) =>{
  const user = await db.criarFaixa(req.body);

  return Response(user, res);
});

app.get('/categoria/todos', async(req, res) =>{
  const todos = await db.getEntidade('Categoria');
  return Response(todos, res);
});

app.delete('/categoria/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Categoria', id);
  return Response(todos, res);
});

app.post('/categoria', async(req, res) =>{
  const user = await db.criarCategoria(req.body);

  return Response(user, res);
});

app.get('/categoria', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.getEntidadeById('Categoria', id);
  return Response(todos, res);
});

app.get('/cliente/todos', async(req, res) =>{
  const todos = await db.getEntidade('Cliente');
  return Response(todos, res);
});

app.delete('/cliente/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Cliente', id);
  return Response(todos, res);
});

app.get('/cliente', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.getEntidadeById('Cliente', id);
  return Response(todos, res);
});

app.post('/cliente', async(req, res) =>{
  const user = await db.criarCliente(req.body);

  return Response(user, res);
});

app.put('/cliente/atualizar', async(req, res) =>{
  const user = await db.atualizarCliente(req.body);

  return Response(user, res);
});

app.get('/usuario/todos', async(req, res) =>{
  const todos = await db.getEntidade('Usuario');
  return Response(todos, res);
});

app.post('/usuario/atualizarSenha', async(req, res) =>{
  const usuario = await db.atualizarSenha(req.body);
  return Response(usuario, res);
});

app.delete('/usuario/excluir', async(req, res) =>{
  const id = req.query.id;
  const todos = await db.removeEntidadeById('Usuario', id);
  return Response(todos, res);
});

app.post('/usuario', async(req, res) =>{
  const user = await db.criarUsuario(req.body);

  return Response(user, res);
});

app.post('/usuario/login', async(req, res) =>{
  const user = await db.login(req.body);

  return Response(user, res);
});

app.post('/mercado-pago', async(req, res) => {
  const resp = mercadoPago.comprarProdutos(req.body);
  return Response(resp, res);
});

app.get('/util/pix', async(req, res) => {
  return Response(process.env.PIX, res);
});

app.get('/util/whatsapp', async(req, res) => {
  return Response(process.env.WHATSAPP, res);
});

//app.get('/util/tokenMercadoPago', async(req, res) => {
  //return Response(process.env.TOKEN_MERCADO_PAGO, res);
//});

app.post('/enviarEmail', async(req, res) => {
  const resp = await db.enviarEmail(req.body);
  return Response(resp, res);
});

app.post('/recuperarSenhaEEnviarEmail', async(req, res) => {
  const resp = await db.recuperarSenhaEEnviarEmail(req.body);
  return Response(resp, res);
});

app.post('/gerarPdf', async(req, res) => {
  console.log(req.body.html)
  const html = req.body.html;
  const options = {
      type: 'pdf',
      format: 'A4',
      orientation: 'portrait'
  }

  pdf.create(html, options).toBuffer((err, buffer) => {
      if(err) return res.status(500).json(err)
      res.end(buffer)               
  })
});

function Response(object, res){
  if(object && object["status"] && object["status"] != 200){
    return res.status(object["status"]).send(object);
  }else{
    res.json(object);
  }
}


console.log("Iniciando Servidor.....");
app.listen(process.env.PORT || 3300);
console.log("Servidor iniciado");

