package Ejercicios1.EJ2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EJ2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el saldo actual: ");
            double saldo = sc.nextDouble();
            System.out.println("Introduce la cantidad a retirar: ");
            double cantidad = sc.nextDouble();

            if (cantidad > saldo) {
                throw new SaldoInsuficienteException(
                        "No hay saldo suficiente para retirar " + cantidad + "\n" + "Saldo actual: " + saldo);
            }
            saldo -= cantidad;
            System.out.println("Retirados " + cantidad + "EUR.\n" + "Saldo restante: " + saldo + "EUR.");

        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Solo puedes introducir numeros!");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error Inesperado! " + e.getMessage());
        } finally {
            System.out.println("Fin del programa.");
        }
    }
}
