package com.online.bookstore.demo.repository;

import com.online.bookstore.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book,Integer> {
}
