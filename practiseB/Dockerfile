# 1. Osnovna slika: OpenJDK 17 na Alpine Linuxu (mala, ~170 MB)
FROM eclipse-temurin:21-jre-alpine
# 2. Radni direktorijum unutar kontejnera
WORKDIR /app

# 3. Kopiramo JAR fajl iz target/ foldera (koji je nastao nakon mvn package)
#    Pretpostavka: tvoj JAR se zove nešto poput "naziv-projekta-0.0.1-SNAPSHOT.jar"
#    Ako se zove drugačije, izmjeni ime ili koristi *.jar (ne preporučujem jer može pokupiti više fajlova)
COPY target/*.jar app.jar

# 4. Otvaramo port na kojem Spring Boot sluša (podrazumijevano 8080)
EXPOSE 8080

# 5. Komanda za pokretanje aplikacije
ENTRYPOINT ["java", "-jar", "app.jar"]