package mylab.user.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private String dbType = "MySQL";  // ✅ 과제 요구

    public String getDbType() { return dbType; }

    public void save(String userId) {
        // 저장 로직은 과제에서 구체 구현 불필요
    }
}