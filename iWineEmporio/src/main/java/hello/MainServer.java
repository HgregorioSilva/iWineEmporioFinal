package hello;

import static spark.Spark.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;


public class MainServer {
	
	final static Sistema sistema = new Sistema();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 12345;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarProdutos();
		inicializarUsuarios();
		
		Controller controller = new Controller(sistema);
		
		controller.addProduto();
		controller.delProduto();
		controller.buscarProdutoTodos();
		controller.buscarProduto();
		controller.logarUsuario();
    }
    
    public static void inicializarProdutos() {};
    public static void inicializarUsuarios() {};
    
}
