package model;

public class Experiment {

	private String experimentid;

	private int stutype;

	private String experimenttitle;

	private String deadline;

	private String teachername;

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExperimentid() {
		return experimentid;
	}

	public void setExperimentid(String experimentid) {
		this.experimentid = experimentid;
	}

	public int getStutype() {
		return stutype;
	}

	public void setStutype(int stutype) {
		this.stutype = stutype;
	}

	public String getExperimenttitle() {
		return experimenttitle;
	}

	public void setExperimenttitle(String experimenttitle) {
		this.experimenttitle = experimenttitle;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

}