# Import
- Pada suatu aplikasi jarang hanya terdiri dari 1 konfigurasi
- Kita bisa melakukan import konfigurasi class



# Component Scan
- Import Bisa memecah Config Class menjadi Banyak Class
- Spring memiliki ComponentScan, otomatis import Configuratiion di sebuah package dan sub package secara otomatis

# Component
- Cara otomatis tanpa membuat Bean
- Kelas yang ditandai dengan @Component, otomatis membuat dari class tersebut
- @Component hanya mendukung pembuatan 1 bean, jadi jika kita membuat beberapa bean, tetap gunakan Bean Method

# Component Bean Name
- Default camelCase(NamaClass)
- Custom @ComponentScan()