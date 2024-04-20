# Pengenalan AOP
- AOP atau singkatan dari Aspect Oriented Programming
- AOP melengkapi OOP (Object Oriented Programming) dalam membuat kode program
- AOP intine Aspect
- Aspect mmeungkinkan modularity dari concerns (perhatian), yang bisa melintasi berbagai jenis tipe data dan object


# Fungsi Aspect
- Secara default, aspect tidak berguna, jika tidak menambah behavior pada Aspect tersebut
- Kita perlu menambah behavior ke Aspect dengan cara menambahkan method pada Asepct tersebut

# Joint Point
- titik lokasi eksekusi program
- Aspect J mendukung banyak joint point , Spring AOP hanya mendukung eksekusi method di bean


# PointCut Expression
- execution - eksekusi method
- within - object sesuai yang ditentukan
- this - bean reference adalah instance tipe yang ditentukan
- target - object adalah instace dari tipe yang ditentukan
- args - argument method adalah instance dari tipe yang ditentukan
- @target - object memiliki annotation yang ditentukan
- @args - arguments method memiliki annotation yang ditentukan
- @within - method di object yang memiliki annotation yang ditentukan
- @annotation - method yang memiliki annotation tertentu
- bean - object dengan nama ban sesuai ditentukan


# Advice
- aksi yang dilakukan pada join point
- terdapat banyak sekali jenis advice, misal before, after dan around.

## Jenis Advice
- Before
- AfterReturning
- AfterThrowing
- After
- Around ->parameter ProceedingJoinPoint (turunan dari jointpoint) -> ada method proceed & proceed(params)

## Pointcut Expression Format

https://eclipse.dev/aspectj/doc/released/progguide/semantics-pointcuts.html
## Multiple point cut


##Parameter
