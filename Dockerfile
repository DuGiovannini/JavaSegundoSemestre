# ----------------------------------------------------------------------
# Stage 1: Build da Aplicação (Opcional, mas recomendado para CI)
# O pipeline Maven@3 já faz o build, mas esta é uma alternativa Clean
# ----------------------------------------------------------------------
# FROM eclipse-temurin:17-jdk-focal AS build

# WORKDIR /app

# # Copia o arquivo de configuração do projeto (pom.xml) e baixa dependências
# COPY pom.xml .
# RUN mvn dependency:go-offline

# # Copia o código-fonte
# COPY src ./src

# # Compila e empacota o JAR
# RUN mvn package -DskipTests

# # ----------------------------------------------------------------------
# Stage 2: Criação da Imagem Final (Jah existe o JAR, mas vamos usar o JAR do build do Azure)
# Para simplificar, focaremos apenas no estágio de "Runtime" 
# e usaremos o JAR gerado pela task Maven@3 no Azure Pipeline.
# ----------------------------------------------------------------------

# Imagem base leve para rodar o Java
FROM eclipse-temurin:17-jre-alpine

# Define argumentos para o nome do arquivo JAR (será passado durante o build Docker no pipeline)
# O nome padrão do JAR gerado pelo Maven (Ex: challenge-0.0.1-SNAPSHOT.jar)
ARG JAR_FILE=target/*.jar

# Adiciona o JAR compilado ao container
COPY ${JAR_FILE} app.jar

# Configura o fuso horário (opcional)
ENV TZ=America/Sao_Paulo

# Expõe a porta que sua aplicação Spring Boot utiliza (padrão 8080)
EXPOSE 8080

# Comando para rodar a aplicação quando o container iniciar
ENTRYPOINT ["java", "-jar", "/app.jar"]