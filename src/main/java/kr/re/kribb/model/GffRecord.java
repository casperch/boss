package kr.re.kribb.model;

public class GffRecord {

	String chrom;
	String source;
	String feature;
	int start;
	int end;
	String score;
	String strand;
	String frame;
	String attributes;

	public GffRecord(String[] items) {
		// TODO Auto-generated constructor stub
		this.chrom = items[0];
		this.source = items[1];
		this.feature = items[2];
		this.start = Integer.parseInt(items[3]);
		this.end = Integer.parseInt(items[4]);
		this.score = items[5];
		this.strand = items[6];
		this.frame = items[7];
		this.attributes = items[8];
	}

	public String getChrom() {
		return chrom;
	}

	public void setChrom(String chrom) {
		this.chrom = chrom;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getStrand() {
		return strand;
	}

	public void setStrand(String strand) {
		this.strand = strand;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub		
		return String.format("%s\t%s\t%s\t%s", this.chrom, this.feature, this.start, this.end);
	}	
	 
}
