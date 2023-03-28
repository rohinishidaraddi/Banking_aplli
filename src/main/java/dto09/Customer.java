package dto09;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import lombok.Data;
@Entity
@Data
public class Customer {
	@Id
	@SequenceGenerator(initialValue=12110111,allocationSize=1 ,sequenceName="cust_id",name="cust_id")
	@GeneratedValue(generator="cust_id")
	int cust_id;
	String name;
	String email;
	String pwd;
	long mob;
	String Dob;
	String gender;
	@OneToMany
	List<BankAccount>Accounts;

}
