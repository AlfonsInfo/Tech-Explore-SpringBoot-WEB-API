# JWT

JWT merupakan singkatan dari JSON Web Token adalah standar terbuka yang digunakan untuk merepresentasikan klaim/informasi dalam bentuk token yang dapat ditransfer antara dua belah pihak.


## Bagian JWT
1. Header
2. Payload
3. Signature

### Header
1. Bagian yang mengandung informasi tetang tipe token dan algoritma yang digunakan untuk menghasilkan tanda tangan(signature)
2. Algoritma yang digunakan bisa bervariasi (HMAC SHA256 / RSA)

### Payload
1. Bagian payload jwt berisi klaim yang merupakan informasi yang ingin disimpan dalam token.
2. Klaim dapat berupa informasi tentang pengguna atau informasi tambahan yang diperlukan oleh aplikasi.

### Signature
1. Untuk memastikan bahwa token tidak dimanipulasi selama perjalanan.
2. JWT ditandatangani menggunakan algoritma yang ditentukan dalam header. 
3. Signature dibuat dengan menggabungkan header, payload dan kunci rahasia (secret key)
4. Secret key hanya diketahui oleh server

## Keuntungan JWT
1. Ringkas dan mudah dibaca
2. Dibebaskan dari status (stateless)
3. Terdesentralisasi