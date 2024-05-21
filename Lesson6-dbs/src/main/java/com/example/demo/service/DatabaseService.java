package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.model.BookSpecification;
import com.example.demo.model.TestDTO;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final BookRepository bookRepository;
    private final Integer MAX_COUNT = 20;
    public Page<Book> getAllBooks(TestDTO body) {
        Pageable pageable = PageRequest.of(body.getPage(),MAX_COUNT);
        return bookRepository.findAll(new BookSpecification(body), pageable);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

}
