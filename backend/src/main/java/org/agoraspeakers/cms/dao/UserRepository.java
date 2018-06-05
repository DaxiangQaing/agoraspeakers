package org.agoraspeakers.cms.dao;

import org.agoraspeakers.cms.domain.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface UserRepository extends CrudRepository<AppUser,Integer> , UserReporsitoryCustom{
    @Query("select c from AppUser c where c.email = :email")
    Stream<AppUser> findByEmailReturnStream(@Param("email") String email);

    @Query("select c from AppUser c where c.username = :username")
    Stream<AppUser> findByUsernameReturnStream(@Param("username") String username);
}
