
package entidades;

import java.util.ArrayList;

public enum Categoria {
    merch, 
    consolas, 
    videojuegos, 
    periféricos, 
    otros;
    public static ArrayList <Categoria> categoriasExistentes = new ArrayList<>();
    
    public static void actualizarCategorias (){
        for (int i = 0; i < categoriasExistentes.size(); i++) {
            Categoria cat[] = Categoria.values();
            categoriasExistentes.add(cat[i]);
        }
    }
    
    public static Categoria mostrarCategorias (){
        actualizarCategorias();
        for (Categoria c : categoriasExistentes) {
        return c;
        }
        return null;
    }
    
    public static Categoria getMerch() {
        return merch;
    }

    public static Categoria getConsolas() {
        return consolas;
    }

    public static Categoria getVideojuegos() {
        return videojuegos;
    }

    public static Categoria getPeriféricos() {
        return periféricos;
    }

    public static Categoria getOtros() {
        return otros;
    }
}
