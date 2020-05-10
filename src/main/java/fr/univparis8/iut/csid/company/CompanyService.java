package fr.univparis8.iut.csid.company;

import fr.univparis8.iut.csid.exception.NotFoundException;
import fr.univparis8.iut.csid.file.File;
import fr.univparis8.iut.csid.file.FileMapper;
import fr.univparis8.iut.csid.file.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company){
        return CompanyMapper.toCompany(companyRepository.save(CompanyMapper.toCompanyEntity(company)));
    }

    public List<Company> getAll(){
        return CompanyMapper.toCompanyList(companyRepository.findAll());
    }

    public Company getOne(String id){
        return CompanyMapper.toCompany(companyRepository.getOne(id));
    }

    public Company update(Company company){
        if(company.getId() == null){
            throw new NotFoundException("Company not found with id " + company.getId());
        }
        if (!companyRepository.existsById(company.getId())) {
            throw new NotFoundException("Company not found with id " + company.getId());
        }

        Company currentCompany = CompanyMapper.toCompany(companyRepository.getOne(company.getId()));
        Company newCompany = currentCompany.mergeWith(company);

        return CompanyMapper.toCompany(companyRepository.save(CompanyMapper.toCompanyEntity(newCompany)));
    }

    public Company delete(String id){
        if(companyRepository.existsById(id)){
            Company company = CompanyMapper.toCompany(companyRepository.getOne(id));
            companyRepository.deleteById(id);
            return company;
        }else{
            throw new NotFoundException("Company not found with id " + id);
        }
    }
}
