package api.repository;

import api.entities.VerifiedCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifiedCodeRepository extends JpaRepository<VerifiedCode, Integer> {
    VerifiedCode findByUserIdAndVerificationCode(int userId, String verificationCode);
}
