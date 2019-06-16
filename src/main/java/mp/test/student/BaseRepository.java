package mp.test.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository {
    public Page findAll(Specification specification, Pageable pageable);
}
