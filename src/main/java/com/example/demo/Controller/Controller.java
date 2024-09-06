package com.example.demo.Controller;


import com.example.demo.Mode.Users1;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/get")
    public List<Users1> get() {
        return service.get();
    }

    @PostMapping
    public Users1 add(@RequestBody Users1 user) {
        return service.add(user);
    }

    @PutMapping
    public Users1 update(@RequestBody Users1 user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public Users1 delete(@PathVariable("id") int id) {
       return service.delete(id);
    }
}