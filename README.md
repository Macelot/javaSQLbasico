# javaSQLbasico

File New Project Maven nome demosql2
colocar GroupId: org.example
ArtifacId: demosql2

colocar adependência
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.21</version>
</dependency>

dentro de src main java, criar o pacote org.example.demosql2, criar o main

Classes
Emp = nossa classe com modelo de dados
EmpDAO = nossa classe com operações no banco de dados, dropTable, createTable, insertOne, insert, update, delete, getEmpById, getEmployees.
DB_Connection = faz a conexão com o MySQL
Main = faz as opereção básicas de exemplo: Apaga a Tabela, Cria a Tabela, Cria um empregado, Lista, Cria mais um empregado, Lista novamente, Lê o empregado id=1, Altera o salário para Zero do empregado id=1, Lista novamente, Apaga o empregado id=1, Lista novamente!
