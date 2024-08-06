package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    //Producto viene del domain, producto hace una instancia lo que hace es extraer todas las variables que tiene adentro
    //vaya busque en la clase Producto y haga un objeto que me permita ejercer la accion
    public Producto getProducto(Producto producto){
        return productoDao.findById(producto.getIdProducto()).orElse(null);    }
    
    @Override
    @Transactional
    public void save(Producto producto){
        productoDao.save(producto);//voy a guardar o modificar el id de producto
    }
    
    @Override
    @Transactional
    public void delete(Producto producto){
        productoDao.delete(producto);//voy a eliminar el id de producto
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findbyPrecioBetweenOrderByDescription(double precioInf, double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    
    //otro query
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup){
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup){
        return productoDao.metodoNativo(precioInf, precioSup);

    }





}
