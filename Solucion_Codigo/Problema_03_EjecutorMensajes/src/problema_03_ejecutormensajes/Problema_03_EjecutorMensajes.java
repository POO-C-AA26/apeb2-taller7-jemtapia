import java.util.ArrayList;

/**
 * Problema 03
 * Sistema de envío de mensajes a móviles
 * Autor: José Enrique Merecí Tapia
 */

abstract class Mensaje {

    private String remitente;
    private String destinatario;
    private String contenido;
    public Mensaje(String remitente, String destinatario, String contenido) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.contenido = contenido;
    }

    public abstract void enviarMensaje();

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Mensaje{"
                + "remitente=" + remitente
                + ", destinatario=" + destinatario
                + ", contenido=" + contenido
                + '}';
    }

}

class SMS extends Mensaje {
    public SMS(String remitente,
               String destinatario,
               String contenido) {
        super(remitente, destinatario, contenido);
    }

    @Override
    public void enviarMensaje() {

        System.out.println("\n====== SMS ======");
        System.out.println("Remitente: " + getRemitente());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Contenido: " + getContenido());
    }
    @Override
    public String toString() {
        return "SMS{"
                + super.toString()
                + '}';

    }

}

class MMS extends Mensaje {
    private String imagen;
    public MMS(String remitente,
               String destinatario,
               String contenido,
               String imagen) {
        super(remitente, destinatario, contenido);
        this.imagen = imagen;

    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public void enviarMensaje() {

        System.out.println("\n====== MMS ======");
        System.out.println("Remitente: " + getRemitente());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Contenido: " + getContenido());
        System.out.println("Imagen: " + imagen);
    }

    @Override
    public String toString() {

        return "MMS{"
                + "imagen=" + imagen
                + "} "
                + super.toString();

    }
}
class Celular {

    private String numero;
    private ArrayList<Mensaje> mensajes;

    public Celular(String numero) {

        this.numero = numero;
        mensajes = new ArrayList<>();

    }

    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void agregarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }
    public void mostrarMensajes() {

        System.out.println("\n==================================");
        System.out.println("MENSAJES DEL CELULAR");
        System.out.println("Número: " + numero);
        System.out.println("==================================");

        for (Mensaje mensaje : mensajes) {
            mensaje.enviarMensaje();

        }
    }
}

public class Problema_03_EjecutorMensajes {

    public static void main(String[] args) {

        Celular celular = new Celular("0987654321");

        SMS sms1 = new SMS(
                "0991111111",
                "0987654321",
                "Hola Jose, ¿cómo estás?"
        );

        SMS sms2 = new SMS(
                "0988888888",
                "0987654321",
                "Nos vemos mañana."
        );

        MMS mms1 = new MMS(
                "0977777777",
                "0987654321",
                "Te envío la fotografía.",
                "fotoVacaciones.jpg"
        );

        MMS mms2 = new MMS(
                "0966666666",
                "0987654321",
                "Aquí está el documento.",
                "documento.png"
        );

        celular.agregarMensaje(sms1);
        celular.agregarMensaje(sms2);
        celular.agregarMensaje(mms1);
        celular.agregarMensaje(mms2);

        celular.mostrarMensajes();

    }

}
/**
 * ==================================
MENSAJES DEL CELULAR
N�mero: 0987654321
==================================

====== SMS ======
Remitente: 0991111111
Destinatario: 0987654321
Contenido: Hola Jose, �c�mo est�s?

====== SMS ======
Remitente: 0988888888
Destinatario: 0987654321
Contenido: Nos vemos ma�ana.

====== MMS ======
Remitente: 0977777777
Destinatario: 0987654321
Contenido: Te env�o la fotograf�a.
Imagen: fotoVacaciones.jpg

====== MMS ======
Remitente: 0966666666
Destinatario: 0987654321
Contenido: Aqu� est� el documento.
Imagen: documento.png
BUILD SUCCESSFUL (total time: 1 second)
 */
