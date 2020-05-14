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
    public WorkplaceDto createWorkplace(@RequestBody WorkplaceDto workplaceDto){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.save(WorkplaceMapper.toWorkplace(workplaceDto)));
    }

    @GetMapping
    public List<WorkplaceDto> getWorkplaces(){
        return WorkplaceMapper.toWorkplaceDtoList(workplaceService.getAll());
    }

    @GetMapping("/{workplaceId}")
    public WorkplaceDto getWorkplace(@PathVariable String workplaceId){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.getOne(workplaceId));
    }

    @PatchMapping
    public WorkplaceDto updateWorkplace(@RequestBody WorkplaceDto workplaceDto){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.update(WorkplaceMapper.toWorkplace(workplaceDto)));
    }

    @DeleteMapping("/{workplaceId}")
    public WorkplaceDto deleteWorkplace(@PathVariable String workplaceId){
        return WorkplaceMapper.toWorkplaceDto(workplaceService.delete(workplaceId));
    }
}
