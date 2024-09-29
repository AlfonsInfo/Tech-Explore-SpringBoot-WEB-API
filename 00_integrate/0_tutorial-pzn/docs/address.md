# Address API Spec

## Create Address
Endpoint : POST /api/contacts/{idContact}/addresses

Request Header :

X-API-TOKEN : Token(Mandatory)

Request Body :
```json
{
  "street" : "Jalan apa",
  "city" : "kota",
  "province" : "provinsi",
  "country" : "Indonesia",
  "postalCode" : "55281"
}
```

Respone Body (Success) :

```json
{
  "data": {
    "id" : "randomstring",
    "street" : "Jalan apa",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "Indonesia",
    "postalCode" : "55281"
  }
}
```

Response Body (Failed) :

```json
{
  "errors":"contact is not found" 
}
```

## Update Address
Endpoint : PUT /api/contacts/{idContact}/addresses/{idAddresses}

Request Header :

X-API-TOKEN : Token(Mandatory)

Request Body :
```json
{
  "street" : "Jalan apa",
  "city" : "kota",
  "province" : "provinsi",
  "country" : "Indonesia",
  "postalCode" : "55281"
}
```

Respone Body (Success) :

```json
{
  "data": {
    "id" : "randomstring",
    "street" : "Jalan apa",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "Indonesia",
    "postalCode" : "55281"
  }
}
```

Response Body (Failed) :

```json
{
  "errors":"Addresses is not found" 
}
```


## Get Address
Endpoint : GET /api/contacts/{idContact}/addresses/{idAddresses}

Request Header :

X-API-TOKEN : Token(Mandatory)

Respone Body (Success) :

```json
{
  "data": {
    "id" : "randomstring",
    "street" : "Jalan apa",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "Indonesia",
    "postalCode" : "55281"
  }
}
```

Response Body (Failed) :

```json
{
  "errors":"Addresses is not found" 
}
```


## Remove Address
Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddresses}

Request Header :

X-API-TOKEN : Token(Mandatory)

Respone Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors":"Addresses is not found" 
}
```

## List Address
Endpoint : GET /api/contacts/{idContact}/addresses

Request Header :

X-API-TOKEN : Token(Mandatory)


Respone Body (Success) :

```json
{
  "data": 
  [
      {
        "id" : "randomstring",
        "street" : "Jalan apa",
        "city" : "kota",
        "province" : "provinsi",
        "country" : "Indonesia",
        "postalCode" : "55281"
      }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors":"Addresses is not found" 
}
```