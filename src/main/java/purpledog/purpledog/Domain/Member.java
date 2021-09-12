package purpledog.purpledog.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String id;
    private String password;

}
