package com.example.demo.model;

import com.example.demo.entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<Book> {
    private TestDTO body;
    public BookSpecification(TestDTO body) {
        this.body = body;
    }
    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (body.getName() != null && !body.getName().isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + body.getName() + "%"));
        }
        if (body.getAuthorName() != null && !body.getAuthorName().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("author"), body.getAuthorName()));
        }
        if (body.getYear() != null) {
            predicates.add(criteriaBuilder.equal(root.get("year"), body.getYear()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
