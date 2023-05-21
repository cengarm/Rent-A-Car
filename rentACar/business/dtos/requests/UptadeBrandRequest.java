package kodlama.io.rentACar.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UptadeBrandRequest {
    private  int id; // uptade yaparken id ve name lazım görmek isteriz id yi
    private  String name;
}
