package lab.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.EmergencyInfo;

public interface ManyToOneDAO extends JpaRepository<EmergencyInfo, Integer> {

}
