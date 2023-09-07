# Depends On
- Default saat Bean A membutuhkan bean lain, secara otomatis Bean A dibuat setelah Bean lain tersebut dibuat
- Bagaimana jika kita ingin suatu Bean dibuat setelah Bean lain walaupun dia tidak membutuhkan Bean lain
- Gunakan Depends On


# Lazy Bean
- Default, bean di Spring dibuat pertama kali berjalan
- Spring pertama kali berjalan akan lambat
- Kita bisa membuat sebuah bean lazy
- Menggunakan anotasi @Lazy


# Scope
- Scope = Strategy cara sebuah object dibuat
- Default = Strategy Object di Spring = Singleton
- Kita bisa mengubah strategi ini
- @Scope (value = "namaScope")
- Bean Scope : Singleton , Prototype, Request, Session, Application, WebSocket
- Kita bisa mebmuat scope sendiri
- Dengan membmuat kelas yang implement interface Scope



# Life Cycle

- Spring Container memiliki alur hidup, jika kita ingin berinteraksi dengan alur hidup
- Bean tidak bisa tahu alur hidup Spring,
- Jika ingin berinteraksi dengan alur hidup Spring, kita bisa implements interface InitializingBean dan DisposableBean
- InitMethod 
- (InitializingBean dan DisposableBean)

# Life Cycle Annotation
- Cocok digunakan ketika ingin mengubah bean tapi tidak punya kontrol ke kelasnya
- Annotation @Bean(initMethod = "" DestroyMethod = "")
- 
# PostContruct dan PreDestroy

- Alternatif dari @Bean untuk menandai sebuah init method & dsestroy method
- @PostConstruct merupakan method yang dipanggil ketika bean selesai dibuat
- @PreDestroy merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan

# InitMethod & DestroyMethod vs PostConstruct & PreDestroy

- InitMethod & DestroyMethod ditaruh pada Bean
- PostConstruct & PreDestroy ditaruh pada method yang otomatis dipanggil saat init & destroy method