package group.bootcamp.technicaltest.common;

import group.bootcamp.technicaltest.entity.ProductEntity;
import group.bootcamp.technicaltest.entity.SongEntity;
import group.bootcamp.technicaltest.repository.ProductRepository;
import group.bootcamp.technicaltest.repository.SongRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyDataLoader {

    @Autowired
    SongRepository songRepository;

    @Autowired
    ProductRepository productRepository;
    @PostConstruct()
    void loadData(){
        loadDataSong();
        loadProducts();
    }


    void loadDataSong(){
        List<SongEntity> songs = List.of(
                SongEntity.builder().songTitle("Stay").genre("Pop").artist("The Kid LAROI & Justin Bieber").build(),
                SongEntity.builder().songTitle("Bad Habits").genre("Pop").artist("Ed Sheeran").build(),
                SongEntity.builder().songTitle("Montero (Call Me By Your Name)").genre("Pop").artist("Lil Nas X").build(),
                SongEntity.builder().songTitle("Butter").genre("Pop").artist("BTS").build(),
                SongEntity.builder().songTitle("Levitating").genre("Pop").artist("Dua Lipa").build()
        );
        songRepository.saveAll(songs);
    }

    void loadProducts(){
        productRepository.deleteAll();
        List<ProductEntity> products = List.of(
                ProductEntity.builder()
                        .name("iPhone 12 Pro")
                        .brand("Apple")
                        .category("Smartphone")
                        .price(12990000)
                        .description("iPhone 12 Pro adalah salah satu produk terbaru dari Apple. Dengan fitur kamera canggih dan desain yang elegan, iPhone 12 Pro menjadi pilihan yang populer di kalangan pengguna iPhone.")
                        .imageFileName("https://picsum.photos/200/300")
                        .build(),
                ProductEntity.builder()
                        .name("Samsung Galaxy S21 Ultra")
                        .brand("Samsung")
                        .category("Smartphone")
                        .price(16999000)
                        .description("Samsung Galaxy S21 Ultra adalah flagship terbaru dari Samsung dengan kamera 108 MP dan dukungan S Pen. Dengan spesifikasi yang canggih, Galaxy S21 Ultra menawarkan pengalaman yang luar biasa kepada penggunanya.")
                        .imageFileName("https://picsum.photos/200/300")
                        .build(),
                ProductEntity.builder()
                        .name("MacBook Pro 13-inch")
                        .brand("Apple")
                        .category("Laptop")
                        .price(25999000)
                        .description("MacBook Pro 13-inch adalah laptop kelas atas dari Apple dengan prosesor M1 yang powerful. Dengan desain yang ramping dan performa yang cepat, MacBook Pro 13-inch cocok digunakan untuk produktivitas dan kreasi.")
                        .imageFileName("https://picsum.photos/200/300")
                        .build()
        );
        productRepository.saveAll(products);

    }
}
