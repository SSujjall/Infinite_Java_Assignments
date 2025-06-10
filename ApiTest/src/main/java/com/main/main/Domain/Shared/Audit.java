package com.main.main.Domain.Shared;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Audit {
    private Long createdBy;
    private LocalDate createdAt = LocalDate.now();
    private Long updatedBy;
    private LocalDate updatedAt;
    private Long statusId;
}
