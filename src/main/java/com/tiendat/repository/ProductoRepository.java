package com.tiendat.repository;

import com.tiendat.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Productos activos
    public List<Producto> findByActivoTrue();
    
    // Consulta derivada
    public List<Producto> findByPrecioBetweenOrderByPrecioAsc(double precioInf, double precioSup);

    // Consulta JPQL
    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Producto> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    // Consulta SQL nativa
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC"
    )
    public List<Producto> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio DESC")
    public List<Producto> productosCaros(@Param("precioInf") double precioInf,@Param("precioSup") double precioSup);

}
