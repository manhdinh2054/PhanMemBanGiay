package org.example.baitapbuoi3.duanban.Repository;

import org.example.baitapbuoi3.assignmentj6.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInterface extends JpaRepository<Account,Long> {
    @Query(value = "SELECT username,password,fullname,email,photo FROM accounts WHERE username = :username", nativeQuery = true)
    Account findByUser1(@Param("username") String username);
}
