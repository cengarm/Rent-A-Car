package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne // tam tersi şeklinde yaptık.
    @JoinColumn(name="brand_id")
    private  Brand brand; // 1 arabanın sadece 1 modeli olacağı için böyle yazdık

    @OneToMany(mappedBy = "model") // 1 model To birsürü araba
    private List<Car> cars; // 1 modelin 1 sürü arabası olabilir
}
