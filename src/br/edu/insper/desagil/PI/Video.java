package br.edu.insper.desagil.PI;

import java.util.HashMap;
import java.util.Map;

public class Video 
{
	
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	
	public Video(int id, Usuario usuario, Produto produto) 
	{
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}


	public int getId() 
	{
		return this.id;
	}


	public Produto getProduto() 
	{
		return this.produto;
	}
	
	public void adicionaAvaliacoes(Usuario usuario, int val)
	{
		if ((usuario.getNome() != this.usuario.getNome()) && ((val >= 1) && (val <= 5)))
		{
			this.avaliacoes.put(usuario.getNome(), val);
		}
	}
	
	public int mediaAvaliacoes() 
	{
		float sum = 0;
		float count = 0;
		for (int val : this.avaliacoes.values())
		{
			sum += val;
			count += 1;
		}
		int mean = Math.round(sum/count);
		return mean;
	}
	
}
