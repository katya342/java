package com.example.demo.controller;

import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @DeleteMapping("/")
    // Параметры --- Очень мало параметров поиска(1 или 2 параметра), параметр не повлияет на безопасность проекта --- @RequestParam
    // Тело запроса --- @RequestBody TestDTO body;
    // Заголовки --- Системные штуки(Токены, настройки и.т.д.)

    public ResponseEntity<?> deleteEntityById(@RequestHeader("token") Integer id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Удален");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

DELETE 127.0.0.1:8080/v1/?id=1&name=Gal
