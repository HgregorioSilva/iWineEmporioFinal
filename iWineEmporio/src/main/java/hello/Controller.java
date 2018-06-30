package hello;

import static spark.Spark.get;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Sistema sistema;
	
	public Controller(Sistema sistema)
	{
		this.sistema = sistema;
	}
	
	/*---------Produtos----------*/
	public void addProduto()
	{
		get("/estoqueProdAdd/:nome/:valorcompra/:codigoproduto/:descricao/:quantidade/:datacad", (req, res) ->
		{
			String dataString = req.params(":datacad");
	    	String[] dataSeparada = dataString.split(" ");
	    	LocalDate data = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
			Produto prod = new Produto(req.params(":nome"), Float.parseFloat(req.params(":valorcompra")), Integer.parseInt(req.params(":codigoproduto")), req.params(":descricao"), Integer.parseInt(req.params(":quantidade")), data);
			sistema.addProduto(prod);
			return "";
		});
	}
	public void delProduto()
	{
		get("/estoqueProdDel/:codigoproduto", (req, res) ->
		{
			sistema.delProduto(Integer.parseInt(req.params(":codigoproduto")));
			return "";
		});
	}
	public void buscarProdutoTodos()
	{
		get("/estoqueProdBuscarTodos/", (req, res) ->
		{
			List<Produto> todosProdutos = sistema.getProdutos();
			return new Gson().toJson(todosProdutos);
		});
	}
	public void buscarProduto()
	{
		get("/estoqueProdBuscar/:codigoproduto", (req, res) ->
		{
			Produto produtoEncontrado = sistema.searchProduto(Integer.parseInt(req.params(":codigoproduto")));
			return new Gson().toJson(produtoEncontrado);
		});
	}
	
	public void logarUsuario()
	{
		get("/estoqueUsuaLogar/:login/:senha", (req, res) ->
		{
			boolean verificacao = sistema.logarUsuario(req.params(":login"), req.params(":senha"));
			if(verificacao == true)
				return true;
			else
				return false;
		});
	}
}
