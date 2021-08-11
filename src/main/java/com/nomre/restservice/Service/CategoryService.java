package main.java.com.nomre.restservice.Service;

import main.java.com.nomre.restservice.Model.MsisdnCategory;
import main.java.com.nomre.restservice.Repository.CategoryRepository;
import main.java.com.nomre.restservice.Repository.Specification.CategorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategorySpecification categorySpecification;

    /*
    *  Reason why query-ing DB twice is that with H2 @Query
    *  wasn't able to properly run LIKE condition for pattern matching
    *  " and lower(c.MSISDN) like  CONCAT('%', :pattern,'%') "
    *  Temporary workaround to separately run queries and join results
    */

    public List<String> getMsisdnList(String category, String msisdnPattern){
        //pattern and category filter applied
        List<MsisdnCategory> msisdnList= categoryRepository.findAll(categorySpecification.getMsisdn(category, msisdnPattern));
        List<MsisdnCategory>  notReservedMsisdnList= categoryRepository.getMsisdnCategoryWithOutReservation(category);
        List<String> filteredMsisdn = msisdnList.stream().map(MsisdnCategory::getMsisdn).collect(Collectors.toList());
        List<String> unreservedMsisdn=notReservedMsisdnList.stream().map(MsisdnCategory::getMsisdn).collect(Collectors.toList());
        List<String > resultMsisdn = filteredMsisdn.stream()
                .filter(unreservedMsisdn::contains)
                .collect(Collectors.toList());



        return resultMsisdn;
    }





}
