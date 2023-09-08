# Factory Bean

- Saat kita menggunakan class third party, sehingga agak sulit menambahkan annotation pada kelas tersebut
- Solusinya menggunakan @Bean method
- @Component class ( sebgai wrapper / factory bean)


# Inheritance

- Saat kita mengakses bean, kita bisa langsung atau melalui parent/interface
- Hati-hati dari error duplicate


# Bean Factory
- Application Context turunand ari interface BeanFactory
- BeanFactory merupakan kontrak untuk management bean di Spring

# Bean Post Processor

- Interface yang bisa kita gunakan untuk memodifikasi proses pembuatan bean di Application Context
- Bean Post Processor mirip seperti middleware
- Bisa modifikasi hasil objek


# Ordered
- Pengurutan pembuatan bean


# Aware

# Event Listener


# Startup Failure