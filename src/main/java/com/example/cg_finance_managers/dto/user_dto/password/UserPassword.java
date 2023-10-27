package com.example.cg_finance_managers.dto.user_dto.password;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPassword {
    @NotEmpty(message = "Không để trường email trống.")
    private String newPassword;
    @NotEmpty(message = "Không để trường email trống.")
    private String oldPassword;
}

