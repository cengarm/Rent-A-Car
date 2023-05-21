package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRepository extends JpaRepository<Brand,Integer> {

    boolean existsByName(String name); // spring jpa özel keyworld var existsByName kendi arıyor


}
