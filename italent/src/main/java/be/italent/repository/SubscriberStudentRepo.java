package be.italent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.italent.model.SubscriberStudent;

@Repository
public interface SubscriberStudentRepo extends JpaRepository<SubscriberStudent, Integer> {
}
