package com.mycompany.pruebaproductos;
import java.math.BigDecimal;

/**
 *
 * @author Sistemas3
 */
public class Producto {
    //declarar 
      private int id;
      private String nombre;
      private BigDecimal precio;
      public Producto (int id, String nombre, BigDecimal precio ){
        
        //operador this se utiliza para referirse a la instancia actual de la clase
        this.id = id;
        this.nombre= nombre;
        this.precio=precio;
        
}
    //generar codigo source --> insertar codigo --->getter&setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

      //generar codigo source --> insertar codigo --->string

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
    

   
