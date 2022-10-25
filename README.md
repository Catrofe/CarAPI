# Teste Técnico WS Work JAVA.

### Como Rodar o Código

Por ser uma aplicação spring é bem simples, tudo que precisa é rodar as dependencias do maven e subir o docker.
Se estiver usando o InteliJ (IDE Recomendada) ele facilitará muito as coisas.
Para rodar o docker use o "docker-compose up" na pasta em que ele se encontra.


### Por que utilizei o Postgres?

Optei por ele ser um banco muito querido pelo mercado alem de atender bem as necessidades do projeto.


### Resumo Geral 

Como estrutura de arquivos utilizei uma abordagem que venho aprendendo nos meus cursos.
- Controller: Responsável por receber as requisições HTPP.
- Services: Contem as regras de negócio e se comunicam com o banco de dados.
- Repository: Contem a conectividade com o banco.
- DTO: Contem os objetos que vão ser enviados pelo front.
- VO: Contem o que o servidor irá retornar para o front.
- Utils: Contem utilidades globais do projeto.

Durante a criação dos endpoits foquei em utilizar DRY e um pouco de SOLID. Gosto de trabalhar no formato de micro-serviços, por isso utilizei modulos.
Cada entity representa um modulo e somente o service desse modulo pode usar o repository do mesmo. Isso facilita manutenção e faz com que possamos saber exatamente onde se encontra o problema e facilita na criação de novas FEATS.

Busquei padronizar o máximo o projeto permitindo ser bem fácil de compreender e de dar manutenção. Acredito que tenho conseguido atingir esse objetivo.
Busquei tambem não aumentar a complexidade do teste, mantive o solicitado na documentação.


Para facilitar o avaliador fiz de uma forma que os endpoints tanto do Java quanto do Kotlin são identicos. Tanto no input quanto no Output. Acredito que isso possa facilitar o avaliador.

Desde já agradeço a Oportunidade a toda equipe WS.

Postman Brand: https://documenter.getpostman.com/view/14906669/2s84LNUt72
Postman Model: https://documenter.getpostman.com/view/14906669/2s84LNUt73
Postman Car: https://documenter.getpostman.com/view/14906669/2s84LNUt74
