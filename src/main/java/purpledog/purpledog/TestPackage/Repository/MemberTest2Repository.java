package purpledog.purpledog.TestPackage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import purpledog.purpledog.TestPackage.model.MemberTest2;

@Repository
public interface MemberTest2Repository extends JpaRepository<MemberTest2, Long> {
}
