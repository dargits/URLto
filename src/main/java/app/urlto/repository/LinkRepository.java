package app.urlto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.urlto.entity.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    boolean existsByShortCode(String shortCode);
}
