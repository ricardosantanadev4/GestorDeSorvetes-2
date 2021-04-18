package dao;

import java.util.List;

public interface GestorSorveteGeralDAO {
	public List buscarTodos(Object obj);

	public void inserir(Object obj);

	public void remover(Class classe, Object primaryKey);
}
