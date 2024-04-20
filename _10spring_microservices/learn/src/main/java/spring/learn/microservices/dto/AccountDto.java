package spring.learn.microservices.dto;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor // Data generate hashcode & equals method, kadang-kadang menjadi masalah
public class AccountDto {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
