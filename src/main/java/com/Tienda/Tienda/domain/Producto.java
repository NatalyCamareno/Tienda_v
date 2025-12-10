/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Tienda.Tienda.domain;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table;
import java.io.Serializable; 
import java.math.BigDecimal; 
import lombok.Data;

@Data
@Entity
@Table(name="producto")


public class Producto implements Serializable{
private static final long serialVersionUID = 1L; 
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")     
    private Integer idProducto; 
    
    @Column(unique = true, nullable = false, length = 30 )
    private String descripcion; 
    
    @Column (columnDefinition = "TEXT")
    private String detalle;
    
    @Column (precision = 12, scale = 2) 
    private BigDecimal precio;
      
    private Integer existencias; 
    
    @Column(length = 1024)
    private String rutaImagen; 
    
    @Column(name = "activo")
    private Boolean activo; 
    
    @ManyToOne 
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
            } 