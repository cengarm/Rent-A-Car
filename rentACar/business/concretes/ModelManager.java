package kodlama.io.rentACar.business.concretes;


import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.dtos.requests.CreateModelRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor// extradan constructor yapmamıza gerek yok

public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses = models.stream()//modelden listinden gelenleri tek tek dolaş.
                .map(model ->this.modelMapperService
                        .forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        //stream() tek tek dolaşıyor foreach gibi listi geziyor.
        //.map hepsini brand nesnesi için mapliyor.
        //.collect hepsini toplayıp collectors.tolist tipine ceviriyor.
        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);

    }
}
