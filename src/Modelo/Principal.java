
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aleman AmortizacionAlemana1 = new Aleman();
		
		AmortizacionAlemana1.monto_prestamo = 1000000;
		AmortizacionAlemana1.plazo = 5;
		AmortizacionAlemana1.interes_anual = 15;

		AmortizacionAlemana1.calcularAmortizacion();
		AmortizacionAlemana1.calcularDeuda();
		AmortizacionAlemana1.calcularInteresPeriodo();
		AmortizacionAlemana1.calcularCuota();
		
		Frances  AmortizacionFr = new Frances();
		AmortizacionFr.monto_prestamo = 1000000;
		AmortizacionFr.plazo = 5;
		AmortizacionFr.interes_anual = 15;
	//	AmortizacionFr.setFactorAnualidad(0.2893);
		AmortizacionFr.calcularCuota();
		AmortizacionFr.calcularAmortizacion();
		AmortizacionFr.calcularDeuda();
		AmortizacionFr.calcularInteresPeriodo();
		
		Americano  AmortizacionAm = new Americano();
		AmortizacionAm.monto_prestamo = 1000000;
		AmortizacionAm.plazo = 5;
		AmortizacionAm.interes_anual = 15;
		AmortizacionAm.calcularInteresPeriodo();
		AmortizacionAm.calcularCuota();
		AmortizacionAm.calcularAmortizacion();
		AmortizacionAm.calcularDeuda();
		
	//	System.out.println(AmortizacionAlemana1.getDeudas());
	//	System.out.println(AmortizacionAlemana1.getCuotas());
	//	System.out.println(AmortizacionAlemana1.getInteresPeriodo());
	//	System.out.print(AmortizacionAlemana1.getAmortizacion());
		
		

	}

}
