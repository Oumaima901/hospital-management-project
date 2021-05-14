package gest.hosp.web.controller.Rendezvous;

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
import javax.servlet.http.HttpSession;

import gest.hosp.web.model.Patient;
import gest.hosp.web.model.RendezVous;



/**
 * Servlet implementation class ModifierSelectRDV
 */
@WebServlet("/ModifierSelectRDV")
public class ModifierSelectRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectRDV() {
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
		HttpSession session = request.getSession();
		String idd = request.getParameter("id_RV");
		String req = "select * from  patient ";
		try {
			ResultSet rs = st.executeQuery(req);
			List<Patient> listPat = new ArrayList<Patient>();
			
			while(rs.next()){
				int id = rs.getInt("id_pat");
				String nom_pat = rs.getString("nom_pat");
				String prenom = rs.getString("prenom_pat");
				String email = rs.getString("email_pat");
				String numero = rs.getString("numero_tel_pat");
				String adresse = rs.getString("adresse_pat");
				String nom = rs.getString("id_doc");
				listPat.add(new Patient(id,nom_pat,prenom,email,numero,adresse,nom));	
			
			}
		String req1 = "select id_RV,date_Rdv,heure_Rdv,nom_pat from  rendezvous INNER JOIN patient ON(rendezvous.id_p = patient.id_pat)where  id_RV='"+idd+"'";
		ResultSet rs1 = st.executeQuery(req1);
		List<RendezVous> listRDV = new ArrayList<RendezVous>();
		
		while(rs1.next()){
			int id = rs1.getInt("id_RV");
			String date = rs1.getString("date_Rdv");
			String heure = rs1.getString("heure_Rdv");
			String nom_pat = rs1.getString("nom_pat");
			listRDV.add(new RendezVous(id,date,heure,nom_pat));	
		
		}
     session.setAttribute("listPat", listPat);
	session.setAttribute("listRDV", listRDV);
	request.getRequestDispatcher("/view/Rendezvous/ModifierRV.jsp").forward(request,response);
	
	
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
