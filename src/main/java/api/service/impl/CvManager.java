package api.service.impl;

import java.util.List;
import java.util.Objects;

import api.entities.Cv;
import api.service.inter.ICvService;
import api.repository.CvRepository;
import api.utilities.image.adapters.abstracts.CloudinaryUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import api.utilities.result.DataResult;
import api.utilities.result.ErorDataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;

@Service
public class CvManager implements ICvService {

    private final CvRepository cvRepository;
    private final CloudinaryUploadService cloudinaryUploadService;

    @Autowired
    public CvManager(CvRepository cvDao, CloudinaryUploadService cloudinaryUploadService) {
        super();
        this.cvRepository = cvDao;
        this.cloudinaryUploadService = cloudinaryUploadService;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(
                this.cvRepository.findAll()
        );
    }

    @Override
    public DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<Cv>>(
                this.cvRepository.findByJobSeekerId(jobSeekerId)
        );
    }

    @Override
    public DataResult<String> uploadImage(int id, MultipartFile file) {
        if (!Objects.requireNonNull(file.getContentType()).startsWith("image")) {
            return new ErorDataResult<String>(
                    "Failed to load photo! The file is not an image.", file.getContentType()
            );
        } else if (!this.cvRepository.existsById(id)) {
            return new ErorDataResult<String>(
                    "Failed to load photo! Not found curriculum vitae.", null
            );
        } else {
            String secure_url = this.cloudinaryUploadService.upload(file).get("secure_url").toString();
            Cv cv = this.cvRepository.findById(id).get();
            cv.setImageLink(secure_url);
            this.cvRepository.save(cv);
            return new SuccessDataResult<String>(
                    "Photo uploaded ! ", secure_url
            );
        }
    }

    @Override
    public Result add(Cv cv) {
        this.cvRepository.save(cv);
        return new SuccessResult("Cv added");
    }

    @Override
    public Result update(Cv cv) {
        this.cvRepository.save(cv);
        return new SuccessResult("Cv updated");
    }

    @Override
    public Result delete(Cv cv) {
        this.cvRepository.delete(cv);
        return new SuccessResult("Cv deleted");
    }
}
