FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

COPY wait-for-it.sh .

RUN mvn clean package -DskipTests

FROM openjdk:17-alpine

RUN apk add --no-cache bash

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

COPY --from=build /app/wait-for-it.sh /app/wait-for-it.sh

RUN chmod +x /app/wait-for-it.sh

CMD ["/app/wait-for-it.sh", "mysql-donation:3306", "-t", "30", "--", "java", "-jar", "app.jar"]
