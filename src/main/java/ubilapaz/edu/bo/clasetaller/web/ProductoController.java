package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.domain.ProductoUser;
import ubilapaz.edu.bo.clasetaller.domain.User;
import ubilapaz.edu.bo.clasetaller.dto.ProductoDto;
import ubilapaz.edu.bo.clasetaller.dto.UserDto;
import ubilapaz.edu.bo.clasetaller.persistence.ProductoRepository;
import ubilapaz.edu.bo.clasetaller.persistence.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/create")
    public ResponseEntity<String> registrar(@RequestBody ProductoDto productoDto){
        String mensaje = "Registro exitoso";
        try{

            ProductoUser producto= new ProductoUser();
            producto.setNombre(productoDto.nombre);
            producto.setCodigo (productoDto.codigo.toUpperCase());
            producto.setPrecio(productoDto.precio);
            producto.setFechaRegistro(LocalDateTime.now());
            productoRepository.save(producto);
            //registrar el objeto
            /*if(userDto.nombre== 'ADM' || userDto.nombre=='JEF' || userDto.nombre=='USU'){

                userRepository.save(user);
            }else{
                mensaje= "el campo nombre no es un codigo valido"
            }*/
        }catch (Exception e){
            System.out.println(e);
            mensaje = "Algo salio mal";
        }


        //userRepository.findAll();
        return new ResponseEntity<String>(mensaje, HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<ProductoDto>> list(){
        List<ProductoDto> productoList =  productoRepository.obtenerLista();
        return new ResponseEntity<List<ProductoDto>>(productoList, HttpStatus.OK);
    }
}
