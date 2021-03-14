package siit.tema11.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NotBlank
public class CustomerUpdateRequest {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer points;

}
