package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "libuser")
public class Libuser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libuser_id_gen")
    @SequenceGenerator(name = "libuser_id_gen", sequenceName = "libuser_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "libuser")
    public List<Book> book;
    @ManyToMany(mappedBy = "libusers")
    public List<Book> books;

    Авторы -- АВТОР_КНИГА(айди автора, айди книги) -- Книги
}
