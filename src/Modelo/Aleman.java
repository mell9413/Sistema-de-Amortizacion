package Modelo;

public class Aleman extends Amortizacion {
    
//    public Aleman(DTOAmortizacion dtoAmortizacion){
//        super(DTOAmortizacion dtoAmortizacion);
//    }
    
    public Aleman(float montoPrestamo,int plazo,double interesAnual){
        super(montoPrestamo,plazo,interesAnual);
    }
    
    @Override
    public void calcularAmortizacion() {
        for (int i = 0; i < plazo; i++ ){
            montoAmortizacion =+ (montoPrestamo / plazo);
            resultadoAmortizaciones.add(montoAmortizacion);
        }
    }
    
    @Override
    public void calcularDeuda() {
        int periodoTranscurrido = 0;
        for(int i= 0 ;i <= plazo; i++) {
            montoDeuda =(((montoPrestamo / plazo ) *(plazo - periodoTranscurrido)));
            resultadoDeuda.add(montoDeuda);
            periodoTranscurrido++;
         }
   }
    
    @Override
    public void calcularInteresPeriodo() {
    	for( int i = 0; i < resultadoDeuda.size() ; i++){
            montoInteresPeriodo =+ resultadoDeuda.get(i) * (interesAnual * 0.01);
            resultadoInteres.add(montoInteresPeriodo);
    	}
    }
    
    @Override
    public void calcularCuota() {
        for (int i = 0; i < resultadoInteres.size(); i++){
            if (resultadoInteres.get(i) > 0){ //Aqui hay que ver esta validacion
                montoCuota =+ resultadoInteres.get(i) + montoAmortizacion;
                resultadoCuota.add(montoCuota);
            }
        }
    }
}