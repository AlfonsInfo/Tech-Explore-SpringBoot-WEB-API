Controller: Bertanggung jawab untuk menangani permintaan HTTP dari frontend atau klien. Ini termasuk mengelola input, memvalidasi data, dan memanggil metode dari layanan yang sesuai untuk memproses permintaan. Controller juga membentuk respons HTTP yang akan dikirimkan kembali ke klien.

Service: Berisi logika bisnis inti dari aplikasi. Service ini mengimplementasikan fungsi-fungsi bisnis yang diperlukan oleh aplikasi. Ini adalah tempat di mana operasi-operasi kompleks dilakukan, seperti perhitungan, transformasi data, validasi, dan logika bisnis lainnya. Service ini berkomunikasi dengan repository untuk mengakses dan memanipulasi data.

Repository: Bertanggung jawab untuk berinteraksi langsung dengan penyimpanan data, seperti database. Ini termasuk operasi pembacaan, penulisan, pembaruan, dan penghapusan data. Repository memungkinkan Anda untuk mengabstraksi detail penyimpanan data dan menyediakan metode yang nyaman untuk berinteraksi dengan data.

Entity: Merupakan representasi objek data dari database. Ini sering berkaitan dengan tabel dalam basis data relasional. Objek entitas ini menggambarkan struktur data yang disimpan di dalam database dan memberikan cara untuk berinteraksi dengan data tersebut dalam kode Anda. Biasanya, Anda akan menggunakan anotasi (seperti JPA anotasi) untuk mengaitkan entitas dengan skema database.

Model: Representasi Data Transfer Object (DTO) yang digunakan untuk berkomunikasi antara berbagai lapisan dalam aplikasi, terutama antara backend dan frontend. Model ini berisi data yang perlu ditampilkan atau dimanipulasi oleh pengguna. Pemisahan model dari entitas database memungkinkan Anda untuk mengontrol data yang dikirimkan ke frontend dengan lebih baik.

