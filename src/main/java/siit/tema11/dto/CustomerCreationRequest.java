package siit.tema11.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreationRequest {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer points;
}
