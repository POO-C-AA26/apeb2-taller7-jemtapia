/**
 * Problema 06: Sistema UN Banco
 * @author Jose Enrique
 * @version 1.0
 */

abstract class Cuenta {

    protected String numeroCuenta;
    protected String nombreCliente;
    protected double balance;

    public Cuenta(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0;
    }

    public void depositar(double monto) {
        balance += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= balance) {
            balance -= monto;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void calcularInteres();

    @Override
    public String toString() {
        return "Cuenta{"
                + "numeroCuenta=" + numeroCuenta
                + ", nombreCliente=" + nombreCliente
                + ", balance=" + balance
                + '}';
    }

}
class CuentaCheques extends Cuenta {

    public double sobregiro;

    public CuentaCheques(String numeroCuenta, String nombreCliente, double sobregiro) {
        super(numeroCuenta, nombreCliente);
        this.sobregiro = sobregiro;
    }

    @Override
    public boolean retirar(double monto) {

        if (balance + sobregiro >= monto) {
            balance -= monto;
            return true;
        }

        return false;
    }

    @Override
    public void calcularInteres() {
        // Las cuentas de cheques no generan interés
    }

    @Override
    public String toString() {
        return "CuentaCheques{"
                + "sobregiro=" + sobregiro
                + "} "
                + super.toString();
    }

}
class CuentaAhorros extends Cuenta {

    public double tasaInteres;

    public CuentaAhorros(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = 0.05; // 5%
    }

    @Override
    public boolean retirar(double monto) {

        if (monto <= balance) {
            balance -= monto;
            return true;
        }

        return false;
    }

    @Override
    public void calcularInteres() {
        balance = balance + (balance * tasaInteres);
    }

    @Override
    public String toString() {
        return "CuentaAhorros{"
                + "tasaInteres=" + tasaInteres
                + "} "
                + super.toString();
    }

}
class CuentaPlatino extends Cuenta {

    public double tasaInteres;

    public CuentaPlatino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = 0.10; // 10%
    }

    @Override
    public boolean retirar(double monto) {

        if (monto <= balance) {
            balance -= monto;
            return true;
        }

        return false;
    }

    @Override
    public void calcularInteres() {
        balance = balance + (balance * tasaInteres);
    }

    @Override
    public String toString() {
        return "CuentaPlatino{"
                + "tasaInteres=" + tasaInteres
                + "} "
                + super.toString();
    }

}
public class Problema_06_EjecutorBanco {

    public static void main(String[] args) {

        CuentaCheques cuenta1 = new CuentaCheques(
                "001",
                "Jose Mereci",
                300);

        CuentaAhorros cuenta2 = new CuentaAhorros(
                "002",
                "Maria Lopez");

        CuentaPlatino cuenta3 = new CuentaPlatino(
                "003",
                "Mateo Jaramillo");

        cuenta1.depositar(1000);
        cuenta2.depositar(2000);
        cuenta3.depositar(5000);
        cuenta1.retirar(1200);
        cuenta2.retirar(500);
        cuenta3.retirar(1000);
        cuenta1.calcularInteres();
        cuenta2.calcularInteres();
        cuenta3.calcularInteres();
        System.out.println("========== CUENTA CHEQUES ==========");
        System.out.println(cuenta1);
        System.out.println("Balance Final: $" + cuenta1.getBalance());

        System.out.println();

        System.out.println("========== CUENTA AHORROS ==========");
        System.out.println(cuenta2);
        System.out.println("Balance Final: $" + cuenta2.getBalance());

        System.out.println();

        System.out.println("========== CUENTA PLATINO ==========");
        System.out.println(cuenta3);
        System.out.println("Balance Final: $" + cuenta3.getBalance());

    }

}
/**
 * run:
========== CUENTA CHEQUES ==========
CuentaCheques{sobregiro=300.0} Cuenta{numeroCuenta=001, nombreCliente=Jose Mereci, balance=-200.0}
Balance Final: $-200.0

========== CUENTA AHORROS ==========
CuentaAhorros{tasaInteres=0.05} Cuenta{numeroCuenta=002, nombreCliente=Maria Lopez, balance=1575.0}
Balance Final: $1575.0

========== CUENTA PLATINO ==========
CuentaPlatino{tasaInteres=0.1} Cuenta{numeroCuenta=003, nombreCliente=Mateo Jaramillo, balance=4400.0}
Balance Final: $4400.0
BUILD SUCCESSFUL (total time: 0 seconds)
 */
