package api.service.inter;

import java.util.List;

import api.entities.JobAdvertisement;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface IJobAdvertisementService {
    DataResult<List<JobAdvertisement>> getByIsActive();
    DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate();
    DataResult<List<JobAdvertisement>> getAll();
    Result enableAdmin(int adminId);
    Result changeVerifiedByAdmin(int adminId);
    Result add(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);
    Result delete(JobAdvertisement jobAdvertisement);
}