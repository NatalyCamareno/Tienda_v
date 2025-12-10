
package com.Tienda.Tienda.service;


import com.Tienda.Tienda.domain.Producto;
import com.Tienda.Tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

@Autowired
private ProductoRepositoty ProductoRepository; 

@Transactional(readOnly = true)
public List<Producto> getProductos (boolean activo { 
    var lista = productoRepository.findAll();
    //producto 2 - Monitor samsung
    //producto 3 = Monitor hp
    //producto 4 = Monitor lenovo
if (activo) {
lista.removeIf(e -> !e.getActivo ());
   }

    return lista;
}
}
@Transactional //Este metodo funciona para guardar y actualizar
public void save(Producto producto) {
productoRepository.save (producto);
}
}

@Trasactional
public boolean delete(Producto producto) { //Eliminar un Producto
try{
      productoRepository.delete (producto) ;
      productoRepository. flush () :
      return true;
} 
}
catch (Exception e) {
return false:
 }

Transactional (readonly = true)
public Producto getProducto (Producto producto) {
return productoRepository. findsyld (producto.getIdProducto ()).orElse(null) ;
}

//Lista de productos con precio inf y sup para la consulta ampliada
@Override
@Transactional(readOnly=true)
public List<Producto>findByPrecioBetweenOrderByDescripcion (double precioInf, double preciosup) {
      return productoRepository.findByPrecioBetweenOrderByDescripcion (precioInf, precioSup) ;
}

//Lista de producto con precio inf y sup para la consulta jpql
@Transactional (readOnly=true)
public List<Producto> metodoJPQL (double precioInf, double precioSup){
      return productoRepository metodoJPQL (precioInf, precioSup) ;
}
