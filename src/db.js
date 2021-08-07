const CryptoJS = require("crypto-js");
const secretKey = process.env.SECRET ? process.env.SECRET : "321zsds929hahhasdjadaxASDA27162XMASH1233K219233L";

const email = require("./email");

async function connection(){
  // if(global.connection && global.connection.state !== "disconnected"){
  //   return global.connection;
  // }

  const mysql = require("mysql2/promise");

  // create the connection to database
  const connection = await mysql.createConnection({
    host: process.env.DB_HOST,
    port: process.env.DB_PORT,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_DATABASE, 
    /*host: '162.241.2.84',
    port: '3306',
    user: 'cresc799_root',
    password: 'admin',
    database: 'cresc799_CrescerBem',*/
    waitForConnections: true,
  });

  // global.connection = connection;
  return connection;
}

async function login(usuario){
  try{
    const conn = await connection();
    const user = await getUsuarioByEmail(usuario.email, conn);
    if(user){
      console.log("senha: " + user.senha)
      const senha = decriptarSenha(user.senha);
      console.log("decr senha: " + senha)
      conn.end();
      if(senha === `"${usuario.senha}"`){
        return user;
      }else{
        return new ErrorResponse("Usuário ou senha inválido.");
      }
    }else{
      return new ErrorResponse("Usuário não cadastrado.");
    }
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function atualizarPedido(pedido){
  try{
    const conn = await connection();
    await conn.query(`UPDATE Pedido SET situacao='${pedido.situacao}' WHERE id=${pedido.id}`);
    conn.end();
    return pedido;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function atualizarCliente(cliente){
  try{
    const conn = await connection();
    await conn.query(`UPDATE Cliente SET nome='${cliente.nome}', telefone='${cliente.telefone}', cpf='${cliente.cpf}',
    sobrenome='${cliente.sobrenome}', logradouro='${cliente.logradouro}', estado='${cliente.estado}',
    municipio='${cliente.municipio}', complemento='${cliente.complemento}', cep='${cliente.cep}', numero='${cliente.numero}'
    WHERE id=${cliente.id}`);
    conn.end();
    return cliente;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function atualizarSenha(data){
  try{
    const conn = await connection();
    novaSenha = encriptarSenha(data.novaSenha);
    await conn.query(`UPDATE Usuario SET senha='${novaSenha}'  WHERE email='${data.usuario.email}' AND senha='${data.usuario.senha}'`);
    conn.end();
    data.usuario.senha = novaSenha;

    return data.usuario;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}


async function getEntidadeById(entidade, id){
  try {
    const conn = await connection();
    const [rows,fields] =  await conn.query(`Select *From ${entidade} WHERE id = ?`, [id]);
    conn.end();
    return rows[0];
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function getClienteByCpf(cpf){
  try {
    const conn = await connection();
    const [rows,fields] =  await conn.query(`Select *From Cliente WHERE cpf = ?`, [cpf]);
    conn.end();
    return rows[0];
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function criarPacote(pacote){
  try{
    const conn = await connection();
    const resp = await conn.query(`INSERT INTO Locacao (pct_desconto, qtd_dias) VALUES(${pacote.porcentagemDesconto}, ${pacote.quantidadeDias})`);
    const [rows,fields] = await conn.query(`Select *From Locacao WHERE qtd_dias = ?`, [pacote.quantidadeDias]);
    conn.end();
    pacote.id = resp[0].insertId;

    return rows[0];
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }

}

async function criarCategoria(categoria){
  try{
    const conn = await connection();
    const resp = await conn.query(`INSERT INTO Categoria (nome) VALUES('${categoria.nome}')`);
    conn.end();
    categoria.id = resp[0].insertId;

    return categoria;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }

}

async function criarFaixa(faixa){
  try{
    const conn = await connection();
    const resp = await conn.query(`INSERT INTO Faixa (nome) VALUES('${faixa.nome}')`);
    conn.end();
    faixa.id = resp[0].insertId;

    return faixa;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }

}


async function criarProduto(produto){
  try{
    const conn = await connection();
    const resp = await conn.query(`INSERT INTO Produto
    (nome, descricao, estoque, quantidade, locacao, categoria, situacao, valor, avaliacao, faixa_etaria, imagem)
    VALUES('${produto.nome}', '${produto.descricao}', ${produto.estoque}, ${produto.quantidade},
    ${produto.pacote}, ${produto.categoria}, ${produto.situacao}, ${produto.valor}, ${produto.avaliacao},
    ${produto.faixaEtaria}, '${produto.imagem}') `);
    conn.end();
    produto.id = resp[0].insertId;

    return produto;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }

}

async function vincularImagemProduto(produtoImagem){
  try{
    const conn = await connection();
    const resp = await conn.query(`INSERT INTO ProdutoImagem
    (id_produto, url_imagem) VALUES( '${produtoImagem.idProduto}', '${produtoImagem.imagem}')`);
    return produtoImagem;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }

}


async function getImagensPorDiretorio(diretorio){
  try{
    const conn = await connection();
    const [rows,fields] =  await conn.query(`Select *From Imagem img  where img.diretorio like '%${diretorio}%'`);

    return rows;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function getImagensPorId(id){
  try{
    const conn = await connection();
    const [rows,fields] =  await conn.query(`Select *From Imagem img  where img.id  = ${id}`);

    return rows;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function criarPedido(pedido){
  try{
    const conn = await connection();
    const [rows,fields] = await conn.query(`INSERT INTO Pedido (produto, quantidade, descricao, valor, data, situacao, cliente, numero)
    VALUES(	'${pedido.produto}', '${pedido.quantidade}', 
      '${pedido.descricao}', '${pedido.valor}', '${pedido.data}', 
      '${pedido.situacao}', '${pedido.cliente}', '${pedido.numero}')`);
      conn.end();
      pedido.id = rows[0].insertId;
  
      return pedido;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function criarUsuario(usuario){
  try{
    const conn = await connection();
    const row = await getUsuarioByEmail(usuario.email, conn);
    if(!row){
      usuario.senha = encriptarSenha(usuario.senha);
      await conn.query(`INSERT INTO Usuario (email, senha) VALUES('${usuario.email}', '${usuario.senha}')`);
      const user = await getUsuarioByEmail(usuario.email, conn);

      await conn.query(`INSERT INTO Cliente (id, nome, telefone, cpf, sobrenome, logradouro, estado, municipio, complemento, cep)
      VALUES(${user.id}, '', '', '', '', '', '', '', '', '')`);
      conn.end();

      return user;
    }else{
      return new ErrorResponse("Email já cadastrado.");
    }
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function getUsuarioByEmail(email, conn){
  try {
    if(!conn){
      conn = await connection();
    }
    const [rows,fields] =  await conn.query(`Select *From Usuario WHERE email = ?`, [email]);
    return rows[0];
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function recuperarSenhaEEnviarEmail(dados){
  try {
    const conn = await connection();
    const [rows,fields] =  await conn.query(`Select *From Usuario WHERE email = ?`, [dados.destinatarios]);
  
    if(rows[0]){
      const senha = gerarNovaSenha(10);
      const novaSenha = encriptarSenha(senha);
      dados.mensagem = 
      `<div style="margin-left: 10px; margin-right: 10px; margin-top: 20px">
        <div class="">
          <p>Olá, criamos essa nova senha para você:
            <b>${senha}</b>
          </p>
        </div>
      </div>`;

      const resp = await email.enviarEmail(dados);
      if(resp.accepted && resp.accepted.length > 0){
        await conn.query(`UPDATE Usuario SET senha='${novaSenha}'  WHERE email='${dados.destinatarios}'`);
        conn.end();
      }
      return resp;
    }else{
      return new ErrorResponse("Usuário não localizado.");
    }
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function enviarEmail(dados){
  try {
    const resp = await email.enviarEmail(dados);
    return resp;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function getEntidade(entidade){
  try {
    const conn = await connection();

    const [rows,fields] =  await conn.query(`Select *From ${entidade} Order by id`);
    conn.end();
    return rows;
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}

async function removeEntidadeById(entidade, id){
  try {
    const entity = await getEntidadeById(entidade, id)
    if(entity){
      const conn = await connection();
      const [rows,fields] =  await conn.query(`Delete From ${entidade} Where id = ?`, [id]);
      conn.end();
      return;
    }else{
      return new ErrorResponse("Entidade não encontrada");
    }
  }
  catch (e) {
    return new ErrorResponse(e["message"]);
  }
}


function encriptarSenha(senha) {
  return CryptoJS.AES.encrypt(
    JSON.stringify(senha),
    secretKey
  ).toString();
}

function decriptarSenha(senha) {
  const bytes  = CryptoJS.AES.decrypt(senha, secretKey);
  const res = bytes.toString(CryptoJS.enc.Utf8);
  return res;
}

function gerarNovaSenha(numCaracteres) {
  let pass = "";
  for (var i = 0; i < numCaracteres; i++) {
    pass += gerarCaracter();
  }
  return pass;
}

function gerarCaracter() {
  var ascii = [
    [48, 57],
    [64, 90],
    [97, 122],
  ];
  var i = Math.floor(Math.random() * ascii.length);
  return String.fromCharCode(
    Math.floor(Math.random() * (ascii[i][1] - ascii[i][0])) + ascii[i][0]
  );
}

const ErrorResponse = function(msg) {
  this.mensagem = msg;
  this.status = 500;
};

module.exports = {connection, getEntidade, removeEntidadeById, 
  getEntidadeById, criarFaixa, criarUsuario, criarPedido, criarPacote, recuperarSenhaEEnviarEmail,
  criarProduto, vincularImagemProduto, getImagensPorDiretorio, getImagensPorId,
  criarCategoria, login, atualizarCliente, atualizarPedido, atualizarSenha, enviarEmail}
