# enem-api-java
Java API with methods to search high schools ranked according to ENEM - a Brazilian national secondary exam. The api accesses the Mongo database created by [enem-db](https://github.com/pmelin/enem-db).

## Tech Stack

- Spring Boot
- Spring Data MongoDB
- Spring MVC
- Java 8
- MongoDB
- JUnit
- Mockito

## Routes

- GET /school/code/{code}

Retrieves the details of a school by it's code. Ex: `school/code/11027290`

```javascript
{
  "code": 11027290,
  "name": "EEBP ANTONIO SANCHEZ DE LARRAGOITI Y CURDUMI",
  "uf": "RO",
  "municipality": "CACOAL",
  "adminDependency": "Privada",
  "participationRate": 96.15,
  "permanenceRate": "80% ou mais",
  "teacherTraining": 46.2,
  "approvalRate": 95.2,
  "disapprovalRate": 4.8,
  "abandonmentRate": 0,
  "average": 522.946
}
```


