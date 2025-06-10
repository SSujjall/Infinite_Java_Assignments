package com.main.main.Domain.Entities;

import com.main.main.Domain.Enums.Status;
import com.main.main.Domain.Shared.Users;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers extends Users {
    @Column(unique = true, nullable = false)
    private Long customerCode;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.ACTIVE;
}
