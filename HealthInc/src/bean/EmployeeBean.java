package bean;

public class EmployeeBean {
		private int emp_hi_id;
		private int emp_id;
		private String emp_name;
		private String emp_dob;
		private String emp_gen;
		
		private String emp_email;
		private String emp_alt_email;
		private String emp_ph_no;
		private String emp_mob_no;
		private String emp_policy_start_date;
		
		private int emp_policy_period;
		private double emp_tot_sum_ins;
		private double emp_prem_amt;
		private String emp_acc_no;
		private String emp_bnk_name;
		private String emp_bnk_ifsc;
		private String emp_password ;
		private int emp_status;

		public EmployeeBean(int emp_hi_id, int emp_id, String emp_name, String emp_dob,
				String emp_gen, String emp_email, String emp_alt_email,
				String emp_ph_no, String emp_mob_no, String emp_policy_start_date,
				int emp_policy_period, double emp_tot_sum_ins, double emp_prem_amt,
				String emp_acc_no, String emp_bnk_name, String emp_bnk_ifsc,
				String emp_password) {
			super();
			this.emp_hi_id = emp_hi_id;
			this.emp_id = emp_id;
			this.emp_name = emp_name;
			this.emp_dob = emp_dob;
			this.emp_gen = emp_gen;
			this.emp_email = emp_email;
			this.emp_alt_email = emp_alt_email;
			this.emp_ph_no = emp_ph_no;
			this.emp_mob_no = emp_mob_no;
			this.emp_policy_start_date = emp_policy_start_date;
			this.emp_policy_period = emp_policy_period;
			this.emp_tot_sum_ins = emp_tot_sum_ins;
			this.emp_prem_amt = emp_prem_amt;
			this.emp_acc_no = emp_acc_no;
			this.emp_bnk_name = emp_bnk_name;
			this.emp_bnk_ifsc = emp_bnk_ifsc;
			this.emp_password = emp_password;
		}
		public EmployeeBean() {
			// TODO Auto-generated constructor stub
		}
		public int getEmp_hi_id() {
			return emp_hi_id;
		}
		public void setEmp_hi_id(int emp_hi_id) {
			this.emp_hi_id = emp_hi_id;
		}
		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}
		public String getEmp_name() {
			return emp_name;
		}
		public void setEmp_name(String emp_name) {
			this.emp_name = emp_name;
		}
		public String getEmp_dob() {
			return emp_dob;
		}
		public void setEmp_dob(String emp_dob) {
			this.emp_dob = emp_dob;
		}
		public String getEmp_gen() {
			return emp_gen;
		}
		public void setEmp_gen(String emp_gen) {
			this.emp_gen = emp_gen;
		}
		public String getEmp_email() {
			return emp_email;
		}
		public void setEmp_email(String emp_email) {
			this.emp_email = emp_email;
		}
		public String getEmp_alt_email() {
			return emp_alt_email;
		}
		public void setEmp_alt_email(String emp_alt_email) {
			this.emp_alt_email = emp_alt_email;
		}
		public String getEmp_ph_no() {
			return emp_ph_no;
		}
		public void setEmp_ph_no(String emp_ph_no) {
			this.emp_ph_no = emp_ph_no;
		}
		public String getEmp_mob_no() {
			return emp_mob_no;
		}
		public void setEmp_mob_no(String emp_mob_no) {
			this.emp_mob_no = emp_mob_no;
		}
		public String getEmp_policy_start_date() {
			return emp_policy_start_date;
		}
		public void setEmp_policy_start_date(String emp_policy_start_date) {
			this.emp_policy_start_date = emp_policy_start_date;
		}
		public int getEmp_policy_period() {
			return emp_policy_period;
		}
		public void setEmp_policy_period(int emp_policy_period) {
			this.emp_policy_period = emp_policy_period;
		}
		public double getEmp_tot_sum_ins() {
			return emp_tot_sum_ins;
		}
		public void setEmp_tot_sum_ins(double emp_tot_sum_ins) {
			this.emp_tot_sum_ins = emp_tot_sum_ins;
		}
		public double getEmp_prem_amt() {
			return emp_prem_amt;
		}
		public void setEmp_prem_amt(double emp_prem_amt) {
			this.emp_prem_amt = emp_prem_amt;
		}
		public String getEmp_acc_no() {
			return emp_acc_no;
		}
		public void setEmp_acc_no(String emp_acc_no) {
			this.emp_acc_no = emp_acc_no;
		}
		public String getEmp_bnk_name() {
			return emp_bnk_name;
		}
		public void setEmp_bnk_name(String emp_bnk_name) {
			this.emp_bnk_name = emp_bnk_name;
		}
		public String getEmp_bnk_ifsc() {
			return emp_bnk_ifsc;
		}
		public void setEmp_bnk_ifsc(String emp_bnk_ifsc) {
			this.emp_bnk_ifsc = emp_bnk_ifsc;
		}
		public String getEmp_password() {
			return emp_password;
		}
		public void setEmp_password(String emp_password) {
			this.emp_password = emp_password;
		}
		public int getEmp_status() {
			return emp_status;
		}
		public void setEmp_status(int emp_status) {
			this.emp_status = emp_status;
		}	
}
