/*
Autores:
Gerardo López Chacón
Valentín Ochoa López

 [*/
package Diagnostico;

/**
 *
 * @author val8a_000
 */
public class Secretaria extends Planta {

	public Secretaria( String nombre, String apellido, int antiguedad, boolean[] prestaciones, double pagoSemanal, String nombrePuesto) {
		super( nombre, apellido, antiguedad, pagoSemanal, prestaciones);  
		setNombrePuesto(nombrePuesto);
	}
   
   
   public String toString() {
		return "\n\n***  Secretaria  ***\n" + super.toString() + "\nSueldo integrado: " + this.sueldo();
	}
	
	
	public void setNombrePuesto(String nombre){
		this.nombrePuesto = nombre;
	}
	
	
	public String llenaRegistros() {
		return "llena los registros de los empleados del departamento";
	}
        
        public String getNombre(){
            return this.nombre;
        }
        public String getApellido(){
            return this.apellido;
        }
	
}
