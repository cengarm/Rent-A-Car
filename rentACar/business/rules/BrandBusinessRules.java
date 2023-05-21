package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules { // müşterilerin bize verdiği kurallar.

private BrandRepository brandRepository; // Databaseme bakması gerekiyor kontrol için !!

    public void checkIfBrandNameExists(String name){ // marka ismi tekrar ediyor mu ?
//parametre olarak String name marka ismi alıyoruz!!

            if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists"); //Çalışırken oluşabilecke bir hata
            }//ama iş hatası olucaksa BusinessException (" ") diye yazman lazım
    }

}
