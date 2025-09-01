import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("*              Bienvenido al programa              *");
        System.out.println("****************************************************\n");
        System.out.print("Introduzca el directorio a comprobar: ");
        String directorio = sc.nextLine();
        File directorioAComprobar = new File(directorio);
        if (directorioAComprobar.isDirectory() || directorioAComprobar.isFile()) {
            int opcion = 0;

            do {
                System.out.println("\n\n****************************************************");
                System.out.println("1. Listar ficheros/directorios de un directorio.");
                System.out.println("2. Listar caracteristicas de un fichero/directorio.");
                System.out.println("3. Crear una carpeta y dos archivos (modificar y eliminar.");
                System.out.println("4. listar directorios de forma recursiva.");
                System.out.println("5. Salir.");
                System.out.println("****************************************************\n");
                System.out.println("Introduzca una opcion: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        File[] ficheros = directorioAComprobar.listFiles();
                        if (ficheros != null) {
                            for(File fichero : ficheros) {
                                if (fichero.isDirectory()) {
                                    System.out.println("- Directorio: " + fichero.getName());
                                } else {
                                    System.out.println("- Fichero: " + fichero.getName());
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("- Nombre: " + directorioAComprobar.getName());
                        System.out.println("- Ruta absoluta: " + directorioAComprobar.getAbsolutePath());
                        System.out.println("- ¿Leer?: " + directorioAComprobar.canRead());
                        System.out.println("- ¿Escribir?: " + directorioAComprobar.canWrite());
                        PrintStream var10000 = System.out;
                        long var10001 = directorioAComprobar.length() / 1024L;
                        var10000.println("- Tamaño: " + var10001 / 1024L + " MB");
                        System.out.print("- Tipo: ");
                        if (directorioAComprobar.isDirectory()) {
                            System.out.println("Directorio");
                        } else {
                            System.out.println("Fichero");
                        }

                        System.out.println("- Directorio padre: " + directorioAComprobar.getParent());
                        break;
                    case 3:
                        String nuevoDirectorio = directorio + "\\NUEVODIR";
                        File nuevoDirectorioAComprobar = new File(nuevoDirectorio);
                        nuevoDirectorioAComprobar.mkdir();
                        File fichero1 = new File(nuevoDirectorio + "\\fichero1.txt");

                        try {
                            fichero1.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        File fichero2 = new File(nuevoDirectorio + "\\fichero2.txt");

                        try {
                            fichero2.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        File fichero = new File(nuevoDirectorio + "\\fichero");
                        fichero1.renameTo(fichero);
                        fichero2.delete();
                        break;
                    case 4:
                        recursividad(directorioAComprobar);
                        break;
                    case 5:
                        System.out.println("¡¡Hasta pronto!!");
                        break;
                    default:
                        System.out.println("Esa opcion no esta disponible");
                }
            } while(opcion != 5);
        }

    }

    public static void recursividad(File dir) {
        File[] listaDirectorio = dir.listFiles();
        if (listaDirectorio != null && listaDirectorio.length > 0) {
            for(File dir2 : listaDirectorio) {
                if (dir2.isDirectory()) {
                    System.out.println("- Directorio: " + dir2.getName());
                    recursividad(dir2);
                } else {
                    System.out.println("- Ficheros: " + dir2.getName());
                }
            }
        }

    }
}
