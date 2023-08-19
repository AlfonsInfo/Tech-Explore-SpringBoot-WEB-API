[//]: # (# Markdown)

[//]: # (# Judul)

[//]: # (## Judul 2)

[//]: # (*tulisan miring*)

[//]: # (**tulisan tebal**)

[//]: # ([Tautan]&#40;https://www.contoh.com&#41;)

# User API Spec
## Login
- Endpoint : POST /api/auth

Request Body :
```json
{
  "username" : "alfons",
  "password" : "password"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 23324142142 //expired
  }
}
```

Response Body (Gagal) :

```json
{
  "errors" : "Username or Password Wrong"
}
```
## Register User

- Endpoint : POST /api/users

Request Body :
```json
{
  "username" : "alfons",
  "password" : "password",
  "name" : "Alfonsus Setiawan Jacub"
}
```

Response Body (Success) :

```json
{
  "data" : "OK"
}

```

Response Body (Gagal) :

```json
{
  "data" : "Gagal",
  "errors" : "Username must not blank, ???"
}

```

## Update User

PUT biasanya menimpa
- Endpoint : PATCH /api/users/current

Request Header :
- X-API-TOKEN(Mandatory)

Request Body(Bisa partial) :
```json
{
  "name" : "Alfons Jacub", //put if only want to update name
  "password": "new password" // put if only want to update password
}
```

  Response Body (Success) :

```json
{
  "data" : {
    "username" : "alfonsus",
    "name" : "Alfonsus Setiawan Jacub"
  }
}
```

Response Body (Gagal) :

```json
{
   "errors" : "Unauthorized"
}

```

## Get User

- Endpoint : GET /api/users/current

Request Header :
- X-API-TOKEN(Mandatory)

Response Body (Success) :

```json
{
  "data" : {
    "username" : "alfonsus",
    "name" : "Alfonsus Setiawan Jacub"
  }
}
```

Response Body (Gagal) :

```json
{
   "errors" : "Unauthorized"
}

```

## Logout User

Endpoint : Delete /api/auth/logout

Request Header :
- X-API-TOKEN(Mandatory)

Response Body(Success) :

```json
{
  "data" : "ok"
}
```