package kodlama.io.rentACar;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice // bütün controller buna bağlı
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@ExceptionHandler // hata oluşursa burdan geçicek
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) // hangi hata olursa ben onu handleyim
	{
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return  problemDetails;
	}
	@ExceptionHandler // hata oluşursa burdan geçicek
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) // hangi hata olursa ben onu handleyim
	{
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());

		for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
		validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return  validationProblemDetails;
	}



	//Consider defining a bean of type 'org.modelmapper.ModelMapper' in your configuration.
	//Modelmapper kullanacağımız zaman main classın içerisine bunları yazıyoruz. @Beanlı kısmı!!

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
