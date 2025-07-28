package app.urlto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.urlto.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByAccount(String account);

}
