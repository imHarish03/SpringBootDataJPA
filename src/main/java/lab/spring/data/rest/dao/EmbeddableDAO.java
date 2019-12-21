package lab.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.Company;

public interface EmbeddableDAO extends JpaRepository<Company, Integer> {

}
