Para configurar um ambiente usando Docker Compose com PostgreSQL e pgAdmin atualizados, você precisará criar um arquivo `docker-compose.yml` que define os serviços para ambos. Aqui está um exemplo básico para configurar o PostgreSQL e o pgAdmin usando as versões mais recentes das imagens Docker:

### Exemplo de `docker-compose.yml`

```yaml
version: '3.8'

services:
  db:
    image: postgres:latest
    container_name: postgres
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_USER: myuser
      POSTGRES_PASSWORD: mypassword
    volumes:
      - postgres_data:/var/lib/postgresql/data
    networks:
      - my_network

  pgadmin:
    image: dpage/pgadmin4:latest
    container_name: pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@example.com
      PGADMIN_DEFAULT_PASSWORD: admin
    ports:
      - "8080:80"
    networks:
      - my_network

networks:
  my_network:
    driver: bridge

volumes:
  postgres_data:
```

### Descrição do `docker-compose.yml`

1. **Serviço `db` (PostgreSQL):**
   - `image`: Usa a imagem mais recente do PostgreSQL.
   - `container_name`: Nome do contêiner para referência.
   - `environment`: Define variáveis de ambiente para criar o banco de dados, usuário e senha.
   - `volumes`: Persiste dados do banco de dados fora do contêiner para evitar perda de dados em reinicializações.
   - `networks`: Conecta o serviço à rede definida.

2. **Serviço `pgadmin` (pgAdmin):**
   - `image`: Usa a imagem mais recente do pgAdmin.
   - `container_name`: Nome do contêiner para referência.
   - `environment`: Define email e senha para o acesso ao pgAdmin.
   - `ports`: Mapeia a porta 80 do contêiner para a porta 8080 do host, para que você possa acessar o pgAdmin via `http://localhost:8080`.
   - `networks`: Conecta o serviço à mesma rede que o PostgreSQL para que eles possam se comunicar.

3. **Redes e Volumes:**
   - Define uma rede chamada `my_network` usando o driver `bridge` para comunicação entre contêineres.
   - Define um volume chamado `postgres_data` para persistir os dados do PostgreSQL.

### Passos para iniciar os serviços

1. **Crie o arquivo `docker-compose.yml`:**
   - Salve o conteúdo acima em um arquivo chamado `docker-compose.yml`.

2. **Inicie os serviços:**
   - No terminal, navegue até o diretório onde o arquivo `docker-compose.yml` está localizado e execute:

     ```bash
     docker-compose up -d
     ```

   - O `-d` faz com que os contêineres sejam executados em segundo plano.

3. **Acesse o pgAdmin:**
   - Abra um navegador e vá para `http://localhost:8080`.
   - Faça login com o e-mail e a senha que você configurou (admin@example.com / admin).

4. **Conecte-se ao PostgreSQL no pgAdmin:**
   - No pgAdmin, crie uma nova conexão de servidor e use os seguintes detalhes:
     - **Host**: `db` (ou o nome do serviço PostgreSQL definido no `docker-compose.yml`)
     - **Port**: `5432` (porta padrão do PostgreSQL)
     - **Username**: `myuser`
     - **Password**: `mypassword`
___

# Configurando o Java

1. Configurando o SDKMan
```bash
curl -s "https://get.sdkman.io" | bash
```

2. Instalando o Java 17
```bash
sdk install java 17.0.11-sem
```

# Executar aplicação Spring Boot

Usar o Maven Wrapper (`./mvnw`) para executar sua aplicação Spring Boot é uma ótima maneira de garantir que todos os desenvolvedores usem a mesma versão do Maven especificada no projeto, independentemente das versões locais instaladas.

Aqui estão os comandos principais que você pode usar com o Maven Wrapper para compilar, executar e gerenciar sua aplicação Spring Boot:

### 1. **Compilar o Projeto**

Para compilar o projeto e instalar as dependências, use:

```bash
./mvnw clean install
```

- **`clean`**: Remove arquivos de build antigos.
- **`install`**: Compila o código e instala o pacote no repositório local do Maven.

### 2. **Executar a Aplicação Spring Boot**

Para executar a aplicação Spring Boot diretamente, use:

```bash
./mvnw spring-boot:run
```

Este comando compila e executa a aplicação sem precisar criar um JAR separado.

### 3. **Criar um JAR Executável**

Para criar um JAR executável para sua aplicação, use:

```bash
./mvnw package
```

Este comando gera um arquivo JAR no diretório `target`. O nome do arquivo geralmente segue o padrão `nome-do-projeto-versao.jar`. 

Para executar o JAR gerado, use:

```bash
java -jar target/nome-do-projeto-versao.jar
```

Substitua `nome-do-projeto-versao.jar` pelo nome real do arquivo JAR gerado.

### 4. **Executar Testes**

Para executar os testes do seu projeto, use:

```bash
./mvnw test
```

Este comando executa todos os testes definidos no seu projeto.

### 5. **Limpar o Projeto**

Para limpar os arquivos de build e diretórios gerados, use:

```bash
./mvnw clean
```

Este comando remove o diretório `target` e outros arquivos de build para garantir um build limpo.

### Exemplos de Comandos

Aqui está um resumo dos comandos para executar com o Maven Wrapper:

- **Compilar e instalar**:

  ```bash
  ./mvnw clean install
  ```

- **Executar a aplicação Spring Boot**:

  ```bash
  ./mvnw spring-boot:run
  ```

- **Criar um JAR e executar**:

  ```bash
  ./mvnw package
  java -jar target/nome-do-projeto-versao.jar
  ```

- **Executar os testes**:

  ```bash
  ./mvnw test
  ```

- **Limpar o projeto**:

  ```bash
  ./mvnw clean
  ```

### Notas Adicionais

- **Permissões de Execução**: Se você encontrar problemas com a execução do `./mvnw` em um sistema Unix (Linux ou macOS), verifique se o script tem permissões de execução. Você pode adicionar permissões com:

  ```bash
  chmod +x mvnw
  ```

- **Verificar Versão do Maven Wrapper**: Se precisar verificar a versão do Maven que o Maven Wrapper está configurado para usar, você pode usar:

  ```bash
  ./mvnw -v
  ```

Isso exibirá a versão do Maven configurada no wrapper.

Seguindo esses comandos, você poderá gerenciar a construção, execução e teste de sua aplicação Spring Boot de maneira eficaz usando o Maven Wrapper. Se tiver mais perguntas ou precisar de mais ajuda, estou aqui para ajudar!


## Acessar o APP via navegador

Acesse `http://localhost:9090/` e faça login com `demo` / `demo`.