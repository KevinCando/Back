package ec.cepam.backend.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRQ {
    private String name;
    private String pass;
}
