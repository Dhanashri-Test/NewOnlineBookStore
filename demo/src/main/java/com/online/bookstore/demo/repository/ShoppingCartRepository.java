package com.online.bookstore.demo.repository;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.entity.ShoppingCart;
import com.online.bookstore.demo.entity.ShoppingCartId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartId> {
    @Query(nativeQuery = true,
            value="select * from shopping_cart where customer_id= :username")
    public List<ShoppingCart> getItemsByCustomer(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "Insert into shopping_cart(customer_id,book_id,count) values(?1, ?2, ?3)", nativeQuery = true)
    public int addByIds(String customerId, Integer bookId, Integer count);

    @Transactional
    @Modifying
    @Query(value = "delete from shopping_cart where  customer_id= :username and book_id=:book_id", nativeQuery = true)
    public int removeByIds(String username,Integer book_id);



}
