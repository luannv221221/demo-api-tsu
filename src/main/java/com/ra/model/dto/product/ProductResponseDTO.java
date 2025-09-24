package com.ra.model.dto.product;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDTO {
    private Long id;
    private String name;
    private double price;
    private String image;
    private String categoryName;
}
