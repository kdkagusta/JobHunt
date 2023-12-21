package api.service.impl;

import java.util.List;

import api.entities.Link;
import api.service.inter.ILinkService;
import api.repository.LinkRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkManager implements ILinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkManager(LinkRepository linkRepository) {
        super();
        this.linkRepository = linkRepository;
    }

    @Override
    public DataResult<List<Link>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Link>>(
                this.linkRepository.findAllByCv_Id(jobSeekerId));
    }

    @Override
    public Result add(Link link) {
        this.linkRepository.save(link);
        return new SuccessResult("Link added... ");
    }

    @Override
    public Result update(Link link) {
        this.linkRepository.save(link);
        return new SuccessResult("Link updated... ");
    }

    @Override
    public Result delete(Link link) {
        this.linkRepository.delete(link);
        return new SuccessResult("Link deleted... ");
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(
                this.linkRepository.findAll()
        );
    }
}
