/* 
 * Autor: Méndez García Raymundo
 * Número de cuenta: 113001958
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Category {

    private static ArrayList<Category> l = new ArrayList<>();
    private int category_id;
    private String category;

    public Category(int category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static void createCategory(int id, String category) {
        
        if(l.size() > 0) {
            for(int i = 0; i < l.size(); i++) {
                if (l.get(i).getCategory_id() != id) {
                    l.add(new Category(id, category));
                } 
            }
        } else {
            l.add(new Category(id, category));
        }
        
    }

    public static void getCategories() {
        
        if (l.isEmpty()) {
            System.out.println("\nNo existen categorías registradas.\n");
        } else {
            System.out.println("\nListado de categorías:\n");
            for (int i = 0; i < l.size(); i++) {
                System.out.println(".- " + l.get(i).getCategory());
            }
        }
    }

    public static void getCategory(int category_id) {

        if (l.isEmpty()) {
            System.out.println("\nNo existen categorías registradas.\n");
        } else {
            for(int i = 0; i < l.size(); i ++) {
                if (l.get(i).getCategory_id() == category_id) {
                    System.out.println("\nCategoría: " + l.get(i).getCategory() +
                    "\nID: " + category_id);
                } else {
                    System.out.println("\nNo existe una categoría con el ID ingresado.");
                }
            }
        }
    }

    public static void deleteCategory(int category_id) {
       
        if (l.isEmpty()) {
            System.out.println("\nNo existen categorías registradas.\n");
        } else {
            for(int i = 0; i < l.size(); i ++) {
                if (l.get(i).getCategory_id() == category_id) {
                    l.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        int opt;
        Scanner sc = new Scanner(System.in);

        do {    

            System.out.println("\nSeleccione una opción:\n" +
            "1.- Añadir categoría.\n" +
            "2.- Mostrar lista de cartegorías.\n" +
            "3.- Mostrar categoría mediante ID.\n" +
            "4.- Eliminar Categoría.\n" +
            "0.- Salir.\n");

            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("----- Nueva Categoría -----");
                    System.out.println("ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nombre:");
                    String category = sc.nextLine();
                    
                    createCategory(id, category);
                break;

                case 2:
                    getCategories();
                break;
                
                case 3:
                    System.out.println("\nIngrese el ID.\n"); 
                    int category_id = sc.nextInt();
                    getCategory(category_id);
                break;

                case 4:
                    System.out.println("\nIngrese el ID de la categoría que desea borrar.\n"); 
                    int id_to_delete = sc.nextInt();
                    deleteCategory(id_to_delete);
                break;
            }
        } while (opt != 0);
        sc.close();
    }
}