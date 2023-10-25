package com.example.cg_finance_managers.dto.user_dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
    private String fullName;
    private String address;
    private Date birthday;
    @NotEmpty(message = "Không để trường email trống.")
    @Email(message = "Nhập đúng định dạng email.")
    private String email;
}