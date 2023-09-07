# Dependency Injection

- Dependency Injection (DI) teknik mengotomasi proses pembuatan objek yang tergantung dengan objek lain
- Dependencies scara otoamtis di-inject ke dalam objek yang membutuhkannya

# Spring Dependency Injection

- Spring merupakan framework yang menerapkan Dependency Injection
- Spring akan mencari bean yang sesuai dengan tipe parameter
- Spring mencari bean yang sesuai parameter



# Memilih dependency
- Ketika saat menggunakan DI ingin memilih objek mana yang digunakan
- Secara default spring memilih primary
- @Qualifier pada parameter methodnya



# Circular Dependencies

- Kasus dimana Bean A butuh Bean B, Bean B butuh Bean C, Bean C butuh Bean A 
- Terjadi Cyclic, Spring mendeteksi ,Spring mendeteksi error.