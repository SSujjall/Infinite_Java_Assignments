package com.main.main.Domain.Entities;

import com.main.main.Domain.Enums.Status;
import com.main.main.Domain.Shared.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staffs extends Users {
    @Column(unique = true, nullable = false)
    private Long staffCode;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
