package spring.template.demo.nonmasterdata.channel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "channels")
@Data
@Builder
@AllArgsConstructor
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idChannel;
    private String path;
    private String requestMethod;
}
