# Bagaimana DI menggunakan @component ?


# Constructor Based Dependency Injection

- Dependency di injeksi melalui constructor
- Secara otomatis spring mencari Bean dengan parameter sesuai

## Bagaimana jika terdapat multiple constructor
- Ditandai dengan @Autowired

# Setter Based Dependency Injection
- Kita bisa menggunakan setter
- kita perlu menambah @Autowired pada setter method
- Setter Based bisa digabung dengan Constructor Based

# Field Based Dependency Injection
- Kita bisa melakukan dependency injection langsung menggunakan field
- @Autowired pada field
- Spring tidak merekomendasikan cara ini
- FieldDataType FieldName;


# Optional Dependency
- Default, Spring tidak menemukan Bean yang dibutuhkan -> error
- Kita bisa bungkus dependency Optional<T> 
- Kita bisa menggunakan ObjectProvider<T> -> bisa acc multiple Bean


# Qualifier 
- Dengan Qualifier kita bisa memilih Bean mana secara manual akan digunakan