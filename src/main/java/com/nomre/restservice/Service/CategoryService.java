package main.java.com.nomre.restservice.Service;

import main.java.com.nomre.restservice.Model.MsisdnCategory;
import main.java.com.nomre.restservice.Repository.CategoryRepository;
import main.java.com.nomre.restservice.Repository.Specification.CategorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategorySpecification categorySpecification;

    public List<MsisdnCategory> getMsisdnList(String category, String msisdnPattern){
        //List<MsisdnCategory> msisdnList= categoryRepository.findAll(categorySpecification.getMsisdn(category, msisdnPattern));
        String pattern=msisdnPattern.replaceAll("X","_");
        return categoryRepository.getMsisdnCategoryWithOutReservation(category, pattern);
    }





}
