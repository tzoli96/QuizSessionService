FROM maven:3.8.4-openjdk-17-slim AS build

RUN apt-get update && apt-get install -y curl wget xz-utils && \
    wget https://github.com/watchexec/watchexec/releases/download/cli-v1.18.10/watchexec-1.18.10-x86_64-unknown-linux-musl.tar.xz && \
    tar -xf watchexec-1.18.10-x86_64-unknown-linux-musl.tar.xz && \
    mv watchexec-1.18.10-x86_64-unknown-linux-musl/watchexec /usr/local/bin/ && \
    chmod +x /usr/local/bin/watchexec

WORKDIR /app
COPY pom.xml /app/
RUN mvn dependency:go-offline

COPY src /app/src

CMD ["sh", "-c", "mvn flyway:migrate && watchexec -r -e java,pom.xml 'mvn clean spring-boot:run'"]
