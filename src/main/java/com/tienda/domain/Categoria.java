/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 *
 * @author spina
 */
@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") // Asumiendo que el nombre de la columna en la base de datos es "id_categoria"
    
    
    private Long idCategoria;

    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
        // Constructor vacío
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    List<Producto> productos;
}
