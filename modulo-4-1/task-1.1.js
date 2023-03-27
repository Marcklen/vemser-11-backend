// inserindo apenas 1
db.alunos.insert(
{
    "nome" : "João",
    "data_nascimento" : new Date (1994,02,26), 
    "curso" : {
        "nome" : "Sistemas de informação"
    },
    "notas" : [10.0, 9.0, 4.5],
    "habilidades": [
        {
            "nome" : "inglês",
            "nível" : "avançado"
        },
        {
            "nome" : "taekwondo",
            "nível" : "básico"
        }
    ]
}
)

// inserindo muitos
db.alunos.insertMany([
{
    "nome" : "Maria",
    "data_nascimento" : new Date (1990,10,05), 
    "curso" : {
        "nome" : "Ciências da Computação"
    },
    "notas" : [9.0, 8.0, 5.5],
    "habilidades": [
        {
            "nome" : "inglês",
            "nível" : "básico"
        },
        {
            "nome" : "beach tennis",
            "nível" : "intermediário"
        }
    ]
},
{
    "nome" : "Pedro",
    "data_nascimento" : new Date (1998,01,03), 
    "curso" : {
        "nome" : "Redes de Telecomunicação"
    },
    "notas" : [10.0, 5.0, 6.5],
    "habilidades": [
        {
            "nome" : "inglês",
            "nível" : "avançado"
        },
        {
            "nome" : "beach tennis",
            "nível" : "básico"
        }
    ]
}
])

// criando as consultas personalizadas