package dachaja.idsProject.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private long id;

    @NotEmpty
    private String loginId; //email

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;
}
