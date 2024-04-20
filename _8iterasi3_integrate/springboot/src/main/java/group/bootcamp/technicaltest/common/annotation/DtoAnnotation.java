//package group.bootcamp.technicaltest.annotation;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.lang.annotation.*;
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Documented
//public @interface DtoAnnotation {
//}
//https://groups.google.com/g/project-lombok/c/CnvM6MbRSw8

//
//Penjelasan tersebut menjelaskan tantangan yang dihadapi dalam mengimplementasikan fitur yang diminta, yaitu kemampuan untuk membuat anotasi baru yang mampu menggabungkan fungsi dari anotasi @Getter dan sejenisnya (seperti yang dimiliki oleh proyek Lombok).
//
//        Pertama-tama, penjelasan tersebut menyatakan bahwa pembuatan fitur ini memang sering diminta oleh pengguna, dan tidak ada penolakan terhadap ide tersebut. Namun, implementasinya sangat sulit karena alasan-alasan teknis yang dijelaskan berikutnya.
//
//        Pada dasarnya, anotasi seperti @Getter dan sejenisnya di Lombok dieksekusi sebelum kompiler Java menghasilkan daftar metode dalam kelas. Hal ini karena jika kompiler sudah membuat daftar metode tersebut, anotasi seperti @Getter tidak akan dibutuhkan lagi. Namun, pada saat anotasi dieksekusi, compiler belum memiliki informasi tentang apa yang dimaksud dengan anotasi baru seperti @POJO. Ini membuat implementasi fitur baru menjadi rumit karena tidak ada cara untuk menentukan cara kerja anotasi baru tersebut pada tahap awal kompilasi.
//
//        Ada dua opsi yang bisa dipertimbangkan:
//
//        Mencoba untuk menyelaraskan metode yang dihasilkan oleh anotasi dengan struktur data yang digunakan oleh kompiler untuk melacak nama metode dan informasi lainnya. Namun, hal ini sangat sulit dilakukan, terutama dengan struktur data yang bersifat imutabel dalam kompiler Java.
//
//        Meminta kompiler untuk membatalkan pekerjaan yang sudah dilakukan dan memulai ulang proses kompilasi dari awal. Ini memang bisa dilakukan, tetapi akan membuat proses kompilasi menjadi lebih lambat, karena kompiler harus memulai dari awal. Ini bisa mengakibatkan peningkatan waktu kompilasi yang signifikan.
//
//        Kesulitan-kesulitan ini ditambah dengan kenyataan bahwa fitur ini sendiri sudah kompleks secara alami, menjelaskan mengapa fitur ini belum diimplementasikan sampai sekarang.
//
//        Jadi, penjelasan tersebut menyatakan bahwa meskipun fitur ini sering diminta, implementasinya sangat rumit dan sulit untuk dilakukan, dan ada banyak faktor teknis yang perlu dipertimbangkan.