# Hibernate Overview

- What is hibernate ?
- Benefits of hibernate
- What is JPA
- Benefits of JPA
- Code Snipet
----
What is hibernate ?
- A framework for persisting / saving Java objects in a database
- www.hibernate.org/orm

Benefit of Hibernate ?

- Hibernate handles all of the low-level SQL code
- Mnimize the amount of JDB code you have to develop
- Hibernate provides the Object-to-Relational Mapping (ORM)
- The developer defines mapping between Java class and database table
---
What is JPA
- Jakarta Persistence API (JPA)... previously known as java persistence API
  - Standard API for ORM
- Only a specification
  - Defines a set of interfaces
  - Requires an implementation to be usable ( like hibernate)

##JPA Vendor Implementation
  - Hibernate (most popular)
  - Eclipselink

## What are benefits of JPA
- By having a standard, API you are not locked to vendor's implementation
- Maintain portable, flexible code by coding to JPA spec (interface)
- Can theoritically switch vendor implementation
  - for ex, switch between hibernate to other vendor

```agsl
//contoh code
entityManager.find(classtarget, id)
entityManager.createQuery("from student" , student.class)
```