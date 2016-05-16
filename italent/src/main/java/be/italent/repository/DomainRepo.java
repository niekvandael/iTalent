package be.italent.repository;

import be.italent.model.Domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface DomainRepo extends JpaRepository<Domain, Integer> {

}
