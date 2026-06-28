/**
 * Problema 01: Capitulo de un libro
 * @author Jose Enrique
 * @version 1.0
 */
import java.util.ArrayList;
abstract class ComponenteSeccion {
}

class Palabra {
    private String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }

    public String obtenerTexto() {
        return texto;
    }
}

class Sentencia {
    private ArrayList<Palabra> palabras;

    public Sentencia() {
        this.palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra p) {
        this.palabras.add(p);
    }

    public ArrayList<Palabra> obtenerPalabras() {
        return palabras;
    }
}

class Parrafo extends ComponenteSeccion {
    private ArrayList<Sentencia> sentencias;

    public Parrafo() {
        this.sentencias = new ArrayList<>();
    }

    public void agregarSentencia(Sentencia s) {
        this.sentencias.add(s);
    }

    public ArrayList<Sentencia> obtenerSentencias() {
        return sentencias;
    }
}

class Figura extends ComponenteSeccion {
    private String urlImagen;
    private String etiqueta;

    public Figura(String urlImagen, String etiqueta) {
        this.urlImagen = urlImagen;
        this.etiqueta = etiqueta;
    }

    public String obtenerEtiqueta() {
        return etiqueta;
    }
}

class Seccion {
    private String titulo;
    private ArrayList<ComponenteSeccion> componentes;

    public Seccion(String titulo) {
        this.titulo = titulo;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(ComponenteSeccion c) {
        this.componentes.add(c);
    }

    public ArrayList<ComponenteSeccion> obtenerComponentes() {
        return componentes;
    }

    public String obtenerTitulo() {
        return titulo;
    }
}

class Capitulo {
    private String titulo;
    private ArrayList<Seccion> secciones;

    public Capitulo(String titulo) {
        this.titulo = titulo;
        this.secciones = new ArrayList<>();
    }

    public void agregarSeccion(Seccion s) {
        this.secciones.add(s);
    }

    public ArrayList<Seccion> obtenerSecciones() {
        return secciones;
    }

    public String obtenerTitulo() {
        return titulo;
    }
}

public class Problema_01_EjecutorCapitulo {
    public static void main(String[] args) {
        Capitulo capitulo1 = new Capitulo("Capítulo 1: Fundamentos de Computación");
        Seccion seccion1 = new Seccion("1.1 Introducción al software");

        Palabra palabraCompartida = new Palabra("objeto");
        Palabra p1 = new Palabra("El");
        Palabra p2 = new Palabra("es");
        Palabra p3 = new Palabra("un");
        Palabra p4 = new Palabra("lógico");

        Sentencia s1 = new Sentencia();
        s1.agregarPalabra(p1);
        s1.agregarPalabra(palabraCompartida);

        String textoS1 = "";
        for (Palabra p : s1.obtenerPalabras()) {
            textoS1 += p.obtenerTexto() + " ";
        }

        Sentencia s2 = new Sentencia();
        s2.agregarPalabra(p2);
        s2.agregarPalabra(p3);
        s2.agregarPalabra(palabraCompartida);
        s2.agregarPalabra(p4);

        String textoS2 = "";
        for (Palabra p : s2.obtenerPalabras()) {
            textoS2 += p.obtenerTexto() + " ";
        }

        Parrafo parrafo1 = new Parrafo();
        parrafo1.agregarSentencia(s1);
        parrafo1.agregarSentencia(s2);

        Figura figura1 = new Figura("imagen_arquitectura.png", "Figura 1.1 Diagrama de bloques");

        seccion1.agregarComponente(parrafo1);
        seccion1.agregarComponente(figura1);
        capitulo1.agregarSeccion(seccion1);

        System.out.println("=== ESTRUCTURA DEL DOCUMENTO PROCESADA ===");
        System.out.println("Libro/Capítulo: " + capitulo1.obtenerTitulo());
        System.out.println(" Sección: " + seccion1.obtenerTitulo());
        System.out.println(" Componente 1: [Párrafo]");
        System.out.println(" Sentencia 1: " + textoS1.trim());
        System.out.println(" Sentencia 2: " + textoS2.trim());
        System.out.println(" Componente 2: [Figura] -> " + figura1.obtenerEtiqueta());
    }
}
/**
 * run:
=== ESTRUCTURA DEL DOCUMENTO PROCESADA ===
Libro/Cap�tulo: Cap�tulo 1: Fundamentos de Computaci�n
 Secci�n: 1.1 Introducci�n al software
 Componente 1: [P�rrafo]
 Sentencia 1: El objeto
 Sentencia 2: es un objeto l�gico
 Componente 2: [Figura] -> Figura 1.1 Diagrama de bloques
BUILD SUCCESSFUL (total time: 0 seconds)

 */