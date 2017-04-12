FROM java:8
EXPOSE 8080
ADD target/blog-1.0-SNAPSHOT.jar blog.jar
CMD java -jar blog.jar