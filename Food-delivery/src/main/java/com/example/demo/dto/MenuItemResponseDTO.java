package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItemResponseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean available;

}
