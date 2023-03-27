// criando a collection
db.createCollection("rotas")

// inserindo many 
db.rotas.insertMany([
    {
        "descricao": "Rota de São Paulo até Brasília",
        "local_partida": "São Paulo",
        "local_destino": "Brasília",
        "status": "ATIVO",

    },
    {
        "descricao": "Rota de São Paulo até Rio de Janeiro",
        "local_partida": "São Paulo",
        "local_destino": "Rio de Janeiro",
        "status": "ATIVO",
    },
    {
        "descricao": "Rota de Rio de Janeiro até Minas Gerais",
        "local_partida": "Rio de Janeiro",
        "local_destino": "Minas Gerais",
        "status": "ATIVO",
    },
    {
        "descricao": "Rota de Minas Gerais até Bahia",
        "local_partida": "Minas Gerais",
        "local_destino": "Bahia",
        "status": "ATIVO",
    }
])

db.rotas.insertMany([
    {
        "descricao": "Rota de Fortaleza até Recife",
        "local_partida": "Fortaleza",
        "local_destino": "Recife",
        "status": "INATIVO",

    },
    {
        "descricao": "Rota de Fortaleza até Natal",
        "local_partida": "Fortaleza",
        "local_destino": "Natal",
        "status": "INATIVO",
    },
    {
        "descricao": "Rota de Recife até Salvador",
        "local_partida": "Recife",
        "local_destino": "Salvador",
        "status": "INATIVO",
    },
    {
        "descricao": "Rota de Salvador até Alagoas",
        "local_partida": "Salvador",
        "local_destino": "Alagoas",
        "status": "INATIVO",
    }
])

// criando consultas
// in
db.rotas.find({
    "local_partida": {
        $in: ["Salvador", "Recife"]
    }
})
// or
db.rotas.find({
    $or: [
        { "local_partida": "Fortaleza" },
        { "local_destino": "Alagoas" }
    ]
})
// find all
db.rotas.find(
    {
        "status": "INATIVO"
    }
)
// find with regex
db.rotas.find().sort(
    { 'local_partida': /^São/ }
)