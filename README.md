# Техническое задание
REST API бэкенд для сохранения в БД Новостей и их Типов.

Возможность получить список всех новостей (имя, краткое описание, тип
новости – имя типа, цвет типа).
```
/api/story/response
```
Возможность получить список новостей определенного типа.
```
/api/type/response/{id} 
```
Возможность получить список всех типов новостей.
```
/api/type/active
```
## Tools

The following tools have been used:
+ **Programming languages**: Java, SQL
+ **Technologies and Frameworks**: Spring Core, Spring Data JPA, Hibernate, Spring Boot, Docker, Docker Compose
+ **Application / Web Servers**: Tomcat
+ **Databases**: Postgresql
+ **IDE**: Intellij Idea
+ **Version control system**: git

For tracing was used *Spring Cloud Sleuth, Zalando*

## Start

### With docker and MakeFile
```Bash
make start
```
### With docker without MakeFile
```Bash
mvnw clean package
```

```Bash
docker-compose up -d
```
The project is running and available at localhost:8080

### Swagger
[swagger](https://petstore.swagger.io/?url=https://raw.githubusercontent.com/LyutovaAnastasia/specification/master/swagger.yaml)


Swagger is available at *http://localhost:8080/*
