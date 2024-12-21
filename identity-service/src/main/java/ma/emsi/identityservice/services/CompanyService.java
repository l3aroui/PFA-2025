package ma.emsi.identityservice.services;

import ma.emsi.identityservice.Entities.Company;
import ma.emsi.identityservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createNewCompany(Company company){
        return companyRepository.save(company);
    }
}
