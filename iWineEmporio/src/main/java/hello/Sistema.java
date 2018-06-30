package hello;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Sistema {

	/*---------Import do Banco de Dados----------*/
	ObjectContainer products = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/products.db4o");
	ObjectContainer providers = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/providers.db4o");
	ObjectContainer users = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/users.db4o");
	ObjectContainer purchases = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/purchases.db4o");
	ObjectContainer adms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/adms.db4o");

	/*---------Declaração----------*/
	private List<Produto> produtos = new LinkedList<Produto>();
	private List<Usuario> usuarios = new LinkedList<Usuario>();

	/*---------Produtos----------*/
	public void addProduto(Produto prod) {
		if (isProuctAvailable(prod.getCodigoproduto())) {

			products.store(prod);
			products.commit();
			
		}
	}

	public void delProduto(int codigoproduto) {

		Query query = products.query();
		query.constrain(Produto.class);
		List<Produto> allProducts = query.execute();

		for (Produto prod : allProducts) {
			if (prod.getCodigoproduto() == codigoproduto)
				
				products.delete(prod);
				products.commit();
				
		}
	}

	public Produto searchProduto(int codigoproduto) {

		Query query = products.query();
		query.constrain(Produto.class);
		ObjectSet<Produto> allProducts = query.execute();

		for (Produto produto : allProducts) {
			if (produto.getCodigoproduto() == codigoproduto) {
				
				return produto;
				
			}
		}
		
		return null;
		
	}

	public boolean isProuctAvailable(int codigoproduto) {

		Query query = products.query();
		query.constrain(Produto.class);
		ObjectSet<Produto> allProducts = query.execute();

		for (Produto produto : allProducts) {
			if (produto.getCodigoproduto() == (codigoproduto))
				
				return false;
			
		}
		
		return true;
		
	}


	public boolean logarUsuario(String login, String senha) {

		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute();

		for (Usuario usuario : allUsers) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				
				return true;
				
			}
		}

		return false;
		
	}

	public boolean isUserAvailable(String login) {

		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute();

		for (Usuario usuario : allUsers) {
			if (usuario.getLogin() == login) {
				
				return false;
				
			}
		}
		return true;
	}

	/*---------Getters e setters----------*/
	public List<Produto> getProdutos() {
		Query query = products.query();
		query.constrain(Produto.class);
		List<Produto> todosProdutos = query.execute();
		
		return todosProdutos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Usuario> getUsuarios() {
		Query query = users.query();
		query.constrain(Usuario.class);
		List<Usuario> todosUsuarios = query.execute();
		
		return todosUsuarios;
	} 

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
