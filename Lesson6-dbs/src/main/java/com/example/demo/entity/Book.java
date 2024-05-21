package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "book", schema = "public")
public class Book {
    //  id, title, author, publication_year, quantity
    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private Integer publicationYear;
    @Column
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Libuser libuser;
    @ManyToMany
    @JoinTable(
            name = "АВТОР_КНИГА",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "id_author")
    )
    public List<Libuser> libusers;
}