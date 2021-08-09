package main.java.com.nomre.restservice.Service;

import main.java.com.nomre.restservice.Helpers.CSVHelper;
import main.java.com.nomre.restservice.Model.MsisdnCategory;
import main.java.com.nomre.restservice.Repository.CategoryRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    CategoryRepository categoryRepository;

    static String[] HEADERs = {"MSISDN", "CATEGORY"};



    public static List<MsisdnCategory> csvToMSISDNCategory(InputStream is) {
       return null;
    }


    public void save(MultipartFile file) {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {


                int batchSize = 0;
                List<MsisdnCategory> msisdnCategoryList = new LinkedList<>();


                for (CSVRecord csvRecord : csvParser) {
                    MsisdnCategory msisdnCategory = new MsisdnCategory(
                            csvRecord.get("MSISDN"), csvRecord.get("CATEGORY"));
                    msisdnCategoryList.add(msisdnCategory);
                    batchSize++;
                    if (batchSize == 10000) {
                        categoryRepository.saveAll(msisdnCategoryList);
                        batchSize = 0;
                        msisdnCategoryList = new LinkedList<>();
                    }

                }

                if(batchSize>0){
                    categoryRepository.saveAll(msisdnCategoryList);
                }



            } catch (IOException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }


    }

    public List<MsisdnCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

}
