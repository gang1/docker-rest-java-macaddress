FROM ubuntu:latest

MAINTAINER gd "gd@demo-docker-rest-java"

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin/

COPY CompanyLookupFromMacAddress.jar .

CMD ["java", "-jar", "CompanyLookupFromMacAddress.jar"]
