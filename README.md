# localizacao

Solução para o problema descrito em https://github.com/involvestecnologia/selecaoinvolves/tree/master/desafio-localizacao.

## Requisitos
Para rodar este programa é necessário ter instalado:
- Java;
- MongoDB;
- NPM;

## Como rodar
O primeiro passo é carregar os dados na base de dados. Para tal, é necessário iniciar o servidor do banco.
```
$ sudo service mongod start
```
Em seguida, a partir do diretório base deste projeto, executar os seguintes comandos:
```
$ mongoinport -d localizacao -c funcionarios --type csv --file data/funcionarios.csv --headerline
$ mongoinport -d localizacao -c lojas --type csv --file data/lojas.csv --headerline
```
Para associar os funcionários às lojas mais próximas, o arquivo .jar localizado na pasta back deve ser executado.
```
$ cd back
$ java -jar localizacao.jar
```
Por fim, para visualizar os resultados obtidos, executar:
```
$ cd ../front
$ npm start
```
Os resultados estão disponíveis através da URL `localhost:3000` no navegador.

## Arquitetura
Como os requisitos do projeto incluíam executá-lo rapidamente pelo terminal, foi tomada a decisão de separar o back-end do front-end.

### Back-end
Para o back-end foi utilizado Java.

Foi implementada uma classe para cada um dos modelos utilizados (funcionários e lojas). Apesar de serem similares (as duas são formadas por nome e coordenadas), numa perspectiva de aumento do programa elas provavelmente tomariam rumos bastante distintos. Mesmo assim, optou-se por fazer as duas serem extensões de um ObjetoGeografico, classe criada para generalizar as operações entre quaisquer objetos que possam ter coordenadas.

Cada uma das atividades realizadas (conversão de graus em radianos e cálculo da distância entre objetos, por exemplo) foi implementada numa classe de serviço. Cada serviço executa apenas uma ação. Sendo assim, foram nomeados de forma que sua função fique clara. Os serviços foram planejados de forma que possam ser reaproveitados no maior número de lugares possível e evitem ao máximo a repetição de código. Dentro do cálculo de distâncias diversos ângulos precisam ser convertidos, por exemplo. Ao invés de calcular a conversão em cada um destes momentos, foi criado um serviço para fazê-lo.

Como é um programa simples, executado pelo terminal, não há a implementação de nenhuma visão. O único controlador implementado é responsável por controlar o fluxo o cálculo das distâncias através dos serviços apropriados, e é chamado pela função principal.
A interação com o banco de dados é feita através de interfaces. Desta forma, é possível implementar integrações com qualquer banco de dados desejado, desde que eles retornem os dados necessários para o fluxo do programa.

Foram utilizados também arquivos de configuração para armazenar constantes (como o raio da terra) e configurações (como os gateways da base de dados).

### Front-end
O front-end foi implementado com React.js, SCSS e ES6.

Inicialmente foi necessário criar uma aplicação servidor para resgatar os dados do banco e fornecê-los à aplicação React. Isto foi feito com base neste tutorial: https://medium.com/javascript-in-plain-english/full-stack-mongodb-react-node-js-express-js-in-one-simple-app-6cc8ed6de274.

Tendo feito isto, procurou-se organizar os componentes, novamente, de forma a organizar da melhor forma possível sua utilização e de diminuir ao máximo a repetição de código.

Para elevar a legibilidade do resultado foi disponibilizada a visualização dos funcionários e lojas presentes no banco de dados utilizado, assim como as associações. Estas podem ser vistas como uma lista de funcionários, cada um com as lojas próximas listadas, ou como uma lista de lojas, novamente com todos os funcionários próximos listados. Assim é possível que o usuário tenha um entendimento do problema sob mais de uma perspectiva.
