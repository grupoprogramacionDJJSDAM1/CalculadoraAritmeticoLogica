
/* Enunciado: Calculadora de operaciones modularizada.
 * Fecha: 10/11/21
 * Autor: Jaime Fernando Martín Gil.
 * Comentarios: -Metodo menu() no devuelve nada ni tiene parametros. 
 * -Metodo pintarOpcionesMenu() no devuelve nada ni tiene parametros. 
 *-Metodo suma(), resta(), multiplicacion() y division() con dos variables por parametro (numero1 y numero2) 
 * y devuelve un double.
 * -Metodo pedirDatos() que es interactivo y no devuelve nada ni tiene parametros y un main.
 *  
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
	private static boolean salirBucle=false;  //	var bandera para salir de los menú
	private static boolean salirBucleLogico=false;  //	var bandera para salir de los menú
	private static int numero1; //numero1 con el que quiere operar el usuario
	private static int numero2; //numero2 con el que quiere operar el usuario
	private static boolean valorlogico1; //valor logico1 (true o false) con el que quiere operar el usuario
	private static boolean valorlogico2;//valor logico2 (true o false) con el que quiere operar el usuario
	static Scanner teclado = new Scanner(System.in);


	public static void main(String[] args) {
		menu();
	}

	//PEDIR DATOS ARITMÉTICOS
	
	public static void pedirDatos() { // Metodo que pide datos al usuario
		System.out.println("Introduce el numero1 con el que quiere operar: ");
		numero1 = teclado.nextInt(); // recoge el numero1
		System.out.println("Introduce el numero2 con el que quiere operar : ");
		numero2 = teclado.nextInt(); // recoge el numero2
	}

	//PEDIR DATOS LOGICOS
	
	public static void pedirDatosLogicos() {
		
		System.out.println("Introduce true o false ");
		System.out.println("Introduce el primer valor con el que quieres operar:");
		valorlogico1 = teclado.nextBoolean(); // recoge el primer valor 
		System.out.println("Introduce el segundo valor con el que quieres operar:");
		valorlogico2 = teclado.nextBoolean(); // recoge el segundo valor
		
	}
	
	//PINTAR MENÚ PRINCIPAL
	
	public static void pintarMenuPrincipal(){
		System.out.println("\n*********************************************");
		System.out.println("*-------------MENÚ PRINCIPAL----------------*");
		System.out.println("*-------1. Operaciones Aritméticas----------*");
		System.out.println("*-------2. Operaciones Lógicas--------------*");
		System.out.println("*-------3. Salir programa-------------------*");
		System.out.println("*********************************************");
		
		System.out.println("\n Elige una opcion del 1 al 3: ");
	}
	
	//PINTAR MENÚ LOGICAS
	
	public static void pintarMenuLogicas() {
		System.out.println("\n**************************************************");
		System.out.println("*-------------OPERACIONES LÓGICAS----------------*");
		System.out.println("*--------------1. AND----------------------------*");
		System.out.println("*--------------2. OR-----------------------------*");
		System.out.println("*--------------3. NOT----------------------------*");
		System.out.println("*--------------4. XOR----------------------------*");
		System.out.println("*--------------5. Volver al menu principal-------*");
		System.out.println("*--------------6. Salir--------------------------*");
		System.out.println("**************************************************");

		System.out.println("\n Elige una opcion del 1 al 6: ");
	}

	//PINTAR MENU ARITMETICAS
	
	public static void pintarOpcionesAritmeticas() {// Metodo que pinta las opciones del menú de las operaciones aritméticas
		System.out.println("\n*-----------------------------------------------*");
		System.out.println("*------------OPERACIONES ARITMÉTICAS-------------*");
		System.out.println("*--------------1. Sumar--------------------------*");
		System.out.println("*--------------2. Restar-------------------------*");
		System.out.println("*--------------3. Multiplicar--------------------*");
		System.out.println("*--------------4. Dividir------------------------*");
		System.out.println("*--------------5. Volver menú principal----------*");
		System.out.println("*--------------6. Salir--------------------------*");
		System.out.println("*------------------------------------------------*");

		System.out.println("\n Elige una opcion del 1 al 6: ");
	}

	public static void menu() {
	int opcion;
	int opcion2;
	
	do {
	try {
		pintarMenuPrincipal();
		opcion = teclado.nextInt(); //lee la opcion del usuario
		
		switch (opcion) {
		case 1:
			System.out.println("Has elegido el menú de las operaciones aritméticas. ");
			pintarOpcionesAritmeticas();
			opcion2= teclado.nextInt();
				switch (opcion2) {
				case 1:
					System.out.println("Has elegido la suma. ");
					pedirDatos(); // llamada al metodo que pide datos al usuario
					System.out.println("El resultado es " + suma(numero1, numero2)); // realiza la suma con los numeros que ha introducido el usuario
					menu();
					break;
				case 2:
					System.out.println("Has elegido la resta.");
					pedirDatos();
					System.out.println("El resultado es " + resta(numero1, numero2)); // realiza la resta con los números que ha introducido el usuario
					break;
				case 3:
					System.out.println("Has elegido la multiplicacion. ");
					pedirDatos();
					System.out.println("El resultado es " + multiplicacion(numero1, numero2)); // realiza la multiplicación con los números que ha introducido el usuario
					break;
				case 4:
					
					System.out.println("Has elegido la division.");
					pedirDatos();
					try {//try catch para controlar division por 0
					System.out.println("El resultado es " + division(numero1, numero2));// realiza la división con los números que ha introducido el usuario
					}catch(ArithmeticException e ) {
						System.out.println("No se puede dividir por 0");
					}
					break;
				case 5:
					pintarMenuPrincipal();
					break;
				case 6:
					System.out.println("Has elegido salir del programa ");
					System.out.println("Se ha salido del programa correctamente");
					salirBucle = true; // salirBucle a true para que salga del bucle
					break;
				 default:
	                   System.out.println("Solo números entre 1 y 6");
			}
			break;
		case 2:
			System.out.println("Has elegido el menú de las operaciones lógicas.");
			while(!salirBucleLogico) {
			pintarMenuLogicas();
			int opcion3=teclado.nextInt();
			switch (opcion3) {
			case 1:
				System.out.println("Has elegido la operacion logica and. ");
				try {
				 pedirDatosLogicos(); // llamada al metodo que pide datos logicos al usuario
				System.out.println("El resultado es " + and(valorlogico1, valorlogico2)); // realiza la operacion AND
				}catch(InputMismatchException e){
					System.out.println("Error!! solo true o false !!");
					teclado.next();
				}
				menu();
				break;
			case 2:
				System.out.println("Has elegido la operacion logica or.");
				try { 
				pedirDatosLogicos();
				System.out.println("El resultado es " + or(valorlogico1, valorlogico2)); // realiza la operacion OR
			}catch(InputMismatchException e){
				System.out.println("Error!! solo true o false !!");
				teclado.next();
			}
				menu();
				break;
			case 3:
				System.out.println("Has elegido la operacion logica not. ");
				try {
				pedirDatosLogicos();
				System.out.println("El resultado es " + not(valorlogico1)); // realiza la operacion NOT
			}catch(InputMismatchException e){
				System.out.println("Error!! solo true o false !!");
				teclado.next();
			}
				menu();
				break;
			case 4:
				System.out.println("Has elegido la operacion logica xor.");
				try { 
				pedirDatosLogicos();
				System.out.println("El resultado es " + xor(valorlogico1, valorlogico2));// realiza la operacion XOR
				}catch(InputMismatchException e){
					System.out.println("Error!! solo true o false !!");
					teclado.next();
				}
				menu();
				break;
			case 5:
				System.out.println("Has elegido salir del programa ");
				System.out.println("Se ha salido del programa correctamente");
				 salirBucleLogico = true; // salirBucle a true para que salga del bucle
				menu();
				break;
			 default:
                 System.out.println("Solo números entre 1 y 5");
		}
			}
		case 3:
			System.out.println("Has elegido salir del programa ");
			System.out.println("Se ha salido del programa correctamente");
			salirBucle = true; // salirBucle a true para que salga del bucle
			menu();
			break;
			default: 
				System.out.println("Solo numeros del 1 al 3!");
		}
		} catch(InputMismatchException e) { //cuando el dato introducido no es el esperado
			System.out.println("Error!! Solo se admiten numeros!!! ");
			teclado.next();
		}
	}while (salirBucle == false);
		
	}
	
//MÉTODOS OPERACIONES ARITMÉTICAS 
	public static double suma(int numero1, int numero2) {
		return (numero1 + numero2);
	}

	public static double resta(int numero1, int numero2) {
		return (numero1 - numero2);
	}

	public static double multiplicacion(int numero1, int numero2) {
		return (numero1 * numero2);
	}

	public static double division(int numero1, int numero2) {

		return (numero1 / numero2);

	}

	//MÉTODOS OPERACIONES LÓGICAS 
		public static boolean and(boolean valorlogico1, boolean valorlogico2) {
			return (valorlogico1 && valorlogico2) ;
			
		}
		public static boolean or(boolean valorlogico1, boolean valorlogico2) {
			return (valorlogico1 || valorlogico2) ;
			
		}
		public static boolean not(boolean valorlogico1) {
			return (!valorlogico1);
			
		}
		public static boolean xor(boolean valorlogico1, boolean valorlogico2) {
			return (valorlogico1 ^ valorlogico2) ;
			
		}

}