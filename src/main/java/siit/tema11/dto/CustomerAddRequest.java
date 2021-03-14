package siit.tema11.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NotBlank
public class CustomerAddRequest {

    private Integer customerId;
    @NotBlank
    @Size(min=1,max=50)
    private String firstName;
    @NotBlank
    @Size(min=1,max=50)
    private String lastName;

    @NotBlank
    @DateTimeFormat
    private LocalDate birthDate;

    @NotBlank
    @Size(min=8, max = 15)
    private String phone;

    @NotBlank
    @Size(min=1,max=50)
    private String address;
    @NotBlank
    @Size(min=1,max=50)
    private String city;

    @NotBlank
    @Size(min=1,max=2)
    private String state;

    private Integer points;

}
