package com.ra.model.dto.category;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDTO {
    private Long id;
    private String categoryName;

}
