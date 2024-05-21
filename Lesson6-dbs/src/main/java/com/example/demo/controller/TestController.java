package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.model.TestDTO;
import com.example.demo.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Profile("prod")
@RequestMapping("/v1")
@RequiredArgsConstructor
public class TestController {
    private final DatabaseService databaseService;
    @Value(value = "myname")
    private String myname;
    @GetMapping("/")
    public Page<Book> hello(@RequestBody TestDTO body) {
        return databaseService.getAllBooks(body);
    }
//    @PutMapping("/hello2")
//    public String helloV2(@RequestHeader String name) {
//        return "Hello World " + myname;
//    }
//    @PostMapping("/hello3")
//    public String helloV3(@RequestParam String name) {
//        return "Hello World " + myname;
//    }
//    @DeleteMapping("/hello4")
//    public String helloV4(@RequestParam String name) {
//        return "Hello World " + myname;
//    }
}
