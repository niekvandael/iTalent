package be.italent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.italent.model.SubscriberDocent;

@Repository
public interface SubscriberDocentRepo extends JpaRepository<SubscriberDocent, Integer> {
}
