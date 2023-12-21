package api.service.impl;

import api.entities.VerifiedCode;
import api.service.inter.IVerifiedCodeService;
import api.repository.VerifiedCodeRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifiedCodeManager implements IVerifiedCodeService {

    private final VerifiedCodeRepository verifiedCodeRepository;

    @Autowired
    public VerifiedCodeManager(VerifiedCodeRepository verifiedCodeRepository) {
        super();
        this.verifiedCodeRepository = verifiedCodeRepository;
    }

    @Override
    public DataResult<VerifiedCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
        return new SuccessDataResult<VerifiedCode>(
                this.verifiedCodeRepository.findByUserIdAndVerificationCode(userId, verificationCode)
        );
    }

    @Override
    public Result add(VerifiedCode verifiedCode) {
        this.verifiedCodeRepository.save(verifiedCode);
        return new SuccessResult("Code added... ");
    }

    @Override
    public Result update(VerifiedCode verifiedCode) {
        this.verifiedCodeRepository.save(verifiedCode);
        return new SuccessResult("Code updated... ");
    }

    @Override
    public Result delete(VerifiedCode verifiedCode) {
        this.verifiedCodeRepository.save(verifiedCode);
        return new SuccessResult("Code deleted... ");
    }

}
