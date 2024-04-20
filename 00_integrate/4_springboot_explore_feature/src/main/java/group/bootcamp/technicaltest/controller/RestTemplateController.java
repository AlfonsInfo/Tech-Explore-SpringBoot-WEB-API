package group.bootcamp.technicaltest.controller;


import group.bootcamp.technicaltest.entity.CandidateStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/rest-template")
@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dummy-students")
    public ResponseEntity<List<CandidateStudent>> getDummyStudents(){
        List<CandidateStudent> candidateStudents = new ArrayList<>();
        candidateStudents.add(new CandidateStudent("Alfons",21,"Laki-laki","Katolik"));
        candidateStudents.add(new CandidateStudent("Bambang",21,"Laki-laki","Katolik"));
        candidateStudents.add(new CandidateStudent("Nadya",21,"Perempuan","Katolik"));
        return ResponseEntity.ok(candidateStudents);
    }

    @GetMapping("/cat-facts")
    public ResponseEntity<String> getCatFacts(){
        String catFactsEndpoint = "https://cat-fact.herokuapp.com/facts";
        RequestEntity<String> reqEntity = new RequestEntity<>(HttpMethod.GET, URI.create(catFactsEndpoint));
        return restTemplate.exchange(catFactsEndpoint, HttpMethod.GET,reqEntity,String.class);
    }

    @GetMapping("/candidate-students")
    public ResponseEntity<String> getCandidateStudents(){
        String dummyStudentsEndpoint = "http://localhost:8095/api/rest-template/dummy-students";
        RequestEntity<String> reqEntity = new RequestEntity<>(HttpMethod.GET, URI.create(dummyStudentsEndpoint));
        return restTemplate.exchange(dummyStudentsEndpoint, HttpMethod.GET,reqEntity,String.class);
    }
    @PostMapping("/hit-graphql")
    public ResponseEntity<String> getDataFromGraphQL() {
        String graphqlEndpoint = "http://localhost:8095/graphql";

        String query = "{ \"query\": \"query bookDetails { \\n  bookById(id: \\\"book-3\\\") { \\n    id \\n    name \\n    pageCount \\n    author { \\n      firstName \\n      lastName \\n    } \\n  } \\n}\" }";



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = restTemplate.postForEntity(graphqlEndpoint, new HttpEntity<>(query, headers), String.class);
        return response;
    }

}
