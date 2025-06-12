package com.main.main.Domain.Shared;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.main.Domain.Entities.BankAccount;
import com.main.main.Domain.Entities.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Users extends Audit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected Long userId;

    @Column(nullable = false, unique = true)
    protected String username;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;

    protected String firstName;
    protected String lastName;

    @Column(nullable = false, unique = true)
    protected String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> userRoles;
}
