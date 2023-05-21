package kodlama.io.rentACar.business.dtos.responses;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandResponse {
    private int id;
    private String name;
}
