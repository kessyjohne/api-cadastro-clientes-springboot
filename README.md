# API de Cadastro de Clientes

API REST desenvolvida em Java com Spring Boot para gerenciamento de clientes (CRUD completo).

## 🎯 Objetivo do projeto

Projeto criado para praticar o desenvolvimento de uma API REST com Spring Boot e JPA, como parte da minha transição de carreira para a área de desenvolvimento Java, aplicando conceitos de arquitetura em camadas (model, repository, controller) e persistência com banco de dados relacional.

## 🛠 Tecnologias

- Java 17
- Spring Boot 4
- Spring Data JPA
- Spring Security + JWT
- Bean Validation
- MySQL
- JUnit 5 + MockMvc (testes) com H2 em memória
- Maven

## ▶️ Como executar

1. Clone o repositório
```bash
   git clone https://github.com/kessyjohne/api-cadastro-clientes-springboot.git
```
2. Configure suas credenciais do MySQL no arquivo `src/main/resources/application.properties`
3. Execute o projeto
```bash
   mvn spring-boot:run
```
4. A API estará disponível em `http://localhost:8080`

5. Para acessar `/clientes`, primeiro crie um usuário em `POST /auth/registrar`, faça login em `POST /auth/login` e envie o token recebido no header `Authorization: Bearer <token>`

## 🧪 Testes

O projeto possui testes de integração que cobrem:
- Criação de cliente com sucesso
- Validação de campos obrigatórios (retorna 400 sem nome)
- Bloqueio de acesso a rotas protegidas sem autenticação

Para rodar:
```bash
mvn test
```
Os testes usam um banco H2 em memória, sem afetar o MySQL de desenvolvimento.

## 📌 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /clientes | Cria um novo cliente |
| GET | /clientes | Lista todos os clientes |
| GET | /clientes/{id} | Busca cliente por id |
| PUT | /clientes/{id} | Atualiza um cliente existente |
| DELETE | /clientes/{id} | Remove um cliente |
| POST | /auth/registrar | Cria um novo usuário |
| POST | /auth/login | Autentica e retorna token JWT |

## 📸 Exemplo de uso

**Login de usuário (POST /auth/login):**

![Exemplo LOGIN no Postman](docs/login-usuario.png)

**Listando clientes (GET /clientes):**

![Exemplo GET no Postman](docs/get-clientes.png)


## 🚀 Próximos passos

- [x] Adicionar validação de campos (Bean Validation)
- [x] Implementar autenticação e autorização com Spring Security + JWT
- [x] Escrever testes automatizados
- [ ] Containerizar a aplicação com Docker

## 👤 Autor

Kessy Johne  
[LinkedIn](https://www.linkedin.com/in/kessyjohne/) | [GitHub](https://github.com/kessyjohne)
