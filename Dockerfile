FROM openjdk:16-alpine3.13
WORKDIR /app
COPY . .
RUN dos2unix mvnw
# we run the above command to remove all the error we get because od not fount mvnm
RUN ./mvnw dependency:go-offline
CMD ["./mvnw", "spring-boot:run"]