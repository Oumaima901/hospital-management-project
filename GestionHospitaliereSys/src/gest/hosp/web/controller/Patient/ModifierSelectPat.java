package gest.hosp.web.controller.Patient;

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
 * Servlet implementation class ModifierSelectPat
 */
@WebServlet("/ModifierSelectPat")
public class ModifierSelectPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSelectPat() {
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
		String idd = request.getParameter("id_pat");
		String req = "select * from docteur";
		try {
			ResultSet rs = st.executeQuery(req);
			List<Docteur> listDoc = new ArrayList<Docteur>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String specialisation = rs.getString("specialisation");
				String numero = rs.getString("numero_tel");
				String adresse = rs.getString("adresse");
				listDoc.add(new Docteur(id,nom,prenom,email,specialisation,numero,adresse));	
			
			}
		
			
			String req1= "select id_pat,nom_pat,prenom_pat,email_pat,numero_tel_pat,adresse_pat,nom  from  patient INNER JOIN docteur ON(docteur.id=patient.id_doc) where  id_pat='"+idd+"'";
			ResultSet rs1 = st.executeQuery(req1);
            List<Patient> listpa = new ArrayList<Patient>();

           while(rs1.next()){
	                int id = rs1.getInt("id_pat");
	               String nom_pat = rs1.getString("nom_pat");
	               String prenom = rs1.getString("prenom_pat");
	               String email = rs1.getString("email_pat");
	                String numero = rs1.getString("numero_tel_pat");
	               String adresse = rs1.getString("adresse_pat");
	               String nom = rs1.getString("nom");  
	               listpa.add(new Patient(id,nom_pat,prenom,email,numero,adresse,nom));	

                  }
           		session.setAttribute("listDoc", listDoc);
               session.setAttribute("listpa", listpa);
              request.getRequestDispatcher("/view/Patient/ModifierP.jsp").forward(request,response);


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
