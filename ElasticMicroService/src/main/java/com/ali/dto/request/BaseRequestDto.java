package com.ali.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseRequestDto {
    String token;
    /**
     * Her bir istekte göstermek istediğimiz kayıt adedi
     */
    Integer pageSize;
    /**
     * Şuan bulunduğumuz, talep ettiğimiz sayfa numarası
     */
    Integer currentPage;
    /**
     * Hangi alan a göre sıralama yapılacak ise o alanın adı
     */
    String sortParameter;
    /**
     * sıralamanın yönü, a..Z, ASC,DESC
     */
    String direction;
}
