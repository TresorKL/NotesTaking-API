package com.example.notetakingapi.repository;


import com.example.notetakingapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(
            value = "SELECT * FROM USER s WHERE s.email_address=:email AND s.password=:password",
            nativeQuery=true
    )
    User loginUser(@Param("email") String emailAddress,@Param("password") String password);
}
