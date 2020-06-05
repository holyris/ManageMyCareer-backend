package fr.univparis8.iut.csid.company;

import fr.univparis8.iut.csid.exception.NotFoundException;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.user.UserService;
import fr.univparis8.iut.csid.workplace.Workplace;
import fr.univparis8.iut.csid.workplace.WorkplaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final WorkplaceService workplaceService;
    private final UserService userService;

    public CompanyService(CompanyRepository companyRepository, WorkplaceService workplaceService, UserService userService) {
        this.companyRepository = companyRepository;
        this.workplaceService = workplaceService;
        this.userService = userService;
    }

    public Company save(Company company) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        CompanyEntity companyEntity = CompanyMapper.toCompanyEntity(company);
        companyEntity.setUserEntity(userEntity);
        return CompanyMapper.toCompany(companyRepository.save(companyEntity));
    }

    public List<Company> getAll() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return CompanyMapper.toCompanyList(companyRepository.findAllByUserEntity(userEntity));
    }

    public List<Workplace> getWorkplaces(String id) {
        return workplaceService.getByCompany(this.getOne(id));
    }

    public Company getOne(String id) {
        return CompanyMapper.toCompany(companyRepository.getOne(id));
    }

    public Company update(Company company) {
        if (company.getId() == null) {
            throw new NotFoundException("Company not found with id " + company.getId());
        }
        if (!companyRepository.existsById(company.getId())) {
            throw new NotFoundException("Company not found with id " + company.getId());
        }

        Company currentCompany = CompanyMapper.toCompany(companyRepository.getOne(company.getId()));
        Company newCompany = currentCompany.mergeWith(company);

        return CompanyMapper.toCompany(companyRepository.save(CompanyMapper.toCompanyEntity(newCompany)));
    }

    public Company delete(String id) {
        if (companyRepository.existsById(id)) {
            Company company = CompanyMapper.toCompany(companyRepository.getOne(id));
            companyRepository.deleteById(id);
            return company;
        } else {
            throw new NotFoundException("Company not found with id " + id);
        }
    }
}
