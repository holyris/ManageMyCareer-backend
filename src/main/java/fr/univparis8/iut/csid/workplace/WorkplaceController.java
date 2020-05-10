package fr.univparis8.iut.csid.workplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workplaces")
public class WorkplaceController {

    @Autowired
    WorkplaceService workplaceService;

    @PostMapping
    public WorkplaceDto createCompany(@RequestBody WorkplaceDto workplaceDto){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.save(WorkplaceMapper.toWorkplace(workplaceDto)));
    }

    @GetMapping
    public List<WorkplaceDto> getCompanies(){
        return WorkplaceMapper.toCompanyDtoList(workplaceService.getAll());
    }

    @GetMapping("/{workplaceId}")
    public WorkplaceDto getCompany(@PathVariable String workplaceId){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.getOne(workplaceId));
    }

    @PatchMapping
    public WorkplaceDto updateCompany(@RequestBody WorkplaceDto workplaceDto){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.update(WorkplaceMapper.toWorkplace(workplaceDto)));
    }

    @DeleteMapping("/{workplaceId}")
    public WorkplaceDto deleteCompany(@PathVariable String workplaceId){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.delete(workplaceId));
    }
}
