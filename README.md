# crud-2min-java

# https://plugins.jetbrains.com/plugin/14200-entity-spring-rest-code-generator

Getting Started
This plugin is for generating codes for entities.

With a bean defined with Entity annotation, use it the following classes such as :

Controller REST API with swagger DOC API
DAO(PagingAndSortingRepository)
DTO
Service (with page query)
Mapper mapstruct
Mockito Juint5 Unit Test

Steps:

create this Interface in the model folder
public interface AbstractEntity { E getId(); }
Implement the AbstractEntity<"entity id type"> in your Entity
Add @Override on Entity getID methode
Right click on Entity class then choose "Entity Spring Rest Code Generator"
You need to create after that the data Test generator class

Dependencies:

Spring Boot Data-jpa, Data-Rest 1.X or 2.X
springfox-swagger2 2.9.2
mapstruct 1.3.0 Final
mapstruct-processor 1.3.0 Final
