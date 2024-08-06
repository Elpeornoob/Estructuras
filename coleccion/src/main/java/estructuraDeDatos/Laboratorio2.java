package estructuraDeDatos;

import javax.swing.JOptionPane;

import bryan.linkedlist.singly.LinkedList;
import bryan.util.iterator.Iterator;

public class Laboratorio2 {
    public static void main(String[] args) {

        LinkedList<Articulo> lista = new LinkedList<Articulo>();
            lista.add(new Articulo("Pan", 2, "Panaderia"));
            lista.add(new Articulo("Tomates", 5, "Verduras"));
            lista.add(new Articulo("Papel Higienico", 1, "Higiene"));
            lista.add(new Articulo("Queso", 1, "Lacteos"));
            lista.add(new Articulo("Jabon", 3, "Higiene"));
            lista.add(new Articulo("Huevos ", 12, "Lacteos"));
            lista.add(new Articulo("Cafe", 1, "Bebidas"));
            lista.add(new Articulo("Detergente", 1, "Limpieza"));
            lista.add(new Articulo("Platano", 6, "Frutas"));
            lista.add(new Articulo("Lechuga", 2, "Verduras"));
        boolean condition = true;
        while (condition) {

            String Opcion = JOptionPane.showInputDialog("Elija la accion que quiere hacer: " + "\n" + "\n" +
            "[1]. Agregar elementos a la lista." + "\n" +
            "[2]. Actualizar elementos de la lista." + "\n" +
            "[3]. Eliminar de la lista." + "\n" + 
            "[4]. Buscar elementos en la lista y mostrar." + "\n" +
            "[5]. Buscar elementos en la lista por categoria y mostrar." + "\n" + 
            "[6]. Salir");

            switch (Opcion) {
                case "1":
                    try {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del articulo: ");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del articulo: "));
                    String categoria = seleccionarCategoria();
                    lista.add(new Articulo(nombre, cantidad, categoria));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "El numero no es valido.");
                    }
                    break;
                case "2":
                   Articulo articuloSeleccionado2 = seleccionarArticulo(lista);
                    
                    if (articuloSeleccionado2 != null) {
                        try {
                            JOptionPane.showMessageDialog(null, "Artículo seleccionado: " + articuloSeleccionado2.getNombre());
                            int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad."));
                            if(nuevaCantidad > articuloSeleccionado2.getCantidad()){
                                JOptionPane.showMessageDialog(null, "La cantidad nueva debe ser menor a la actual.");
                            }else{
                                articuloSeleccionado2.setCantidad(nuevaCantidad);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Numero no valido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado o lista vacia.");
                    }
                    
                    break;
                case "3":
                    Articulo articuloSeleccionado3 = seleccionarArticulo(lista);

                    if (articuloSeleccionado3 != null) {
                        lista.remove(articuloSeleccionado3);
                        JOptionPane.showMessageDialog(null, "Articulo eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado o lista vacia.");
                    }
                    
                    break;
                case "4":
                    Articulo articuloSeleccionado4 = seleccionarArticulo(lista);
                    
                    if (articuloSeleccionado4 != null) {
                        JOptionPane.showMessageDialog(null, "Artículo seleccionado: " + "\n" + articuloSeleccionado4.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado o lista vacia.");
                    }

                    break;
                case "5":
                    Articulo articuloSeleccionado5 = seleArticuloPorCategoria(lista);

                    if (articuloSeleccionado5 != null) {
                        JOptionPane.showMessageDialog(null, "Artículo seleccionado: " + "\n" + articuloSeleccionado5.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado o lista vacia.");
                    }
                    break;
                case "6":
                    condition = false;
                    break;
                case null:
                    condition = false;
                    break;
                default:
                    break;
            }   
        }
        
        
    }

    public static Articulo seleccionarArticulo(LinkedList<Articulo> lista){
        if(lista.isEmpty() || lista == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");;
            return null;
        }
        // Convertir la lista a un array de Articulo
        Articulo[] articulos = new Articulo[lista.size()];
        lista.toArray(articulos);
        
        // Convertir el array de Articulo a un array de Strings con solo los nombres
        String[] nombresArticulos = new String[articulos.length];
        for (int i = 0; i < articulos.length; i++) {
            nombresArticulos[i] = articulos[i].getNombre();
        }
        
        // Mostrar el diálogo de selección
        String nombreSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un artículo",
            "Buscar Artículo",
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresArticulos,
            nombresArticulos[0]
        );
        
        // Buscar el Articulo correspondiente en el array original
        Articulo articuloSeleccionado = null;
        for (Articulo articulo : articulos) {
            if (articulo.getNombre().equals(nombreSeleccionado)) {
                articuloSeleccionado = articulo;
                break;
            }
        }
        return articuloSeleccionado;
   }

   public static Articulo seleArticuloPorCategoria(LinkedList<Articulo> lista){
        String categoriaDeProducto = seleccionarCategoria();
        LinkedList<Articulo> articulosDeCategoria = new LinkedList<>();
        Iterator<Articulo> it = lista.iterator();
        while (it.hasNext()) {
            Articulo art = it.next();
            if(art.getCategoria().equals(categoriaDeProducto)){
                articulosDeCategoria.add(art);
            }
        }
        
        return seleccionarArticulo(articulosDeCategoria);
   }

   public static String seleccionarCategoria(){
        // Mostrar el diálogo de selección
        String nombreSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un artículo",
            "Buscar Artículo",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[] {"Panaderia" , "Verduras", "Higiene", "Lacteos", "Bebidas", "Limpieza", "Frutas"},
            "Panaderia"
        );
        
        return nombreSeleccionado;
    }
}
