package estructuraDeDatos;

import javax.swing.JOptionPane;

import bryan.linkedlist.singly.LinkedList;

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
            "[4]. Buscar elementos en la lista." + "\n" + 
            "[5]. Actualizar elementos de la lista" + "\n" +
            "[6]. Salir");

            switch (Opcion) {
                case "1":
                    try {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del articulo: ");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del articulo: "));
                    String categoria = JOptionPane.showInputDialog("Ingrese la categorria del articulo: ");
                    lista.add(new Articulo(nombre, cantidad, categoria));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "El numero no es valido.");
                    }
                    break;
                case "2":
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
                    
                    if (articuloSeleccionado != null) {
                        try {
                            JOptionPane.showMessageDialog(null, "Artículo seleccionado: " + articuloSeleccionado.getNombre());
                            int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad."));
                            if(nuevaCantidad > articuloSeleccionado.getCantidad()){
                                JOptionPane.showMessageDialog(null, "La cantidad nueva debe ser menor a la actual.");
                            }else{
                                articuloSeleccionado.setCantidad(nuevaCantidad);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Numero no valido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado.");
                    }
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                // Convertir la lista a un array de Articulo
                    Articulo[] articulos1 = new Articulo[lista.size()];
                    lista.toArray(articulos1);
                    
                    // Convertir el array de Articulo a un array de Strings con solo los nombres
                    String[] nombresArticulos1 = new String[articulos1.length];
                    for (int i = 0; i < articulos1.length; i++) {
                        nombresArticulos1[i] = articulos1[i].getNombre();
                    }
                    
                    // Mostrar el diálogo de selección
                    String nombreSeleccionado1 = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione un artículo",
                        "Buscar Artículo",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        nombresArticulos1,
                        nombresArticulos1[0]
                    );
                    
                    // Buscar el Articulo correspondiente en el array original
                    Articulo articuloSeleccionado1 = null;
                    for (Articulo articulo1 : articulos1) {
                        if (articulo1.getNombre().equals(nombreSeleccionado1)) {
                            articuloSeleccionado1 = articulo1;
                            break;
                        }
                    }
                    
                    if (articuloSeleccionado1 != null) {
                        JOptionPane.showMessageDialog(null, "Artículo seleccionado: " + "\n" + articuloSeleccionado1.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado.");
                    }

                    break;
                case "5":

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
}
