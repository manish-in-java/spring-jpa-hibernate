# Overview [![Build status](https://drone.io/github.com/manish-in-java/spring-jpa-hibernate/status.png)](https://drone.io/github.com/manish-in-java/spring-jpa-hibernate/latest) [![Code coverage status](https://coveralls.io/repos/manish-in-java/spring-jpa-hibernate/badge.svg?branch=master)](https://coveralls.io/r/manish-in-java/spring-jpa-hibernate?branch=master)
Sample application that demonstrates the use of Hibernate as a JPA provider with
Spring Data JPA.

The following concepts are currently demonstrated:

* Perform CRUD operations against a relational database using Spring Data JPA repositories.  See [`LibraryRepository.java`](src/main/java/org/example/data/library/LibraryRepository.java).
* Find size of a mapped collection without having to load all elements in the collection.  See [`QuizPersistenceTest.java`](src/test/java/com/sample/data/quiz/QuizPersistenceTest.java).
* Two `EntityManager`s.  See [`springContext.xml`](src/main/resources/springContext.xml).
* Manual assignment of entity identifiers.  See [`Invoice.java`](src/main/java/org/example/domain/billing/Invoice.java).
* JTA transactions with Bitronix.  See [`springContext.xml`](src/main/resources/springContext.xml) for Bitronix configuration.
* Bidirectional `@OneToOne` association between two entity classes when one of the classes uses a foreign key column for the association.  See [`Employee.java`](src/main/java/org/example/domain/profile/Employee.java).
* Executing JPA `count` query on an `abstract` class.  See [`WorkdayRepositoryTest.java`](src/test/java/org/example/data/profile/WorkdayRepositoryTest.java).

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
