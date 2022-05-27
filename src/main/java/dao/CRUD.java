package dao;

import java.util.List;

import model.Estudante;

public interface CRUD {
	
	public static void create(Estudante estudante) {};
	public static void delete(int estudanteId) {};
	public static List<Estudante> find(String pesquisa){return null;}
	public static Estudante findByPk(int estudanteId) {return null;}
	public static void update(Estudante estudante) {}
}