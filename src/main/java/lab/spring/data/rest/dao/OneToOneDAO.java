package lab.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.User;

public interface OneToOneDAO extends JpaRepository<User, Integer> {

}
