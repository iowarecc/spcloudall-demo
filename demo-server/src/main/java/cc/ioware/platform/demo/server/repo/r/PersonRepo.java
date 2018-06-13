package cc.ioware.platform.demo.server.repo.r;

import cc.ioware.platform.demo.server.repo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {

}
