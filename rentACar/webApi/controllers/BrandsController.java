package kodlama.io.rentACar.webApi.controllers;


import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UptadeBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;
    @GetMapping() // data çekmek
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}") // data çekmek
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping() // eklemek için
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add (@RequestBody() @Valid CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest); // @valid ekliyoruz ki Requestlerde ki kontroller çalışsın @Noblank @size gibi
    }
    @PutMapping()
    public void uptade(@RequestBody() UptadeBrandRequest uptadeBrandRequest){
        this.brandService.uptade(uptadeBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
