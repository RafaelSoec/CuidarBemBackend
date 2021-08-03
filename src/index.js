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
const mercadoPago = require("./mercadoPago");


app.get('/getImagensPorDiretorio', async(req, res) =>{
  const img = await db.getImagensPorDiretorios(req.query.diretorio);
  return Response(img, res);
});

app.get('/getImagensPorId', async(req, res) =>{
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


app.post('/enviar-email', async(req, res) => {
  const resp = await db.recuperarSenhaEEnviarEmail(req.body);
  return Response(resp, res);
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

