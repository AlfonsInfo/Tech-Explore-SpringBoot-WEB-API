package group.bootcamp.technicaltest.controller;

import group.bootcamp.technicaltest.entity.SongEntity;
import group.bootcamp.technicaltest.repository.SongRepository;
import group.bootcamp.technicaltest.specs.SongSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spec")
public class SpecificatorController{

    @Autowired
    SongRepository songRepository;

    @PostMapping("/song-has-artist")
    public List<SongEntity> getSongWithArtistNotNull(){
        return songRepository.findAll(SongSpecifications.songHasArtist());
    }

}
