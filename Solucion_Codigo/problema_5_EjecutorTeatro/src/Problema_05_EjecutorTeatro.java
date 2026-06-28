/**
 * Dadas las siguientes clases, que expresan una relación de herencia entre las entidades:

Se desea gestionar la venta de entradas para un espectáculo en un teatro. El patio de butacas del teatro se divide 
* en varias zonas, cada una identificada por su nombre. Los datos de las zonas son los mostrados en la siguiente tabla:
* 
* Para realizar la compra de una entrada, un espectador debe indicar la zona que desea y presentar al vendedor el documento que justifique que tiene algún tipo de descuento (estudiante, abonado o pensionista). El vendedor sacará la entrada del tipo apropiado y de la zona indicada, en el momento de la compra se asignará a la entrada un identificador (un número entero) que permitirá la identificación de la entrada en todas las operaciones que posteriormente se desee realizar con ella.
Una entrada tiene como datos asociados su identificador, la zona a la que pertenece y el nombre del comprador.
Los precios de las entradas dependen de la zona y del tipo de entrada según lo explicado a continuación:
Entradas normales: su precio es el precio normal de la zona elegida sin ningún tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
La interacción entre el vendedor y la aplicación es la descrita en los siguientes casos de usos.
 * @author RaulArmijos
 * @version 1.0
 */
class Zona{
    public String nombreZona;
    public int cantidadLocalidades;
    public double precioNormal,precioAbonado;

    public Zona(String nombreZona,int cantidadLocalidades,double precioNormal,double precioAbonado){
        this.nombreZona=nombreZona;
        this.cantidadLocalidades=cantidadLocalidades;
        this.precioNormal=precioNormal;
        this.precioAbonado=precioAbonado;
    }

    @Override
    public String toString(){
        return "Zona{"
                +"nombreZona="+nombreZona
                +", cantidadLocalidades="+cantidadLocalidades
                +", precioNormal="+precioNormal
                +", precioAbonado="+precioAbonado
                +'}';
    }
}

class Entrada{
    public Zona zona;
    public int idEntrada;
    public String nombreComprador;
    public int numeroEntradas;
    public double costoFinalEntrada;

    public Entrada(Zona zona,int idEntrada,String nombreComprador,int numeroEntradas){
        this.zona=zona;
        this.idEntrada=idEntrada;
        this.nombreComprador=nombreComprador;
        this.numeroEntradas=numeroEntradas;
    }

    public double calcularCostoFinalEntrada(double precioEntrada){
        this.costoFinalEntrada=numeroEntradas*precioEntrada;
        return costoFinalEntrada;
    }

    @Override
    public String toString(){
        return "Entrada{"
                +"idEntrada="+idEntrada
                +", nombreComprador="+nombreComprador
                +", numeroEntradas="+numeroEntradas
                +", zona="+zona
                +", costoFinalEntrada="+costoFinalEntrada
                +'}';
    }
}

class Entrada_Normal extends Entrada{

    public Entrada_Normal(Zona zona,int idEntrada,String nombreComprador,int numeroEntradas){
        super(zona,idEntrada,nombreComprador,numeroEntradas);
    }

    public double calcularCostoFinalEntrada(){
        return super.calcularCostoFinalEntrada(zona.precioNormal);
    }

    @Override
    public String toString(){
        return "Entrada_Normal{} "+super.toString();
    }
}
abstract class Entrada {
    public Zona zona;
    public int idEntrada;
    public String nombreComprador;
    public int numeroEntradas;
    public double costoFinalEntrada;

    public Entrada(Zona zona, int idEntrada, String nombreComprador, int numeroEntradas) {
        this.zona = zona;
        this.idEntrada = idEntrada;
        this.nombreComprador = nombreComprador;
        this.numeroEntradas = numeroEntradas;
    }

    public abstract double calcularCostoFinalEntrada();

    @Override
    public String toString() {
        return "Entrada{" +
                "idEntrada=" + idEntrada +
                ", nombreComprador='" + nombreComprador + '\'' +
                ", numeroEntradas=" + numeroEntradas +
                ", costoFinalEntrada=" + costoFinalEntrada +
                ", zona=" + zona +
                '}';
    }
}

