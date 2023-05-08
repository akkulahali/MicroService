package com.ali.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder //BaseEntity miras alındığı için bunu kullanıyoruz.
public class BaseEntity {
    Long createat;
    Long updateat;
    boolean state;
}
