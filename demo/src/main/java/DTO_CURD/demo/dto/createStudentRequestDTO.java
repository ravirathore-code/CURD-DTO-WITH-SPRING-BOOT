package DTO_CURD.demo.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class createStudentRequestDTO {

    private Long id ;
    @NotBlank
    @Size(min=2,max=20)
    private String name ;
    @Min(value = 18)
    @Max(value = 65)
    private int age ;
    @Email
    private String email ;
    private String Phone_number ;
    private LocalDateTime created_at ;
    private LocalDateTime update_at ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }
}
