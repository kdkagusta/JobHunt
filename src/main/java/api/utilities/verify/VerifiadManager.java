package api.utilities.verify;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerifiadManager implements IVerifiadService {

    @Override
    public void sendVerificationCode(String email) {

        UUID uuid = UUID.randomUUID();
        String verificatitionLink = "https://hrmsverifiademail/" + uuid.toString();
    }

    @Override
    public String codeGenerator() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
