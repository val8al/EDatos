/*
Autores:
Gerardo López Chacón
Valentín Ochoa López

 [*/
package Diagnostico;
public abstract class Planta extends Empleado {

	protected double pagoSemanal;
	protected boolean[] prestaciones;
	protected double diaVacaciones;
	protected String nombrePuesto;
	
	private static final String [] PRESTACIONES = {"Vales despensa", "Afore", "Infonavit", "Vacaciones Semana Santa", 
				"Vacaciones Verano", "Descuento proveedores afiliados", "Seguro de auto", "Seguro de vida"}; 
	private static final double [] PAGO_PRESTACIONES = {1000, 0.2, 0.1, 7, 2, 0.25, 5000, 25000}; 				 
	private static final double PORCENTAJE_PLANTA = 0.1;			
	private static final int MAXIMO_SUELDO = 25000;
	
	

	public Planta( String nombre, String apellido, int antiguedad, double pagoSemanal, boolean[] prestaciones) {
		super(nombre, apellido, antiguedad);
                this.prestaciones=prestaciones;
                if (pagoSemanal>0&&pagoSemanal<MAXIMO_SUELDO){
                    this.pagoSemanal=pagoSemanal;
                }
                else{
                    this.pagoSemanal=0;        
                            }
                this.diaVacaciones=this.pagoSemanal*this.antiguedad*PORCENTAJE_PLANTA;
        }
		/*
		 * TODO: 
		 * Constructor de la clase Planta.
		 * 1. Inicializa el atributo  de instancia del arreglo de prestaciones con los valores
		 *    del arreglo de prestaciones que recibe de parámetro.
		 * 2. Valida que el atributo de instancia, pagoSemanal, se inicialice con un valor entre 0 y MAXIMO_SUELDO.
		 *    En caso contrario, se asigna 0.
		 * 3. El atributo de instancia, diaVacaciones, se inicializa con el pagoSemanal * antiguedad * PORCENTAJE_PLANTA. 
		 */
	
   
   
    private String regresaPrestaciones() {
    	/*
    	 * TODO: 
    	 * Método privado que recorre el arreglo de instancia de prestaciones y si tiene un valor de true en la posición i,
    	 * entonces crea una cadena con el nombre de la prestación correspondiente. Los nombres de las prestaciones están en
    	 * el arreglo estático PRESTACIONES, en la misma posición i. Así, si prestaciones[0] = true, entonces la prestación
    	 * correspondiente es PRESTACIONES[0] (que es “Vales despensa”).
    	 */
        String str=""; 
    	for(int i=0;i<this.prestaciones.length;i++){
            if(prestaciones[i]){
                str=str+PRESTACIONES[i]+" ";
            }
        }
    	return str;
    }
	
	
	public double sueldo() { 
		
                double sueldito=this.pagoSemanal; 
		for(int i=0;i<this.prestaciones.length;i++ ){
                    switch(i){
                        case 0: case 6: case 7:
                            if(this.prestaciones[i]){
                                sueldito=sueldito+PAGO_PRESTACIONES[i];
                                break;
                            }
                        case 1: case 2: case 5:
                            if(this.prestaciones[i]){                              
                                sueldito=sueldito+(PAGO_PRESTACIONES[i]*this.pagoSemanal);
                                break;
                            }
                        case 3: case 4:
                            if(this.prestaciones[i]){                               
                                sueldito=sueldito+(PAGO_PRESTACIONES[i]*this.diaVacaciones);
                                break;
                            }
                        default:
                            
                            
                    }
                }    
                    
                
		return sueldito;
	}
	
    public void setPagoSemanal( double pagoSemanal ) { 
		if (pagoSemanal > 0 && pagoSemanal <= MAXIMO_SUELDO)
			this.pagoSemanal = pagoSemanal;
	}
   
   	public String toString() {
		return "\n***  Empleado de Planta  ***\n" + super.toString() + "\nCon puesto: " + this.getNombrePuesto() +
				"\nPago semanal: " + this.pagoSemanal + "\nSueldo integrado: " + this.sueldo() + "\nPrestaciones: " + this.regresaPrestaciones();
	}
	
	public String getNombrePuesto() {
		return this.nombrePuesto;
	}
	
	/*
	 * TODO:
	 * Crear método público abstracto de nombre setNombrePuesto.
	 * El método no regresa nada.
	 * El método recibe una cadena de caracteres con el nombre del puesto (nombrePuesto).
	 */
        public abstract void setNombrePuesto(String nombrePuesto);
    

}