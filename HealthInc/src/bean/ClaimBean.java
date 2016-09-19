package bean;

public class ClaimBean {

	private String claimType;
	private int mediAssistClaimNo;
	private String claimRaisedOn;
	private String patientName;
	private String relation;
	private double claimAmt;
	private double approvedAmt;
	private int status;
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public int getMediAssistClaimNo() {
		return mediAssistClaimNo;
	}
	public void setMediAssistClaimNo(int mediAssistClaimNo) {
		this.mediAssistClaimNo = mediAssistClaimNo;
	}
	public String getClaimRaisedOn() {
		return claimRaisedOn;
	}
	public void setClaimRaisedOn(String claimRaisedOn) {
		this.claimRaisedOn = claimRaisedOn;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public double getClaimAmt() {
		return claimAmt;
	}
	public void setClaimAmt(double claimAmt) {
		this.claimAmt = claimAmt;
	}
	public double getApprovedAmt() {
		return approvedAmt;
	}
	public void setApprovedAmt(double approvedAmt) {
		this.approvedAmt = approvedAmt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
