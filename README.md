# bellezeapi
Belezze API é uma API restful, a qual destina-se para administração de empresas de estética.

tecnologias usadas:

Java 17
Spring
MySQL Server
Maven
Docker (opcional)

Configuração
Siga as etapas abaixo para configurar e executar a API Bellezze:
- Faça o clone deste projeto utilizando git clone + link.
- Acesse a pasta do projeto. Ex: cd belezzeapi.
- Quando estiver na pasta do projeto, troque para branch master (atenção a branch, pois é lá que está as codificações).
- Na branch master, não esqueça do pull.
- Agora vamos executar o projeto usando Docker (Certifique-se de ter docker instalado em sua máquina).
- Digite: docker build -t nome-imagem
- Por fim, execute: docker run -p 8080:8080 nome-imagem (lembre-se, porta 8080 deve estar livre, senão use outra porta)
- Para testar, baixe a collection do postman neste drive: https://drive.google.com/drive/folders/1ZTCHkQK0mXXsJDgbDZtgbFlrcptGa5ln?usp=drive_link
- Pode também usar: https://dark-star-283022.postman.co/workspace/a038e1fb-5fd8-4b7b-a015-76d849f17b8a/collection/28280782-e77d9562-34e7-4f76-80ee-843707c44408?action=share&creator=28280782
- Anexe ao postman, e execute as funcionalidades como desejar.
- Para visualizar a documentação, acesse: http://localhost:8080/swagger-ui/index.html


No mesmo link de drive consta a parte escrita do projeto.


