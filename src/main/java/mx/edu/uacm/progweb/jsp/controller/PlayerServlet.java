package mx.edu.uacm.progweb.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.uacm.progweb.jsp.dto.Player;
import mx.edu.uacm.progweb.jsp.service.PlayerService;

/**
 * Clase controladora
 * @author sergio
 *
 */
@WebServlet(urlPatterns = "/player.do")
public class PlayerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PlayerService service = new 
			PlayerService();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recibir parametros
		String playerName = request.getParameter("name");
		String playerLastName = request.getParameter("lname");
		//reenviar el valor a traves de un atributo hacia la jsp
		request.setAttribute("name", playerName);
		request.setAttribute("lname", playerLastName);
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	    String playerName = request.getParameter("name");
	    Player player = service.getPlayerByName(playerName);
	    request.setAttribute("name", playerName);
	    request.setAttribute("country", player.getNationality());
	    request.setAttribute("dob", player.getBirthDate());
	    request.setAttribute("titles", player.getTitles());


		request.getRequestDispatcher("/WEB-INF/views/info.jsp").forward(request, response);
	}
}
