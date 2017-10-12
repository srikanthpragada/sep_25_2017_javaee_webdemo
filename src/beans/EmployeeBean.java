package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeBean {
	private int id, salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean updateSalary() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement("update employees set salary = ?  where employee_id = ?");

				ps.setInt(1, salary);
				ps.setInt(2, id);

				int count = ps.executeUpdate();

				if (count == 1)
					return true;
				else
					return false;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
