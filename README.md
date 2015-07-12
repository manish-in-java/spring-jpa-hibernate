# Overview
 
[![Build status](https://drone.io/github.com/manish-in-java/spring-jpa-hibernate/status.png)](https://drone.io/github.com/manish-in-java/spring-jpa-hibernate/latest)
[![Code coverage status](https://coveralls.io/repos/manish-in-java/spring-jpa-hibernate/badge.svg?branch=master)](https://coveralls.io/r/manish-in-java/spring-jpa-hibernate?branch=master)
[![Custom License](http://b.repl.ca/v1/License-CUSTOM-red.png)](#LICENSE)
[![CLI interface](http://b.repl.ca/v1/command-line-blue.png)](#CLI)

Sample application that demonstrates the use of Hibernate as a JPA provider with
Spring Data JPA.

The following concepts are currently demonstrated:

Concept | Description | See
------- | ----------- | ---
**Spring Data JPA repositories** | Perform [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) operations agains a relational database using the [Repository pattern](http://martinfowler.com/eaaCatalog/repository.html) | [`LibraryRepository.java`](src/main/java/org/example/data/library/LibraryRepository.java)
**Direct `EntityManager` access** | Accessing the JPA `EntityManager` directly for fine-grained control over database interactions | [`QuizPersistenceTest.java`](src/test/java/com/sample/data/quiz/QuizPersistenceTest.java)
**Collection size** | Find size of a mapped collection without having to load all elements in the collection | [`QuizPersistenceTest.java`](src/test/java/com/sample/data/quiz/QuizPersistenceTest.java)
**Multiple `EntityManager`s** | Use multiple `EntityManager`s in a single application | [`springContext.xml`](src/main/resources/springContext.xml)
**Manual identifier generation** | Generate entity identifiers manually | [`Invoice.java`](src/main/java/org/example/domain/billing/Invoice.java) and [`InvoiceRepositoryTest.java`](src/test/java/org/example/data/billing/InvoiceRepositoryTest.java)
**JTA transactions** | Support JTA transactions across multiple data stores using Bitronix | [`springContext.xml`](src/main/resources/springContext.xml)
**`@OneToOne` with foreign keys** | `@OneToOne` association between two entity classes using a foreign key column | [`Employee.java`](src/main/java/org/example/domain/profile/Employee.java)
**JPA `count` query on `abstract` class** | Executing a `count` query on an `abstract` class | [`WorkdayRepositoryTest.java`](src/test/java/org/example/data/profile/WorkdayRepositoryTest.java)
**Custom JPA functionality** | Extending Spring Data `JpaRepository` to provide custom functionality for all repositories | [`ExtendedJpaRepository.java`](src/main/java/org/example/data/ExtendedJpaRepository.java)
**AspectJ integration** | Intercepting Spring Data repository method calls using AspectJ | [`RepositoryInterceptionAdvice.java`](src/main/java/org/example/aop/RepositoryInterceptionAdvice.java)
**SQL Injection protection** | Use type-safe, parameterized queries to prevent [SQL Injection attacks](https://en.wikipedia.org/wiki/SQL_injection) | [`StockRepositoryTest.java`](https://github.com/manish-in-java/spring-jpa-hibernate/blob/master/src/test/java/org/example/data/inventory/StockRepositoryTest.java)
**Native SQL queries** | Use native SQL queries in cases where either JPQL is inadequate or native SQL is simply easier to write | [`JobRepository.java`](https://github.com/manish-in-java/spring-jpa-hibernate/blob/master/src/main/java/org/example/data/hiring/JobRepository.java)
**Spring Data JPA with Scala** | Use Spring Data JPA with Scala classes and traits | [`SubjectRepository.scala`](src/main/scala/org/example/data/education/SubjectRepository.scala)
**`Single Table` inheritance** | Single-table inheritance for storing related objects | [`Card.java`](src/main/java/org/example/domain/game/Card.java)
**Polymorphism with generics** | Demonstrate inheritance-based polymorphism along with generics | [`CardInstance.java`](src/main/java/org/example/domain/game/CardInstance.java)

# License
This sample application and its associated source code in its entirety is being made
available under the following licensing terms.

    Copyright (C) 2015

    Permission is hereby granted, free of charge, to any person obtaining a copy of
    this software and associated documentation files (the "Software"), to deal in the
    Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
    and to permit persons to whom the Software is furnished to do so, subject to the
    following conditions:

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
    PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
    HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
    CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
    OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
