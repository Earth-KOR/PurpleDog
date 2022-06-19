package purpledog.purpledog.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberTEst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    public MemberTEst(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
