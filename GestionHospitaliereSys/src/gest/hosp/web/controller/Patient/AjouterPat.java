package gest.hosp.web.controller.Patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AjouterPat
 */
@WebServlet("/AjouterPat")
public class AjouterPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterPat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nom_pat = request.getParameter("txtnom");
		String prenom = request.getParameter("txtprenom");
		String email = request.getParameter("email");
		String numero = request.getParameter("numero");
		String adresse = request.getParameter("txtadresse");
		String nom = request.getParameter("txtdocteur");
		
		//creation session
		HttpSession session = request.getSession();

		if(session.getAttribute("login")==null){
			response.sendRedirect("./view/accueil/accueil.jsp");}
		else {
			try {
				String req = "INSERT INTO patient (nom_pat,prenom_pat,email_pat,numero_tel_pat,adresse_pat,id_doc) values ('"+nom_pat+"','"+prenom+"','"+email+"','"+numero+"','"+adresse+"','"+nom+"')"; 
		
				int rs = st.executeUpdate(req);
				out.print("<a href='./AffichagePat'>voir la liste</a>");
				out.print("Patient ajouter avec success");
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
