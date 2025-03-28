package assgiment.ass.Model; // Đặt đúng tên package, tránh lỗi chính tả

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "nvarchar(max)")
    private String username;

    @Column(columnDefinition = "nvarchar(max)")
    private String email;

    @Column(columnDefinition = "nvarchar(max)")
    private String password;

    @Column(columnDefinition = "nvarchar(max)")
    private String role;
    
}