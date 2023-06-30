# bellezeapi
Bellezze API é uma API Restful desenvolvida para fornecer serviços relacionados à beleza e bem-estar. Ela permite que os usuários acessem informações sobre profissionais, serviços, agendamentos e muito mais.

Funcionalidades
A API Bellezze oferece as seguintes funcionalidades principais:

Cadastro e gerenciamento de profissionais da área de beleza
Cadastro e gerenciamento de serviços oferecidos pelos profissionais
Agendamento de serviços pelos usuários
Gerenciamento de reservas e disponibilidade dos profissionais
Autenticação e autorização de usuários
Documentação da API usando o Swagger UI
Pré-requisitos
Antes de executar a API Bellezze, verifique se o seguinte software está instalado em sua máquina:(ou use o docker)

Java 17
MySQL Server
Maven
Docker (opcional)
Configuração
Siga as etapas abaixo para configurar e executar a API Bellezze:

Clone este repositório para o seu ambiente local.
Importe o projeto em sua IDE favorita (recomendado: IntelliJ, Eclipse, VS Code).
Configure as informações de conexão do banco de dados no arquivo application.properties.
Compile o projeto usando o Maven: mvn clean package.
Execute o projeto: java -jar target/belezzeAPIREST.jar.
Acesse a documentação da API em http://localhost:8080/swagger-ui.html.
Contribuição
Se você deseja contribuir para o desenvolvimento da Bellezze API, siga estas etapas:


Crie uma nova branch para sua contribuição: git checkout -b minha-contribuicao.
Faça as alterações desejadas e commit: git commit -m "Minha contribuição".
Envie suas alterações para o repositório remoto: git push origin minha-contribuicao.
Crie um novo Pull Request para revisão.



EXECUTANDO COM DOCKER 

Certifique-se de ter o Docker instalado e em execução na sua máquina.
Abra o terminal ou prompt de comando e navegue até o diretório raiz do seu projeto onde está localizado o Dockerfile.
Execute o comando docker build -t nome-da-imagem ., substituindo "nome-da-imagem" pelo nome desejado para a imagem Docker.
Aguarde o Docker construir a imagem com base nas instruções do Dockerfile e nas dependências do seu projeto. Isso pode levar alguns minutos.
Após a conclusão da construção da imagem, você pode executá-la com o comando docker run -p 8080:8080 nome-da-imagem, substituindo "nome-da-imagem" pelo nome da imagem que você definiu anteriormente.
O contêiner será iniciado e a sua aplicação estará disponível na porta 8080 do seu sistema local.
Você pode acessar a API via Postman e realizar os devidos testes.
