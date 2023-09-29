# Filter
- Filter adalah fitur yang terdapat di Srvlet digunakan sebagai component yang bisa ditempatkan didepan sebelum object servlet diakss
- Mirip dengan middleware
- Kita bisa membuat filter mirip seperti servlet , dimana kita bisa registrasi ke url patterns tertentu
- Nanti secara otomatis setiap kita mengakses URLnya, filter akan dijalankan dan kita bisa mnenetukan apakah Request akan dilanjutkan ke servlet atau tidak.
- Filter juga bisa berapis, artinya kita bisa membuat ebih dari satu filter untuk url patterns yang sama.

# doFilter

- Params :
  - ServletRequest
  - ServletResponse
  - FilterChain -> Objek yang dieksekusi


- Filter direpresentasi oleh bernama Filter
- Salam seperti Servlet, Filter juga punya implementasi class yang bisa digunakan
  - HttpFilter
- Kita harus menambahkan annotasi WebFilter pada classnya