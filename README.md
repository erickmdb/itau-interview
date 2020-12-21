As aplicações estão não estão rodando dentro do localstack, somente o banco de dados.

Para executar o front-end é necessário ter o Angular CLI instalado. 
É necessário ter docker instalado para subir o localstack

- Navegue para a pasta itau-interview-senior-be e execute o comando "./gradlew bootRunLocal" para subir o localstack, já com o banco iniciado, e para subir o back-end do sistema. Para parar o localstack, execute "./gradlew stopLocalStack"
-Para subir o front-end do sistema, navegue para a pasta itau-interview-senior-fe e execute o comando "ng serve"

O front-end irá iniciar na porta 4200 de sua máquina. acesse no navegador pelo endereço http://localhost:4200/
O back-ande irá subir na porta 9080.
