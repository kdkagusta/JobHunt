package api.service.inter;

import api.entities.VerifiedCode;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface IVerifiedCodeService {
    DataResult<VerifiedCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
    Result add(VerifiedCode verifiedCode);
    Result update(VerifiedCode verifiedCode);
    Result delete(VerifiedCode verifiedCode);
}