# MrBet 🎲⚽

## 📌 Descrição
O **MrBet** é um sistema em **Java** para gerenciamento de apostas esportivas em campeonatos e times.  
O projeto permite cadastrar times, criar campeonatos, associar times a competições e registrar apostas, oferecendo uma estrutura modular e extensível para simulações ou estudos acadêmicos.

Este projeto foi desenvolvido como parte de atividades laboratoriais da disciplina de Programação Orientada a Objetos.

---

## 🚀 Funcionalidades
- Cadastro e gerenciamento de **Times**.
- Criação e acompanhamento de **Campeonatos**.
- Associação de times a campeonatos.
- Registro de **Apostas** em campeonatos.
- Consultas de informações cadastradas.

---

## 🛠️ Estrutura do Projeto
- `MrBetMain.java` → Ponto de entrada do sistema (interface textual).
- `MrBetControler.java` → Camada de controle, responsável pela lógica principal.
- `MrBetFachada.java` → Fachada do sistema, centraliza chamadas para simplificar a interação.
- `Time.java` → Representa um time cadastrado.
- `Campeonato.java` → Representa um campeonato esportivo.

---

## 📂 Estrutura de classes
   ````bash
   src/mrbet
   ├── MrBetMain.java # Ponto de entrada do sistema
   ├── MrBetFachada.java # Fachada para interação com regras de negócio
   ├── MrBetControler.java # Controlador principal
   ├── Time.java # Classe de domínio para representar times
   ├── Campeonato.java # Classe de domínio para representar campeonatos
   ````
---

## 💻 Tecnologias Utilizadas
- **Java** (>= 11)
- Paradigma **Orientado a Objetos**
- Padrão de projeto **Fachada** para simplificação da API

---

## 📂 Como Executar
1. Certifique-se de ter o **JDK 11 ou superior** instalado.
2. Clone este repositório:
   ````bash
   git clone https://github.com/Gledson-Perdival-Junior/MrBet.git
   ````

3. Navegue até a pasta do projeto:
   ````bash
   cd MrBet/laboratorio-4-gledson-perdival/src
   ````

4. Compile o projeto:
   ````bash
   javac mrbet/*.java
   ````

5. Execute o programa:
   ````bash
   java mrbet.MrBetMain
   ````
