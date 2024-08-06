package estructuraDeDatos;

public class Articulo {
    private String nombre;
    private int cantidad;
    private String categoria;
    
    public Articulo(String nombre, int cantidad, String categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nombre = " + nombre + "\n" + "Cantidad = " + cantidad + "\n" + "Categoria = " + categoria;
    }

}
