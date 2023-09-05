package com.online.bookstore.demo.repository;

import com.online.bookstore.demo.entity.BookUser;
import com.online.bookstore.demo.entity.BookUserId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource
public interface BookUserRepository extends JpaRepository<BookUser, BookUserId> {

    @Modifying
    @Transactional
    @Query(value="select book_id from book_user where customer_id = ?1", nativeQuery = true)
    public Set<Integer> getPurchasedBooks(String customerId);

}
