/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Tienda.Tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data 
@Entity 
@Table (name="rol") 
public class Rol implements Serializable {
    private static final long SerialVersionUID = 1L; 
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private Long idRol;
    private String nombre;
    private Long idUsuario;

}
