package jsf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

@ManagedBean
public class UploadBean {

	private Part file;
	private String numbers;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public void process(ActionEvent evt) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			numbers = "";
			while(true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				
				// check whether line contains 10 digits 
				if (Pattern.matches("^[0-9]{10}$", line))
				    numbers += line + "\n";
			}
			br.close();

		} catch (Exception ex) {
			System.out.println(ex);
			numbers = "";
		}

	}
}
