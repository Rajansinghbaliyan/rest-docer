FROM maven:3.8.4-openjdk-8-slim AS build
RUN mkdir /project

# installing and caching all the dependencies
COPY pom.xml /project
WORKDIR /project
RUN mvn dependency:go-offline

COPY . /project
WORKDIR /project
# running the clean build
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-alpine
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
COPY --from=build /project/target/restdocker-0.0.1-SNAPSHOT.jar /app/restdocker-0.0.1-SNAPSHOT.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
EXPOSE 8080
CMD "java" "-jar" "restdocker-0.0.1-SNAPSHOT.jar"