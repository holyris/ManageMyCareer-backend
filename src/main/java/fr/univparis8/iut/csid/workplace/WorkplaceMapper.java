package fr.univparis8.iut.csid.workplace;

import fr.univparis8.iut.csid.company.Company;
import fr.univparis8.iut.csid.company.CompanyDto;
import fr.univparis8.iut.csid.company.CompanyEntity;
import fr.univparis8.iut.csid.company.CompanyMapper;
import fr.univparis8.iut.csid.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class WorkplaceMapper {

    public static Workplace toWorkplace(WorkplaceDto workplaceDto){
        Company company = Company.CompanyBuilder.create()
                .withId(workplaceDto.getCompanyId())
                .build();

        return Workplace.WorkplaceBuilder.create()
                .withId(workplaceDto.getId())
                .withName(workplaceDto.getName())
                .withDescription(workplaceDto.getDescription())
                .withCompany(company)
                .build();
    }

    public static WorkplaceEntity toWorkplaceEntity(Workplace workplace){
        CompanyEntity companyEntity = CompanyEntity.CompanyEntityBuilder.create()
                .withId(workplace.getCompany().getId())
                .build();

        return WorkplaceEntity.WorkplaceEntityBuilder.create()
                .withId(workplace.getId())
                .withName(workplace.getName())
                .withDescription(workplace.getDescription())
                .withCompany(companyEntity)
                .build();
    }

    public static Workplace toWorkplace(WorkplaceEntity workplaceEntity){
        Company company = Company.CompanyBuilder.create()
                .withId(workplaceEntity.getCompanyEntity().getId())
                .build();

        return Workplace.WorkplaceBuilder.create()
                .withId(workplaceEntity.getId())
                .withName(workplaceEntity.getName())
                .withDescription(workplaceEntity.getDescription())
                .withCompany(company)
                .build();
    }

    public static WorkplaceDto toWorkplaceDto(Workplace workplace){
        return WorkplaceDto.WorkplaceDtoBuilder.create()
                .withId(workplace.getId())
                .withName(workplace.getName())
                .withDescription(workplace.getDescription())
                .withCompanyId(workplace.getCompany().getId())
                .build();
    }

    public static List<Workplace> toWorkplaceList(List<WorkplaceEntity> workplaceEntities) {
        return workplaceEntities.stream()
                .map(WorkplaceMapper::toWorkplace)
                .collect(Collectors.toList());
    }

    public static List<WorkplaceDto> toCompanyDtoList(List<Workplace> workplaces) {
        return workplaces.stream()
                .map(WorkplaceMapper::toWorkplaceDto)
                .collect(Collectors.toList());
    }
}
