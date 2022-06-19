package purpledog.purpledog.TestPackage.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "UK_ID", columnList = "id", unique = true)
})
public class MemberTest2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String userId;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String phone;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String address;

    public MemberTest2(String userId, String password, String phone, String address) {
        this.userId = userId;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
