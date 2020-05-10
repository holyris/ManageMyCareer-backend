package fr.univparis8.iut.csid.workplace;

import fr.univparis8.iut.csid.company.Company;
import fr.univparis8.iut.csid.company.CompanyMapper;
import fr.univparis8.iut.csid.company.CompanyRepository;
import fr.univparis8.iut.csid.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {

    private final WorkplaceRepository workplaceRepository;

    public WorkplaceService(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    public Workplace save(Workplace workplace){
        return WorkplaceMapper.toWorkplace(workplaceRepository.save(WorkplaceMapper.toWorkplaceEntity(workplace)));
    }

    public List<Workplace> getAll(){
        return WorkplaceMapper.toWorkplaceList(workplaceRepository.findAll());
    }

    public Workplace getOne(String id){
        return WorkplaceMapper.toWorkplace(workplaceRepository.getOne(id));
    }

    public Workplace update(Workplace workplace){
        if(workplace.getId() == null){
            throw new NotFoundException("Company not found with id " + workplace.getId());
        }
        if (!workplaceRepository.existsById(workplace.getId())) {
            throw new NotFoundException("Company not found with id " + workplace.getId());
        }

        Workplace currentWorkplace = WorkplaceMapper.toWorkplace(workplaceRepository.getOne(workplace.getId()));
        Workplace newWorkplace = currentWorkplace.mergeWith(workplace);

        return WorkplaceMapper.toWorkplace(workplaceRepository.save(WorkplaceMapper.toWorkplaceEntity(newWorkplace)));
    }

    public Workplace delete(String id){
        if(workplaceRepository.existsById(id)){
            Workplace workplace = WorkplaceMapper.toWorkplace(workplaceRepository.getOne(id));
            workplaceRepository.deleteById(id);
            return workplace;
        }else{
            throw new NotFoundException("Company not found with id " + id);
        }
    }
}
