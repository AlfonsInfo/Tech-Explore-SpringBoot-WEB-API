# Latar Belakang
- Aplikasi kita mengirim banyak request ke aplikasi lain
- Misalnya aplikasi kita, mengirim request ke payment gateway
- Produce datanya banyak
- Problem dari ini :
  - Response Time lama kelamaan naik (kenaikan latency)

# Circuit Breaker
- Request Masuk tidak bisa dikontrol
- 100 req/s
- Thresold ->batasan response time dari thirdparty
- Saat circuit breaker terbuka, request di drop
- Sistem sedang sibuk..(Menu tidak diaktifin, transaksi ditolak dulu)
- 