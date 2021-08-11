package main.java.com.nomre.restservice.Repository.Specification;

import main.java.com.nomre.restservice.Model.MsisdnCategory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class CategorySpecification {
    public Specification<MsisdnCategory> getMsisdn(String category, String msisdnPattern ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (category.isEmpty() || category.toLowerCase().equals("all") ) {
                predicates.add(criteriaBuilder.isTrue(criteriaBuilder.literal(true)));
            }else if (category != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }
             if(msisdnPattern != null){
                String pattern=msisdnPattern.replace('X','_');
                predicates.add(criteriaBuilder.like(root.get("msisdn"), pattern));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
