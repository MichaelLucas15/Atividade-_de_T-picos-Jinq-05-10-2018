package br.edu.ifpe.jpa.example;

import java.util.Scanner;

public class App extends Function {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("");
			System.out.println(" __________________________________________-__________________________-_______________________________________");
			System.out.println("|__________________________________________-_Welcome to Function Menu_-_______________________________________|");
			System.out.println("|                                                                                                             |");
			System.out.println("|¬type it [1]  - To print on the screen all blogs that have an id greater than 10:                            |");
			System.out.println("|¬type it [2]  - To print on the screen the description of the blog that has the name(dia a dia, bit a bit):  |");
			System.out.println("|¬type it [3]  - To print on the screen the descriptions of the first 5 blogs created:                        |");
			System.out.println("|¬type it [4]  - To print on the screen the title and content of all blog posts:                              |");
			System.out.println("|¬type it [5]  - To print on screen the title of the last blog post with title (title):                       |");
			System.out.println("|¬type it [6]  - Exit the function menu                                                                       |");
			System.out.println(" -------------------------------------------------------------------------------------------------------------");

			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				questaoUm();
				break;
			case 2:
				questaoDois();
				break;
			case 3:
				questaoTres();
				break;
			case 4:
				questaoQuatro(null);
				break;
			case 5:
				questaoCinco(null);
				break;
			}
		} while (opcao <= 6);
	}
}
