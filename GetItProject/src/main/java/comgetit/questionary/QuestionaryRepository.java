package comgetit.questionary;

import comgetit.workarea.WorkArea;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionaryRepository extends JpaRepository<Questionary, Long> {

	Optional<Questionary> findByAccessCode(String code);
}
