package comgetit.publishing;

import comgetit.workarea.WorkArea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingRepository extends JpaRepository<Publishing, Long> {

    List<Publishing> findAllByWorkArea(WorkArea workArea);
}
