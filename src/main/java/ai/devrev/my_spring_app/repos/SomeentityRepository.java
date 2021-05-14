package ai.devrev.my_spring_app.repos;

import ai.devrev.my_spring_app.domain.Someentity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SomeentityRepository extends JpaRepository<Someentity, Long> {
}
