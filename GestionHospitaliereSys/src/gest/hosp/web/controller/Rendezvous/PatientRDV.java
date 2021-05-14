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

import gest.hosp.web.model.Docteur;
import gest.hosp.web.model.Patient;

/**
 * Servlet implementation class PatientRDV
 */
@WebServlet("/PatientRDV")
public class PatientRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRDV() {
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
		try {
			String req = "select * from  patient ";
			ResultSet rs = st.executeQuery(req);
			List<Patient> listpat = new ArrayList<Patient>();
			
			while(rs.next()){
				int id = rs.getInt("id_pat");
				String nom_pat = rs.getString("nom_pat");
				String prenom = rs.getString("prenom_pat");
				String email = rs.getString("email_pat");
				String numero = rs.getString("numero_tel_pat");
				String adresse = rs.getString("adresse_pat");
				String nom = rs.getString("id_doc");
				listpat.add(new Patient(id,nom_pat,prenom,email,numero,adresse,nom));	
			
			}
			
		request.setAttribute("listpat", listpat);
		request.getRequestDispatcher("/view/Rendezvous/AjouterRV.jsp").forward(request,response);
		
		
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
