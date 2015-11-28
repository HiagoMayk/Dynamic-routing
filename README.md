# Dynamic-routing

## Roteamento dinâmico baseado em Dijkstra-SPF / Bellman–Ford.

#### Problema:
 
O trânsito das informações entre as diferentes redes que compõe a Internet é realizado por nós denominados roteadores. Em cada rede temos um ou vários roteadores, conectados entre si por meio de enlaces de tecnologias, largura de banda e atrasos de propagação diferentes. Numa rede de pequeno porte, a tarefa de definição das rotas das mensagens é trivial, geralmente realizada de forma fixa (roteamento estático). À medida que o número de roteadores e redes aumenta, cresce exponencialmente o número de rotas possíveis.
 
Sendo assim, um dos problemas a ser enfrentado em redes de computadores é o estabelecimento de um estratégia para criação e manutenção dinâmica das tabelas de rotas, conhecido como roteamento dinâmico. Neste contexto, podemos, idealmente, modelar as redes *Internet Protocol* (IP) como um Grafo Acíclico Dirigido (DAG), onde os vértices representam os roteadores, as arestas como os enlaces entre os roteadores, e os pesos das arestas a métrica dos respectivos enlaces (largura de banda, atraso, confiabilidade do *link*, entre outras).
 
 
#### Proposta:
 
Utilizando algoritmos como Dijkstra-SPF ou Bellman–Ford, elaborar um abordagem que calcule o melhor caminho em uma rede com N roteadores e M enlaces/pesos (Ny,Nz), dada uma origem Nx. Usar como métrica/peso a largura de banda (ex.: 64 Kbps, 1 Mbps, 5 Mbps, 10 Mbps).

#### Membros:
###### Hiago Mayk Gomes de Araujo Rocha
###### Pedro Phittipaldi dos Santos Coelho Alves
###### Stefano Momo Loss
