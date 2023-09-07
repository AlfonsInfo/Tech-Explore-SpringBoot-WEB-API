# Inversion Of Control

- IOC prinsip pembuatan perangkat lunak, kita melakukan pemindahakn kontrol objek atau program ktia sebuah kontainer dalam framework
- IOC kita menyerahkan pekerjaan ke dalam framework
- framework IOC  == Container
- Eksekusi program kita, memanajemen objek, abstraction terhadap program kita
- Saat menggunakan IOC, kita mengikuti cara kerja framework

# Application Context

- Application Context adalah interface representasi Container IoC di Spring
- Application Context adalah inti dari Spring framework
- Application Context implementasinya dapat menggunakan anotasi (yang direkomendasikan) atau xml

# Configuration

- @Configuration
- Bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Application Context