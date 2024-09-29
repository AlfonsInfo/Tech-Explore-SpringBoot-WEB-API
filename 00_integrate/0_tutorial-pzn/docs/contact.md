# Contact API Spec

## Create Contact
Endpoint :

Request Header :
- X-API-TOKEN : Token(Mandatory)

Request Body :

```json
{
  "firstName" : "Alfons Setiawan",
  "lastName" : "Jacub",
  "email" : "alfons@example.com",
  "phone" : "082172804015"
}
```

Response Body (Success) :
```json
{
  "data" : {
    "id" : "random-string",
    "firstName" : "Alfons Setiawan",
    "lastName" : "Jacub",
    "email" : "alfons@example.com",
    "phone" : "082172804015"
  }
}
```

Response Body (Failed) :
```json
{
  "errros" : "Email format invalid, phone format invalid,..."
}
```

## Update Contact
Endpoint : PUT api/contacts/{id}

Request Header :
- X-API-TOKEN : Token(Mandatory)

Request Body :

```json
{
  "firstName" : "Alfons Setiawan",
  "lastName" : "Jacub",
  "email" : "alfons@example.com",
  "phone" : "082172804015"
}
```

Response Body (Success) : 


````json
{
  "data" : {
    "id" : "random-string",
    "firstName" : "Alfons Setiawan",
    "lastName" : "Jacub",
    "email" : "alfons@example.com",
    "phone" : "082172804015"
  }
}
````



Response Body (Failed) :

```json
{
  "errros" : "Email format invalid, phone format invalid,..."
}
```

## Get Contact
Endpoint : GET /api/contact/{idContact}

Request Header :
- X-API-TOKEN : Token(Mandatory)


Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "firstName" : "Alfons Setiawan",
    "lastName" : "Jacub",
    "email" : "alfons@example.com",
    "phone" : "082172804015"
  }
}
```

Response Body (Failed, 404) :
```json
{
  "errros" : "Contact is not found"
}
```

## Search Contact
Endpoint : GET /api/contacts/

Query Param / Request Param :
- name : String, contact first name or last name, using like query, optional
- phone : String, contact phone, using like query, optional
- email : String, contact email, using like query, optional

Request Header :
- X-API-TOKEN : Token(Mandatory)

Response Body (Success) :
```json
{
  "data" : [
    {
      "id" : "random-string",
      "firstName" : "Alfons Setiawan",
      "lastName" : "Jacub",
      "email" : "alfons@example.com",
      "phone" : "082172804015"
    }
  ],
  "paging" : {
    "totalPage" : 10,
    "size" : 10
  }
}
```

Response Body (Failed) :

## Remove Contact

Endpoint : DELETE /apii/contacts/{idContact}
Request Header :
- X-API-TOKEN : Token(Mandatory)


Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :
```json
{
  "errors" : "Contact is not found"  
}


```
