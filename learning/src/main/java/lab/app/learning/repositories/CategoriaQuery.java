package lab.app.learning.repositories;

import lab.app.learning.models.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


public interface CategoriaQuery extends PagingAndSortingRepository<Categoria, Long> {

//    @Query("SELECT cat FROM categoria AS cat WHERE cat.id = :id")
//    Categoria findCategoriaById(@Param("id") Long id);

}
