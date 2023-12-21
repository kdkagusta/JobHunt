package api.utilities.image.adapters.concretes;

import api.utilities.image.adapters.abstracts.CloudinaryUploadService;
import api.utilities.image.adapters.cloudinary.CloudinaryUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryUploadManager implements CloudinaryUploadService {

    @Override
    public Map<String, Object> upload(MultipartFile file) {
        CloudinaryUpload cloudinaryUpload = new CloudinaryUpload();
        return cloudinaryUpload.upload(file);
    }

}
