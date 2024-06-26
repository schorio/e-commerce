package cn.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import cn.ecommerce.model.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/ajouter-au-panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			ArrayList<Panier> panierList = new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			Panier pm = new Panier();
			pm.setId_prd(id);
			pm.setQuantite(1);
			
			HttpSession session = request.getSession();
			ArrayList<Panier> panier_List = (ArrayList<Panier>) session.getAttribute("panier-list");
			
			if(panier_List == null) {
				panierList.add(pm);
				session.setAttribute("panier-list", panierList);
				response.sendRedirect("index.jsp");
			}
			
			else {
				panierList = panier_List;
				boolean exist = false;
				
				for (Panier _pm:panier_List) {
					if(_pm.getId_prd() == id) {
						exist = true;
						out.print("Produit exist deja");
					}
				}
				if (!exist) {
					panierList.add(pm);
					response.sendRedirect("index.jsp");
				}
			}
		}
		
	}

}
