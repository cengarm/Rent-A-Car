package kodlama.io.rentACar.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull
    @NotBlank // entitilerde kullanılmaz request ve responselerde kullanılır.
    @Size(min = 3 , max= 20 ) //ismi min 3 harf max 20 harf olabilir.
    private String name;
    @NotNull
    @NotBlank
    private int brandId; // marka idsi ne olacak!
}
