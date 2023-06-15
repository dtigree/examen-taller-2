package ubilapaz.edu.bo.clasetaller.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubilapaz.edu.bo.clasetaller.domain.ProductoUser;
import ubilapaz.edu.bo.clasetaller.dto.ProductoDto;
import ubilapaz.edu.bo.clasetaller.dto.UserDto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoUser,Integer> {
    @Query(value = "SELECT new ubilapaz.edu.bo.clasetaller.dto.ProductoDto(r.codigo, r.nombre, r.precio) FROM ProductoUser r order by id desc")
    List<ProductoDto> obtenerLista();
}
