package br.edu.insper.desagil.PI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoTest 
{
	
	private Usuario usuario;
	private Produto produto1, produto2;
	private Video video1, video2;
	
	@BeforeEach
	public void init()
	{
		usuario = new Usuario("Davi");
		produto1 = new Produto("Cadeira Gamer", 407.97);
		produto2 = new Produto("Lustre", 300.56);
		video1 = usuario.postaVideo(1, produto1);
		video2 = usuario.postaVideo(2, produto2);
	}

	@Test
	public void test1() 
	{
		// adicinando avaliacao de quem postou o video:
		video1.adicionaAvaliacoes(usuario, 5);
		
		// adicionando avaliacao abaixo de 1:
		Usuario usuario1 = new Usuario("Nick");
		video1.adicionaAvaliacoes(usuario1, 0);
		
		// adicionando avaliacao acima de 5:
		Usuario usuario3 = new Usuario("Chico");
		video1.adicionaAvaliacoes(usuario3, 6);
		
		// soma das medias arredondadas:
		int sum = usuario.totalAvaliacoes();
		
		// valor esperado:
		int esperado = 0;
		
		// roda o teste:
		assertEquals(sum, esperado);
	}
	
	@Test
	public void test2() 
	{
		// adicionando uma avaliacao valida:
		Usuario usuario1 = new Usuario("Nick");
		video1.adicionaAvaliacoes(usuario1, 3);
		
		// soma das medias arredondadas:
		int sum = usuario.totalAvaliacoes();
		
		// valor esperado:
		int esperado = 3;
		
		// roda o teste:
		assertEquals(sum, esperado);
	}
	
	@Test
	public void test3() 
	{
		// adicionando duas avaliacao validas:
		Usuario usuario1 = new Usuario("Nick");
		video1.adicionaAvaliacoes(usuario1, 2);
		Usuario usuario2 = new Usuario("Chico");
		video1.adicionaAvaliacoes(usuario2, 5);
		
		// soma das medias arredondadas:
		int sum = usuario.totalAvaliacoes();
		
		// valor esperado:
		int esperado = 4;
		
		// roda o teste:
		assertEquals(sum, esperado);
	}
	
	@Test
	public void test4() 
	{
		// adicionando duas avaliacao validas:
		Usuario usuario1 = new Usuario("Nick");
		video1.adicionaAvaliacoes(usuario1, 2);
		Usuario usuario2 = new Usuario("Chico");
		video1.adicionaAvaliacoes(usuario2, 5);
		Usuario usuario3 = new Usuario("Berna");
		video1.adicionaAvaliacoes(usuario3, 3);
		
		// soma das medias arredondadas:
		int sum = usuario.totalAvaliacoes();
		
		// valor esperado:
		int esperado = 3;
		
		// roda o teste:
		assertEquals(sum, esperado);	
	}
	
	@Test
	public void test5() 
	{
		// adicionando duas avaliacao validas ao video1:
		Usuario usuario1 = new Usuario("Nick");
		video1.adicionaAvaliacoes(usuario1, 2);
		Usuario usuario2 = new Usuario("Chico");
		video1.adicionaAvaliacoes(usuario2, 5);
		
		// adicionando uma avaliacao valida ao video2:
		Usuario usuario3 = new Usuario("Berna");
		video2.adicionaAvaliacoes(usuario3, 3);
		
		// soma das medias arredondadas:
		int sum = usuario.totalAvaliacoes();
		
		// valor esperado:
		int esperado = 7;
		
		// roda o teste:
		assertEquals(sum, esperado);
	}

}
