FROM openjdk:8
ADD out/artifacts/demo_jar/demo.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]