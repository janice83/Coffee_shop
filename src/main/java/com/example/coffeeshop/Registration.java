package com.example.coffeeshop;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration extends AbstractPersistable<Long> {
 
    @Size(min = 4, max = 50)
    private String name;

    @Size(min = 4, max = 50)
    private String address;
    
    @NotEmpty
    @Email
    private String email;

    @Size(min = 4, max = 10)
    private String username;

    @Size(min = 4, max = 20)
    private String password;


}