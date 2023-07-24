package model.rec;

public class MissionVO {
	String miname, mipoint, mlfinish;
	int missioncode;

	public MissionVO() {

	}

	public MissionVO(String miname, String mipoint, String mlfinish, int missioncode) {

	}

	public String getMiname() {
		return miname;
	}

	public void setMiname(String miname) {
		this.miname = miname;
	}

	public String getMipoint() {
		return mipoint;
	}

	public void setMipoint(String mipoint) {
		this.mipoint = mipoint;
	}

	public String getMlfinish() {
		return mlfinish;
	}

	public void setMlfinish(String mlfinish) {
		this.mlfinish = mlfinish;
	}

	public int getMissioncode() {
		return missioncode;
	}

	public void setMissioncode(int missioncode) {
		this.missioncode = missioncode;
	}

}