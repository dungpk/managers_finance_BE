package com.example.cg_finance_managers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;
    private String accountName;
    private String fullName;
    private String address;
    private String birthday;
    @NotEmpty(message = "Không để trường email trống.")
    @Email(message = "Nhập đúng định dạng email.")
    private String email;
    @NotEmpty(message = "Không được để mật khẩu trống. ")
    @Size(min = 8, message = "Mật khẩu có ít nhất 8 ký tự.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Mật khẩu phải chứa các kí tự đặc biệt. "
    )
    private String password;
    private String confirmPassword;
    private String url;
}
