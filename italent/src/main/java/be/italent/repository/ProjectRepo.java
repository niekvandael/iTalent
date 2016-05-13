/*
    @Query("select p from Project p" +
            " where p.description = :description")
    List<Project> findAllByDescription(@Param("description") final String description);
    
     Hier definieren we de querie in een annotatie gebaseerd op de namen die velden in het object krijgen (belangijk!!).
     Wat in een database bv has_likes zou heten, maar in de klasse als hasLike omschreven staat moet ook als hasLikes aangeroepen worden.
     We geven de de descriptie mee en moeten deze als parameter definieren met de annotatie @Param. Deze kan dan in de de querie gebruikt worden
     met dubbele punt en gegeven parameternaam (:description). Ongebruikte parameters geven fouten, dus enkel toevoegen wat gebruikt wordt.

     http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html

     Simpele custom queries als deze kunnen met JPA gegenereerd worden, hier bestaat een hoop documentatie over, oa bovenstaande link,
     maar bovenstaande methode had makkelijk ook als volgt gedefinieerd kunnen worden:

     List<Project> findAllByDescription(String description);

     Enkel dit, zonder annotatie erboven.

     Bijgevolg is dit enkel ter illustratie.

     Ingewikkeldere queries met uitgebreidere where's moeten wel op deze manier toegevoegd worden.
    */

package be.italent.repository;

import be.italent.model.Project;
import be.italent.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    List<Project> findAllByIsPublic(boolean isPublic);
    
    List<Project> findAllByIsBacked(boolean isBacked);
    
    //TODO testing workaround multiplication problem
    List<Project> findAllById(int id);
    
    @Query("select p from Project p where p.user = :user")
    List<Project> findUserProjects(@Param("user") final User user);
    // of: List<Project> findAllByUser(User user);
    
    @Query("select p from Project p join p.likes l where l.user = :user")
    List<Project> findMyLikedProjects(@Param("user") final User user);
    
    @Query("select p from Project p join p.subscribersStudent s where s.user = :user")
    List<Project> findMySubscribedProjects(@Param("user") final User user);
    
    @Query("select p from Project p join p.subscribersDocent s where s.user = :user")
    List<Project> findMyBackedProjects(@Param("user") final User user);
}
