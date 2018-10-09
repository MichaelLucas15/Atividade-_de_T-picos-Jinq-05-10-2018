package br.edu.ifpe.jpa.example;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.parsing.GenerationContext;
import org.jinq.jpa.JinqJPAStreamProvider;

import br.edu.ifpe.jpa.example.entities.Blog;
import br.edu.ifpe.jpa.example.entities.Post;

public class Function {
	
	static EntityManagerHelper helper = EntityManagerHelper.getInstance();
	
	// 1. Imprima na tela todos os blogs que possuem o id maior que 10
	public static void questaoUm() {
		helper.execute(Blog.class, streams ->{
			streams
				.where(b -> b.getIdentifier() > 10)
				.toList()
				.stream()
				.forEach(System.out::println);
		});

	}

	// 2. Imprima na tela a descrição do blog que possui o nome "dia a dia, bit a bit"
	public static void questaoDois() {
		helper.execute(Blog.class, streams ->{
			streams
				.where(b -> b.getName().equals("dia a dia, bit a bit"))
				.toList()
				.stream()
				.forEach(b -> System.out.println(b.getDescription()));
		});

	}

	// 3. Imprima na tela as decrições dos 5 primeiros blogs criados (considerar o atributo creationDate)
	public static void questaoTres() {
		helper.execute(Blog.class, streams ->{
			streams
				.sortedBy(b -> b.getCreationDate())
				.limit(5)
				.toList()
				.stream()
				.forEach(System.out::println);
		});
	}

	// 4. Imprima na tela o título e conteúdo de todos os posts do blog com título recebido como parâmetro, 
	//ordenados alfabeticamente pelo título do post
	public static void questaoQuatro(String titulo) {
		helper.execute(Post.class, streams ->{
			streams
				.where(b -> b.getTitle().equals(titulo))
				.toList()
				.stream()
				.forEach(p -> System.out.println(p.getTitle() +" - "+ p.getContent()));
				
		});
	}

	// 5. Imprima na tela o título do último post do blog com título "título"
	public static void questaoCinco(String titulo) {
		helper.execute(Post.class, streams ->{
			streams
				.where(b -> b.getBlog().getName().equals(titulo))
				.sortedDescendingBy(b -> b.getCreationDate())
				.limit(1)
				.toList()
				.stream()
				.forEach(p -> System.out.println(p.getTitle()));
		});
	}

	// 6. Retorne uma lista com os títulos de todos os posts publicados no blog com título tituloBlog 
	//entre o período dataInicial e dataFinal.
	public List<String> questaoSeis(Date dataInicial, Date dataFinal, String tituloBlog) {
		throw new UnsupportedOperationException();
	}

	// 7. Imprima na tela a média de posts existentes nos blogs
	public void questaoSete() {

	}
}
