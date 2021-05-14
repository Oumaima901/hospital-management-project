package gest.hosp.web.controller.Docteur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gest.hosp.web.model.Docteur;

/**
 * Servlet implementation class ModifierSelectDoc
 */
@WebServlet("/ModifierSelectDoc")
public class ModifierSelectDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectDoc() {
        super();
        // TODO Auto-generated constructor stub
    }
    Statement st;
    Connection con;
    ResultSet rs;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionhopital"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    		st = con.createStatement();
    	}catch(Exception e) {
    		
    	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idd = request.getParameter("id");
		try{
			
			String req= "SELECT * FROM docteur where id='"+idd+"'";
			ResultSet rs = st.executeQuery(req);
            List<Docteur> listD = new ArrayList<Docteur>();

           while(rs.next()){
	                int id = rs.getInt("id");
	               String nom = rs.getString("nom");
	               String prenom = rs.getString("prenom");
	               String email = rs.getString("email");
	               String specialisation = rs.getString("specialisation");
	                String numero = rs.getString("numero_tel");
	               String adresse = rs.getString("adresse");
	              listD.add(new Docteur(id,nom,prenom,email,specialisation,numero,adresse));	

                  }

               request.setAttribute("listD", listD);
              request.getRequestDispatcher("/view/docteur/ModifierD.jsp").forward(request,response);


               } catch (SQLException e) {
            // TODO Auto-generated catch block
                   e.printStackTrace();
              }
                }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
