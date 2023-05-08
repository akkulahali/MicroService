package com.ali.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ÖNEMLİ!!!!!
 * Mutlaka modeller serileştirilmelidir.
 * Ayrıca paket ismi dahil olmak üzere bu sınıfın aynısı iletilen serviste de olmalıdır.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaveAuthModel implements Serializable {
    Long authid;
    String username;
    String email;
}
