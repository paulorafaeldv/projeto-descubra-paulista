# Descubra Paulista - API de Turismo e Cultura
## 📝 Descrição do Projeto
O Descubra Paulista é uma plataforma digital desenvolvida para fomentar o turismo sustentável e a valorização cultural na cidade de Paulista, Pernambuco. O sistema funciona como um guia interativo, conectando cidadãos e turistas aos pontos históricos, eventos e empreendedores locais.

## 🎯 Objetivo (Problema que resolve)
O projeto visa resolver a fragmentação de informações sobre o lazer e a cultura na região. Ao centralizar a agenda de eventos e oferecer roteiros personalizados, o app facilita o acesso da população às atividades da cidade e impulsiona a economia criativa, oferecendo visibilidade aos artesãos e produtores culturais locais.

## 🛠 Tecnologias Usadas
Linguagem: Java.

Framework: Spring Boot.

Banco de Dados: MySQL ou Oracle (conforme modelagem).

Persistência: Spring Data JPA.

Versionamento: Git & GitHub.

Gestão: Metodologia Ágil (Scrum) via Trello.

## 🚀 Como rodar o projeto
Clonar o repositório:

Bash
git clone https://github.com/paulorafaeldv/projeto-descubra-paulista.git

2.  **Configurar o Banco de Dados:**
    *   Crie um banco de dados local.
    *   Atualize as credenciais no arquivo `src/main/resources/application.properties`.
3.  **Compilar e Rodar:**
    *   Via terminal: `./mvnw spring-boot:run` ou através da sua IDE (IntelliJ/Eclipse).

## 📑 Endpoints da API
Abaixo estão as principais rotas baseadas na modelagem de dados:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/usuarios` | Cadastro de novos usuários (Turista/Empreendedor). |
| **GET** | `/pontos-turisticos` | Lista todos os locais históricos e culturais. |
| **GET** | `/eventos` | Retorna a agenda de eventos da cidade. |
| **POST** | `/roteiros` | Cria um novo roteiro personalizado. |

## 🧪 Como rodar testes

## 👥 Integrantes do Grupo
Hercilio de Sena Sales - 01817900
Kauê Pimentel dos Santos Costa - 01775988
Kelly Ferreira da Silva - 01832940
Maria Eduarda da Conceição Souza - 01810116
Maria Eduarda Silva de Oliveira - 01831554
Maria Fernanda da Silva Costa - 01744866
Paulo Rafael Brandão Santos - (Scrum Master / Desenvolvedor Backend)


