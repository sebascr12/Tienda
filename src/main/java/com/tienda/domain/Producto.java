/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;
import jakarta.persistence.*;
import java.io.Serializable; 
import lombok.Data;

/**
 *
 * @author spina
 */

@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_producto")
     private Long idProducto;
    
    private String detalle;
    private int existencias;
    private double precio;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
   
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;
    
    public Producto(){
        
    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }
    
    
     
     

}
