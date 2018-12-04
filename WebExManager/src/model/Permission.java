package model;

public class Permission {

	private String adminid;

	private int usertypeid;

	private int permissionid;

	private String permissiondescribe;

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public int getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public int getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}

	public String getPermissiondescribe() {
		return permissiondescribe;
	}

	public void setPermissiondescribe(String permissiondescribe) {
		this.permissiondescribe = permissiondescribe;
	}

}