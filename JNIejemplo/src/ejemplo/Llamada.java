package ejemplo;

public class Llamada {
	public static native String imprime_saludo(String src);

	public static void main(String[] args) {
		
		Llamada.imprime_saludo("como va todo");
	}

}
