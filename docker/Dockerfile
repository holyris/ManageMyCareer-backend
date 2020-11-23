FROM adoptopenjdk/openjdk11:alpine as base
RUN echo "base"
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package

FROM base as development
RUN echo "development"

ENTRYPOINT ["./mvnw","spring-boot:run"]


FROM base as build
RUN echo "build"
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM adoptopenjdk/openjdk11:alpine-jre as production
RUN echo "production"
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-classpath", "/app:/app/lib/*", "fr.univparis8.iut.csid.Application"]