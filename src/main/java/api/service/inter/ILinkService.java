package api.service.inter;

import java.util.List;

import api.entities.Link;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface ILinkService {
    DataResult<List<Link>> getAllByCvId(int cvId);
    DataResult<List<Link>> getAll();
    Result add(Link link);
    Result update(Link link);
    Result delete(Link link);
}