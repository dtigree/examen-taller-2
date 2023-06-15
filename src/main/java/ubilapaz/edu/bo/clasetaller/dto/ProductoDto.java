package ubilapaz.edu.bo.clasetaller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDto {
    public String codigo;
    public String nombre;
    public Double precio;
//    public ProductoDto(String codigo, Double precio, String nombre) {
//        this.precio = precio;
//        this.codigo = codigo;
//        this.nombre = nombre;
//    }
}
