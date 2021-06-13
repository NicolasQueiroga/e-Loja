package br.edu.insper.desagil.PI;

import java.util.ArrayList;
import java.util.List;

public class Usuario 
{
	
	private String nome;
	private List<Video> videos;
	
	
	public Usuario(String nome) 
	{
		this.nome = nome;
		this.videos = new ArrayList<>();
	}


	public String getNome() 
	{
		return this.nome;
	}
	
	
	public Video postaVideo(int id, Produto produto)
	{
		Video video = new Video(id, this, produto);
		this.videos.add(video);
		return video;
	}
	
	public int totalAvaliacoes()
	{
		int sum = 0;
		for (Video vid : this.videos)
		{
			sum += vid.mediaAvaliacoes();
		}
		return sum;
	}
	
}
