FROM maven:3.6.3-openjdk-11 AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

COPY db	/tmp/db/

WORKDIR /tmp/

RUN mvn package

FROM openjdk

MAINTAINER eduardosco1@gmail.com

EXPOSE 8080

COPY --from=maven_build /tmp/db/ /data/db/

CMD java -jar /data/superheroes-0.0.1-SNAPSHOT.jar

COPY --from=maven_build /tmp/target/superheroes-0.0.1-SNAPSHOT.jar /data/superheroes-0.0.1-SNAPSHOT.jar
