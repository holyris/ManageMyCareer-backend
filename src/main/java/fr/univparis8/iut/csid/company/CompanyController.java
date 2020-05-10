package fr.univparis8.iut.csid.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto){
        return CompanyMapper.toCompanyDto(companyService.save(CompanyMapper.toCompany(companyDto)));
    }

    @GetMapping
    public List<CompanyDto> getCompanies(){
        return CompanyMapper.toCompanyDtoList(companyService.getAll());
    }

    @GetMapping("/{companyId}")
    public CompanyDto getCompany(@PathVariable String companyId){
        return CompanyMapper.toCompanyDto(companyService.getOne(companyId));
    }

    @PatchMapping
    public CompanyDto updateCompany(@RequestBody CompanyDto companyDto){
        return CompanyMapper.toCompanyDto(companyService.update(CompanyMapper.toCompany(companyDto)));
    }

    @DeleteMapping("/{companyId}")
    public CompanyDto deleteCompany(@PathVariable String companyId){
        return CompanyMapper.toCompanyDto(companyService.delete(companyId));
    }
}
