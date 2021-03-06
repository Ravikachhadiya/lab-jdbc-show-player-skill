package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.ConnectionManager;
import model.Skill;

public class SkillDAO {
	
	
	public List<Skill> listAllSkills() throws ClassNotFoundException, SQLException, IOException{
		List<Skill> skillTable = new ArrayList<Skill>();
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM SKILL ORDER BY name");
		
		while(rs.next()) {
			long skillId = rs.getLong("id");
			String skillName = rs.getString("name");
			
			Skill skill = new Skill(skillId, skillName);
			skillTable.add(skill);
		}
		
		return skillTable;
		
	}
	
	
	
//	String username = loginPojo.getUsername();
//	String password = loginPojo.getPassword();
//	
//	ConnectionManager con = new ConnectionManager();
//	Statement st = con.getConnection().createStatement();
//	
//	ResultSet rs = st.executeQuery("SELECT * from USERDETAILS");
//	
//	while(rs.next()) {
//		if(username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD"))) {
//			con.getConnection().close();
//			return true;
//		}
//		else {
//			con.getConnection().close();
//			return false;
//		}
//	}
//	
//	return false;
	
}
