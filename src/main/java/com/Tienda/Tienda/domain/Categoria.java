/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Tienda.Tienda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")    
    private Integer idCategoria; 
    
    @Column(unique = true, nullable = false, length = 30 )
    private String descripcion; 
    
    @Column(length = 1024)
    private String rutaImagen; 
    
    @Column(name = "activo")
    private Boolean activo; 
    
    @OneToMany (mappedBy="categoria") 
    private List<Producto> productos;

}