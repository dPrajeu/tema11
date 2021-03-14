package siit.tema11.dto.customerDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.tema11.repository.CustomerRepository;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllCustomersTable {

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
