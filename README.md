# atvsocket
Atividade do dia 22/03/2019 na matéria de POO

# Proposta 
Crie um cliente e um servidor.

## Servidor: 

* O servidor deve possuir uma lista de produtos (id, nome, preco) e uma lista de pessoas (id, nome, cpf). Insira 4 produtos e 4 pessoas com dados genéricos nas respectivas listas.
* O servidor fica aguardando por uma conexao com cliente 
* Após conectado, o servidor aguarda por um comando do cliente
* Três comandos são possíveis: 
  * 1 - Listar Produtos: O servidor envia ao cliente a lista de produtos
  * 2 - Listar Pessoas: O servidor envia ao cliente a lista de pessoas
  * 0 - Encerrar: O servidor desconecta do socket, fecha a porta e encerra
  
## Cliente:
* Deve conectar ao servidor
* Depois de contectado, imprima essas opcoes:
   * 1 - Listar os produtos
   * 2 - Listar Pessoas
   * 0 - Encerrar
* Aguarde o usuario escolher uma opção e a envie ao servidor.
* Logo após enviar, fique aguardando pela resposta do servidor e imprima o que recebeu.
* Depois imprima novamente o menu, até que o usuário escolha a opção 0 (zero).
* Encerre a conexão e o programa assim que o usuário escolher 0 (zero)
