/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.Tienda.repository;
        
import com.Tienda.Tienda.domain.Producto;
import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;    
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param; 


public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    

    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
  
    @Query(value="SELECT a FROM Producto a where a.existencias BETWEEN :existenciasInf AND :existenciasSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaAmpliadaExistencias(@Param("existenciasInf") int existenciasInf, @Param("existenciasSup") int existenciasSup);
}