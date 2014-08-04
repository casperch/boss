package kr.re.kribb.model;

import java.util.ArrayList;
import java.util.List;

public class TmVO {
	
	private String markerType;
	
	private String chrom;

	private String tags;
	
	private int startPos;
	
	private int endPos;

	private List<String> groupA;

	private List<String> groupB;
	
	public TmVO() {
		// TODO Auto-generated constructor stub
		this.setMarkerType("SNP");
		this.setChrom("all");
		this.setTags("all");
		this.setStartPos(1);
		this.setEndPos(1000000);
		this.setGroupA(new ArrayList<String>());
		this.setGroupB(new ArrayList<String>());
	}

	public String getMarkerType() {
		return markerType;
	}

	public void setMarkerType(String markerTyep) {
		this.markerType = markerTyep;
	}

	public String getChrom() {
		return chrom;
	}

	public void setChrom(String chrom) {
		this.chrom = chrom;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<String> getGroupA() {
		return groupA;
	}

	public void setGroupA(List<String> groupA) {
		this.groupA = groupA;
	}

	public List<String> getGroupB() {
		return groupB;
	}

	public void setGroupB(List<String> groupB) {
		this.groupB = groupB;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public int getGroupAcnt() {
		return this.groupA.size();
	}

	public void setGroupAcnt(int groupAcnt) {
	}

	public int getGroupBcnt() {
		return this.groupB.size();
	}

	public void setGroupBcnt(int groupBcnt) {
	}

}
