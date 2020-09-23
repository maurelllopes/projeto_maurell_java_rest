# projeto_maurell_java_rest

Implementação a partir de um modelo conceitual. Diagrama em .png para baixar

Esse Projeto tem como objetivo mostrar na prática como um modelo conceitual (modelo de domínio em nível de análise) pode ser implementado sobre o paradigma orientado a objetos, usando padrões de mercado e boas práticas.
Vamos tomar como caso um modelo conceitual abrangente, com o qual possamos mostrar a implementação prática em linguagem orientada a objetos dos seguintes tópicos:

 Leitura e entendimento do diagrama de classes

 Leitura e entendimento do diagrama de objetos

 Associações

o Um para muitos / muitos para um

o Um para um

o Muitos para muitos comum

o Muitos para muitos com classe de associação o Bidirecionais / direcionadas

 Conceito independente / dependente

 Classe de associação

 Herança

 Enumerações

 Atributos Embedded (ItemPedidoPK)

 Coleções ElementCollection (telefones de um cliente)

Ao longo do projeto mostrarei boas práticas de Engenharia de Software tais como desenvolvimento em camadas e tratamento de exceções. A estrutura de camadas do sistema será conforme mostrado a seguir:
 


1) Fazer uma implementação padrão do seguinte modelo conceitual:
  
 3) Gerar uma base de dados relacional automaticamente a partir do modelo conceitual, bem como povoar a base com a instância dada. 
 4) Recuperar os dados e disponibilizá-los por meio de uma API Rest BÁSICA. Os seguintes end points devem ser disponibilizados:
 
End point

/categorias/{id}
Categoria e seus produtos

/clientes/{id}
Cliente, seus telefones e seus endereços

/pedidos/{id}
Pedido, seu cliente, seu pagamento, seus itens de pedido, seu endereço de entrega
