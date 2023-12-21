package api.service.inter;

import java.util.List;

import api.entities.Cv;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import org.springframework.web.multipart.MultipartFile;

public interface ICvService {
    DataResult<List<Cv>> getAll();
    DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId);
    DataResult<String> uploadImage(int id, MultipartFile file);
    Result add(Cv cv);
    Result update(Cv cv);
    Result delete(Cv cv);
}
