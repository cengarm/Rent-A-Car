package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UptadeBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand ->this.modelMapperService
                        .forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        //stream() tek tek dolaşıyor foreach gibi listi geziyor.
        //.map hepsini brand nesnesi için mapliyor.
        //.collect hepsini toplayıp collectors.tolist tipine ceviriyor.

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response =this.modelMapperService
                .forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        // hatayı create yaparken alacağımız için buraya yazdık!!
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand); // id almadığımız için add olur
        // Burada createBrandRequest databasesinden mapleyip yeni brand elde ediyor.
    }

    @Override
    public void uptade(UptadeBrandRequest uptadeBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(uptadeBrandRequest, Brand.class);
        this.brandRepository.save(brand); // id aldığımız için uptade olur
    }

    @Override
    public void delete(int id) {
this.brandRepository.deleteById(id);
    }
}
