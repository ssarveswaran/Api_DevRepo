package com.example.demo.Service;


import com.example.demo.Mode.Users1;
import com.example.demo.Repo.Repo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.*;
@Component
public class Service {
    private Repo repo;
    private ObjectMapper mapper=new ObjectMapper();
    @PostConstruct
    public void initialize() throws IOException {
       byte[] byt=Files.readAllBytes(Paths.get("C:\\Users\\OGS\\Downloads\\demo (6)\\demo\\Config\\User.json"));
       String json=new String(byt);
       System.out.println(json);
       JsonNode root=mapper.readTree(json);
       JsonNode rootValues=root.get("Users");
       System.out.println(root);
       System.out.println(rootValues);

    }

    @Autowired
    public Service(Repo repo){
        this.repo=repo;
    }

    public List<Users1> get() {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Users1::getId))  // Sort by id in ascending order
                .collect(Collectors.toList());
    }


    public Users1 delete(int id) {
        Users1 user = repo.findById(id).orElse(new Users1());
        repo.delete(user);
        return user;

    }

    public Users1 update(Users1 user) {
        return repo.save(user);
    }

    public Users1 add(Users1 user) {
        return repo.save(user);
    }
}
