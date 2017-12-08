package guru.springframework.domain;

import lombok.Data;

@Data
public class Loan {
    private long id_loan;
    private long id_user;
    private long id_media;
}
