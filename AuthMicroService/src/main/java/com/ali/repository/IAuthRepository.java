package com.ali.repository;

import com.ali.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {
    /**
     * Bu Kullanıcı adı daha önce kullanılmış mı?
     * @param username
     * @return
     */
    @Query(value = "select COUNT(a)>0 from Auth a where a.username=?1")
    boolean isUsername(String username);

    /**
     * Kullanıcı adı ve şifresi verilen kaydın olup olmadığı kontrol ediliyor.
     * @param username
     * @param password
     * @return
     */
    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);
}
