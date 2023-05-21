package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UptadeBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void uptade(UptadeBrandRequest uptadeBrandRequest);
    void delete(int id);
}
