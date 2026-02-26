abstract class MetodoPago {
    String titular; // mala práctica: campo sin privacidad
    abstract boolean procesarPago(double importe);
}

class TarjetaCredito extends MetodoPago {
    String numeroTarjeta; // mala práctica: sin private
    double limiteDisponible;
    
    boolean validarTarjeta() {
        return true; 
    }
    
    String obtenerUltimos4Digitos() {
        // mala práctica: asume que siempre tiene 4 o más caracteres
        return numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }
    
    boolean procesarPago(double importe) {
        if (importe <= limiteDisponible) {
            limiteDisponible = limiteDisponible - importe;
            return true;
        }
        return false;
    }
}

class Paypal extends MetodoPago {
    String email;
    double saldoDisponible;
    
    boolean validarCuenta() {
        return true;
    }
    
    String obtenerEmail() {
        return email;
    }
    
    boolean procesarPago(double importe) {
        if (importe <= saldoDisponible) {
            saldoDisponible = saldoDisponible - importe;
            return true;
        } else {
            return false;
        }
    }
}

class TransferenciaBancaria extends MetodoPago {
    String iban;
    String banco;
    double saldoCuenta;
    
    boolean validarIBAN() {
        return true;
    }
    
    boolean procesarPago(double importe) {
        if (saldoCuenta >= importe) {
            saldoCuenta = saldoCuenta - importe;
            saldoCuenta = saldoCuenta - (importe * 0.02); // comision del 2%
            return true;
        } else {
            return false;
        }
    }
}

public class App {
    
    // malas prácticas: variables estáticas globales para contar
    static int numAprobados = 0;
    static int numRechazados = 0;
    static int cantTarjeta = 0;
    static int cantPaypal = 0;
    static int cantTransferencia = 0;

    public static void ejecutarPago(MetodoPago metodo, double importe) {
        // comprobamos tipo real usando instanceof
        if (metodo instanceof TarjetaCredito) {
            System.out.println("El tipo es: Tarjeta de Crédito");
            TarjetaCredito t = (TarjetaCredito) metodo; // casting
            t.validarTarjeta();
            System.out.println("Últimos 4 dígitos: " + t.obtenerUltimos4Digitos());
            cantTarjeta = cantTarjeta + 1;
        }
        if (metodo instanceof Paypal) {
            System.out.println("El tipo es: Paypal");
            Paypal p = (Paypal) metodo; // casting
            p.validarCuenta();
            System.out.println("Email: " + p.obtenerEmail());
            cantPaypal = cantPaypal + 1;
        }
        if (metodo instanceof TransferenciaBancaria) {
            System.out.println("El tipo es: Transferencia Bancaria");
            TransferenciaBancaria tb = (TransferenciaBancaria) metodo; // casting
            tb.validarIBAN();
            System.out.println("Banco: " + tb.banco);
            cantTransferencia = cantTransferencia + 1;
        }
        
        // Intentar procesar y recoger el resultado
        boolean resultado = metodo.procesarPago(importe);
        
        // mala práctica: if (booleano == true)
        if (resultado == true) {
            System.out.println("El pago fue aprobado.");
            numAprobados = numAprobados + 1;
        }
        if (resultado == false) {
            System.out.println("El pago fue rechazado.");
            numRechazados = numRechazados + 1;
        }
    }
    
    public static void main(String[] args) {
        // crear objetos a mano
        TarjetaCredito t1 = new TarjetaCredito();
        t1.titular = "Juan Perez";
        t1.numeroTarjeta = "1234567890123456";
        t1.limiteDisponible = 500.0;
        
        Paypal p1 = new Paypal();
        p1.titular = "Maria Gomez";
        p1.email = "maria@correo.com";
        p1.saldoDisponible = 100.0;
        
        TransferenciaBancaria b1 = new TransferenciaBancaria();
        b1.titular = "Pedro Lopez";
        b1.iban = "ES12345678901234567890";
        b1.banco = "Bankia";
        b1.saldoCuenta = 1000.0;
        
        // Crear array con diferentes métodos
        MetodoPago[] pagos = new MetodoPago[3];
        pagos[0] = t1;
        pagos[1] = p1;
        pagos[2] = b1;
        
        // Procesar todos los pagos del array
        for (int i = 0; i < pagos.length; i = i + 1) {
            System.out.println("--- Procesando pago [" + i + "] ---");
            ejecutarPago(pagos[i], 200.0);
        }
        
        System.out.println("\n--- Resumen Final ---");
        System.out.println("Total procesado correctamente: " + numAprobados);
        System.out.println("Total rechazado: " + numRechazados);
        System.out.println("Pagos procesados por tipo Tarjeta: " + cantTarjeta);
        System.out.println("Pagos procesados por tipo Paypal: " + cantPaypal);
        System.out.println("Pagos procesados por tipo Transferencia: " + cantTransferencia);
    }
}
