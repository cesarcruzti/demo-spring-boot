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
