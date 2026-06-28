/**
 * Problema 04: Sistema de nómina para trabajadores.
 * @author Jose Enrique Mereci Tapia
 * @version 2.0
 */

import java.util.ArrayList;

abstract class Trabajador{
    private String cedula;
    private String nombre;

    public Trabajador(String cedula,String nombre){
        this.cedula=cedula;
        this.nombre=nombre;
    }

    public String getCedula(){
        return cedula;
    }

    public void setCedula(String cedula){
        this.cedula=cedula;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public abstract double calcularPago();

    @Override
    public String toString(){
        return "Trabajador{"
                +"cedula="+cedula
                +", nombre="+nombre
                +'}';
    }
}

class Fijo extends Trabajador{
    private double sueldo;

    public Fijo(String cedula,String nombre,double sueldo){
        super(cedula,nombre);
        this.sueldo=sueldo;
    }

    public double getSueldo(){
        return sueldo;
    }

    public void setSueldo(double sueldo){
        this.sueldo=sueldo;
    }

    @Override
    public double calcularPago(){
        return sueldo;
    }

    @Override
    public String toString(){
        return "Fijo{"
                +"sueldo="+sueldo
                +"} "
                +super.toString();
    }
}

class Comisionista extends Trabajador{
    private double ventas;
    private double porcentaje;

    public Comisionista(String cedula,String nombre,double ventas,double porcentaje){
        super(cedula,nombre);
        this.ventas=ventas;
        this.porcentaje=porcentaje;
    }

    public double getVentas(){
        return ventas;
    }

    public void setVentas(double ventas){
        this.ventas=ventas;
    }

    public double getPorcentaje(){
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje){
        this.porcentaje=porcentaje;
    }

    @Override
    public double calcularPago(){
        return ventas*(porcentaje/100);
    }

    @Override
    public String toString(){
        return "Comisionista{"
                +"ventas="+ventas
                +", porcentaje="+porcentaje
                +"} "
                +super.toString();
    }
}
class PorHoras extends Trabajador{
    private int horas;
    private double valorHora;

    public PorHoras(String cedula,String nombre,int horas,double valorHora){
        super(cedula,nombre);
        this.horas=horas;
        this.valorHora=valorHora;
    }

    public int getHoras(){
        return horas;
    }

    public void setHoras(int horas){
        this.horas=horas;
    }

    public double getValorHora(){
        return valorHora;
    }

    public void setValorHora(double valorHora){
        this.valorHora=valorHora;
    }

    @Override
    public double calcularPago(){
        if(horas<=40){
            return horas*valorHora;
        }else{
            return (40*valorHora)+((horas-40)*valorHora*2);
        }
    }

    @Override
    public String toString(){
        return "PorHoras{"
                +"horas="+horas
                +", valorHora="+valorHora
                +"} "
                +super.toString();
    }
}

public class Problema_04_EjecutorNomina{

    public static void main(String[] args){

        ArrayList<Trabajador> trabajadores=new ArrayList<>();

        trabajadores.add(new Fijo(
                "1101234567",
                "Dario Mereci",
                850));

        trabajadores.add(new Comisionista(
                "1109876543",
                "Andre Tixe",
                5000,
                8));

        trabajadores.add(new PorHoras(
                "1104567890",
                "Raul",
                45,
                10));

        System.out.println("========== NOMINA ==========");

        for(Trabajador t:trabajadores){

            System.out.println("\n"+t);
            System.out.printf("Pago: $%.2f%n",t.calcularPago());

        }

    }

}
/**
 * ========== NOMINA ==========

Fijo{sueldo=850.0} Trabajador{cedula=1101234567, nombre=Dario Mereci}
Pago: $850,00

Comisionista{ventas=5000.0, porcentaje=8.0} Trabajador{cedula=1109876543, nombre=Andre Tixe}
Pago: $400,00

PorHoras{horas=45, valorHora=10.0} Trabajador{cedula=1104567890, nombre=Raul}
Pago: $500,00
BUILD SUCCESSFUL (total time: 0 seconds)

 */
Problema_02_Ejecutar_VideoClub