class Zona {
    public String nombreZona;
    public int cantidadLocalidades;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombreZona, int cantidadLocalidades, double precioNormal, double precioAbonado) {
        this.nombreZona = nombreZona;
        this.cantidadLocalidades = cantidadLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "nombreZona='" + nombreZona + '\'' +
                ", cantidadLocalidades=" + cantidadLocalidades +
                ", precioNormal=" + precioNormal +
                ", precioAbonado=" + precioAbonado +
                '}';
    }
}
class EntradaNormal extends Entrada {

    public EntradaNormal(Zona zona, int idEntrada, String nombreComprador, int numeroEntradas) {
        super(zona, idEntrada, nombreComprador, numeroEntradas);
    }

    public double calcularCostoFinalEntrada() {
        costoFinalEntrada = numeroEntradas * zona.precioNormal;
        return costoFinalEntrada;
    }

    @Override
    public String toString() {
        return "EntradaNormal{" +
                "costoFinalEntrada=" + costoFinalEntrada +
                "} " + super.toString();
    }

}

class EntradaAbonado extends Entrada {

    public EntradaAbonado(Zona zona, int idEntrada, String nombreComprador, int numeroEntradas) {
        super(zona, idEntrada, nombreComprador, numeroEntradas);
    }

    public double calcularCostoFinalEntrada() {
        costoFinalEntrada = numeroEntradas * zona.precioAbonado;
        return costoFinalEntrada;
    }

    @Override
    public String toString() {
        return "EntradaAbonado{" +
                "costoFinalEntrada=" + costoFinalEntrada +
                "} " + super.toString();
    }

}
class EntradaReducida extends Entrada {

    private double descuento;

    public EntradaReducida(Zona zona,int idEntrada,String nombreComprador,int numeroEntradas,double descuento){
        super(zona,idEntrada,nombreComprador,numeroEntradas);
        this.descuento=descuento;
    }

    public double getDescuento(){
        return descuento;
    }

    public void setDescuento(double descuento){
        this.descuento=descuento;
    }

    public double calcularCostoFinalEntrada(){
        costoFinalEntrada=(numeroEntradas*zona.precioNormal)-((numeroEntradas*zona.precioNormal)*descuento/100);
        return costoFinalEntrada;
    }

    @Override
    public String toString(){
        return "EntradaReducida{"
                +"descuento="+descuento
                +", costoFinalEntrada="+costoFinalEntrada
                +"} "+super.toString();
    }

}
public class Problema_05_EjecutorTeatro {

    public static void main(String[] args) {

        Zona palco = new Zona("Palco",50,25.00,20.00);
        Zona platea = new Zona("Platea",100,18.00,15.00);

        EntradaNormal en1 = new EntradaNormal(
                palco,
                1,
                "Jose Mereci",
                2);

        EntradaReducida er1 = new EntradaReducida(
                platea,
                2,
                "Pablo Morales",
                3,
                15);

        EntradaAbonado ea1 = new EntradaAbonado(
                palco,
                3,
                "Jose Erique",
                4);

        en1.calcularCostoFinalEntrada();
        er1.calcularCostoFinalEntrada();
        ea1.calcularCostoFinalEntrada();

        System.out.println("=========== TEATRO ===========");
        System.out.println();

        System.out.println(en1);
        System.out.println("--------------------------------");

        System.out.println(er1);
        System.out.println("--------------------------------");

        System.out.println(ea1);

    }

}
/**
 * =========== TEATRO ===========

EntradaNormal{costoFinalEntrada=50.0} Entrada{idEntrada=1, nombreComprador=Jose Mereci, numeroEntradas=2, zona=Zona{nombreZona=Palco, cantidadLocalidades=50, precioNormal=25.0, precioAbonado=20.0}, costoFinalEntrada=50.0}
--------------------------------
EntradaReducida{descuento=15.0, costoFinalEntrada=45.9} Entrada{idEntrada=2, nombreComprador=Pablo Morales, numeroEntradas=3, zona=Zona{nombreZona=Platea, cantidadLocalidades=100, precioNormal=18.0, precioAbonado=15.0}, costoFinalEntrada=45.9}
--------------------------------
EntradaAbonado{costoFinalEntrada=80.0} Entrada{idEntrada=3, nombreComprador=Jose Erique, numeroEntradas=4, zona=Zona{nombreZona=Palco, cantidadLocalidades=50, precioNormal=25.0, precioAbonado=20.0}, costoFinalEntrada=80.0}
BUILD SUCCESSFUL (total time: 1 second)
 */