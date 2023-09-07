# Bean

- Objek yang dimasukkan kedalam Spring Container IoC = bEAN
- Bean defaultnya singleton


# Membuat Bean

- method dalam class Config
- Default nama Method == nama Bean
- Default method akan mengeksekusi method, dan return value menjadi Bean

# Mengakses Bean

- Object Bean akan dimanage oleh framework
- akses bean applicationContext.getBean(tipeData)
- Karena singleton, diakses 2 kali akan mengembalikan method yang Sama


# Primary Bean

- Jika terjadi duplicate Bean, kita bisa mendefinisikan salah satu menjadi primary
- bisa akses tanpa menyebutkan nama bean
- @primary

# Custom Nama Bean

- Memberikan @Bean(value = "namabaru")