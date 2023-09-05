package com.online.bookstore.demo.repository;

import com.online.bookstore.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,String> {

    //private findByUserName()
}
