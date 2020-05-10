package fr.univparis8.iut.csid.company;

import fr.univparis8.iut.csid.file.File;
import fr.univparis8.iut.csid.file.FileEntity;
import fr.univparis8.iut.csid.file.FileMapper;
import fr.univparis8.iut.csid.file.FileResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyMapper {

    public static Company toCompany(CompanyDto companyDto){
        return Company.CompanyBuilder.create()
                .withId(companyDto.getId())
                .withName(companyDto.getName())
                .withDescription(companyDto.getDescription())
                .build();
    }

    public static CompanyEntity toCompanyEntity(Company company){
        return CompanyEntity.CompanyEntityBuilder.create()
                .withId(company.getId())
                .withName(company.getName())
                .withDescription(company.getDescription())
                .build();
    }

    public static Company toCompany(CompanyEntity companyEntity){
        return Company.CompanyBuilder.create()
                .withId(companyEntity.getId())
                .withName(companyEntity.getName())
                .withDescription(companyEntity.getDescription())
                .build();
    }

    public static CompanyDto toCompanyDto(Company company){
        return CompanyDto.CompanyDtoBuilder.create()
                .withId(company.getId())
                .withName(company.getName())
                .withDescription(company.getDescription())
                .build();
    }

    public static List<Company> toCompanyList(List<CompanyEntity> companyEntities) {
        return companyEntities.stream()
                .map(CompanyMapper::toCompany)
                .collect(Collectors.toList());
    }

    public static List<CompanyDto> toCompanyDtoList(List<Company> companies) {
        return companies.stream()
                .map(CompanyMapper::toCompanyDto)
                .collect(Collectors.toList());
    }
}
