package app.urlto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.urlto.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
