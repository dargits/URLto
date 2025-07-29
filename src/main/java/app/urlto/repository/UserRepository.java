package app.urlto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.urlto.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccount(String account);

}
