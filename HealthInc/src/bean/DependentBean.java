package bean;

public class DependentBean {

	private int dep_hi_id;
	private int dep_id;
	private String dep_name;
	private String dep_relation;
	private String dep_dob;
	private String dep_gender;
	
	private String dep_policy_start_date;
	private int dep_policy_period;
	private double dep_tot_sum_ins;
	private double dep_prem_amt;
	
	public DependentBean() {
		super();
	}
	
	public int getDep_hi_id() {
		return dep_hi_id;
	}
	public void setDep_hi_id(int dep_hi_id) {
		this.dep_hi_id = dep_hi_id;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDep_relation() {
		return dep_relation;
	}
	public void setDep_relation(String dep_relation) {
		this.dep_relation = dep_relation;
	}
	public String getDep_dob() {
		return dep_dob;
	}
	public void setDep_dob(String dep_dob) {
		this.dep_dob = dep_dob;
	}
	public String getDep_gender() {
		return dep_gender;
	}
	public void setDep_gender(String dep_gender) {
		this.dep_gender = dep_gender;
	}
	public String getDep_policy_start_date() {
		return dep_policy_start_date;
	}
	public void setDep_policy_start_date(String dep_policy_start_date) {
		this.dep_policy_start_date = dep_policy_start_date;
	}
	public int getDep_policy_period() {
		return dep_policy_period;
	}
	public void setDep_policy_period(int dep_policy_period) {
		this.dep_policy_period = dep_policy_period;
	}
	public double getDep_tot_sum_ins() {
		return dep_tot_sum_ins;
	}
	public void setDep_tot_sum_ins(double dep_tot_sum_ins) {
		this.dep_tot_sum_ins = dep_tot_sum_ins;
	}
	public double getDep_prem_amt() {
		return dep_prem_amt;
	}
	public void setDep_prem_amt(double dep_prem_amt) {
		this.dep_prem_amt = dep_prem_amt;
	}
	
	
	
}
