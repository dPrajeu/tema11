package siit.tema11.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name= "order_id")
    private Integer orderId;

    @Column(name="customer_id")
    private Integer customerId;

//    @JoinColumn(name= "customer_id") //
//    @ManyToOne(fetch = FetchType.EAGER)
//    private CustomerEntity customerEntity;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @JoinColumn(name ="status", referencedColumnName = "order_status_id")
    private Integer status;



}
