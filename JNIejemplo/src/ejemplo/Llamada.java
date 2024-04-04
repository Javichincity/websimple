package ejemplo;

public class Llamada {
	
	//Compilar el programa para generar el archivo.h de C
	//  javac -h . Llamada.java
	// NO TOCAR NADA en el archivo .h
	//Usar como cabecera de la funcion en C el prototipo que nos marca 
	
	//Aqui abajo cargamos la libreria .dll generada en C
	//En la ejecucion del archivo.class pasamos la ruta donde está la libreria
	// java -Djava.library.path=../ ejemplo.Llamada
	
	static {
		System.loadLibrary("llamada");
	}
	public static native void imprime_saludo(String src);

	public static void main(String[] args) {
		
		//Compruebaciones de ruta
		//En C "Ke paza pitxa", en Java "como va todo"
		//Salida "Ke paza pitxa como va todo"
		
		System.out.println("Hola");
		System.out.println(System.getProperty("java.library.path"));
		Llamada.imprime_saludo("como va todo");

		
	}

}
