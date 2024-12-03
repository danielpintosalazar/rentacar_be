package com.rentacar.client;

import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String nombre;
    private String marca;
    private String color;
}
