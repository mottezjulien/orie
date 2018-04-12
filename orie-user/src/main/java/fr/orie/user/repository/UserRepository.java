package fr.orie.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {

    @Query(value = "select user from UserEntity user")
    Stream<UserEntity> streamFindAll();

}
