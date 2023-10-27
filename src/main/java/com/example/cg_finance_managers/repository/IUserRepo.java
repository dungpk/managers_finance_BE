package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepo extends JpaRepository<User,Long> {
    Optional<User>findUsersByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.fullName = :fullName, u.address = :address, u.birthday = :birthday, u.email = :email WHERE u.userId = :id")
    void updateUserInformation(@Param("id") Long id, @Param("fullName") String fullName, @Param("address") String address, @Param("birthday") Date birthday, @Param("email") String email);


    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.userId = :id")
    void changeUserPassword(@Param("id")Long id,@Param("password") String password);
}
