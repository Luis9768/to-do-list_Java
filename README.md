# 📝 To-Do List MVC

Um sistema robusto de gestão de tarefas desenvolvido em Java, focado na aplicação de boas práticas de Engenharia de Software, padrões de projeto e segurança.

## 🚀 Sobre o Projeto

Este projeto não é apenas uma lista de tarefas; é um estudo prático sobre arquitetura de software. A aplicação foi construída do zero sem frameworks automáticos, para demonstrar o domínio sobre o funcionamento interno de sistemas backend.

O sistema segue o padrão **MVC (Model-View-Controller)** para separar responsabilidades e utiliza o padrão **DAO (Data Access Object)** para abstrair a comunicação com a base de dados.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Arquitetura:** MVC + DAO
* **Base de Dados:** MySQL (Hospedado na AWS EC2)
* **Conectividade:** JDBC (Java Database Connectivity)
* **Gestão de Dependências:** Maven
* **Segurança:** Variáveis de Ambiente para proteção de credenciais

## ⚙️ Funcionalidades (CRUD Completo)

A aplicação roda na consola (CLI) e permite:

* ✅ **Criar:** Adicionar novas tarefas ao banco de dados.
* 📋 **Ler:** Listar todas as tarefas salvas.
* 🔄 **Atualizar:** Marcar tarefas como concluídas.
* ❌ **Remover:** Apagar tarefas pelo ID.

## 🔒 Segurança e Configuração

Este projeto utiliza boas práticas de segurança e não mantém credenciais no código fonte. Para rodar localmente, é necessário configurar as seguintes Variáveis de Ambiente no sistema operativo ou na IDE:

* `DB_USER`: O seu utilizador do MySQL
* `DB_PASSWORD`: A sua senha do MySQL

## 📦 Como Rodar

1.  Clone o repositório:
    ```bash
    git clone [https://github.com/Luis9768/nome-do-teu-repo.git](https://github.com/Luis9768/nome-do-teu-repo.git)
    ```
2.  Abra o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code).
3.  Configure as variáveis de ambiente citadas acima.
4.  Execute a classe `Main.java`.

---
*Desenvolvido para fins de estudo em Java e Arquitetura de Software.*
