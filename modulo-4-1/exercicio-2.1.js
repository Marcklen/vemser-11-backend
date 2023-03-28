db.alunos.insertMany([
    {
        "nome": "Alana",
        "data_nascimento": new Date(1986, 10, 1),
        "curso": {
            "nome": "Ciências da Computação"
        },
        "notas": [8.0, 4.0, 3.5],
        "habilidades": [
            {
                "nome": "inglês",
                "nível": "avançado"
            },
            {
                "nome": "beach tennis",
                "nível": "avançado"
            }
        ]
    },
    {
        "nome": "Carlos",
        "data_nascimento": new Date(1992, 5, 22),
        "curso": {
            "nome": "Redes de Telecomunicação"
        },
        "notas": [10.0, 9.0, 9.5],
        "habilidades": [
            {
                "nome": "inglês",
                "nível": "básico"
            },
            {
                "nome": "taekwondo",
                "nível": "avançado"
            }
        ]
    },
    {
        "nome": "Xavier",
        "data_nascimento": new Date(1982, 12, 3),
        "curso": {
            "nome": "Ciências da Computação"
        },
        "notas": [8.0, 5.0, 6.5],
        "habilidades": [
            {
                "nome": "alemão",
                "nível": "intermediário"
            },
            {
                "nome": "taekwondo",
                "nível": "avançado"
            }
        ]
    },
    {
        "nome": "Martha",
        "data_nascimento": new Date(1969, 6, 19),
        "curso": {
            "nome": "Sistemas de informação"
        },
        "notas": [10.0, 9.0, 9.5],
        "habilidades": [
            {
                "nome": "inglês",
                "nível": "avançado"
            },
            {
                "nome": "boxing",
                "nível": "básico"
            }
        ]
    }
])

// buscando por curso
db.alunos.find({
    "curso.nome": "Ciências da Computação"
})

// ordenando por curso
db.alunos.find({}, {_id: 0, nome: 1, "curso.nome": 1}).sort({"curso.nome": 1})

// ordendando por nome da pessoa
db.alunos.find({}, {_id: 0, nome: 1, "curso.nome": 1}).sort({nome : 1})

// ordendando por nome da pessoa e habilidade
db.alunos.find({}, {_id: 0, nome: 1, "habilidades.nome": 1}).sort({nome : 1, "habilidades.nome": 1})

// buscar por notas menores ou igual a 4
db.alunos.find({
    notas: { $lte: 4 }
})

// buscar por notas menores ou igual a 4 e curso de ciência da computação
db.alunos.find({ notas: { $lte: 4 }, "curso.nome": "Ciências da Computação" })


// buscar por habilidades de inglês e nível básico
db.alunos.find({
    habilidades: {
        $elemMatch: {
            nome: "inglês",
            nível: "básico"
        }
    }
})