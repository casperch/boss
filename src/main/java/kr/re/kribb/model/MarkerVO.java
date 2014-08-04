package kr.re.kribb.model;

public class MarkerVO {

    private String chr = "all";
    private String start = "0";
    private String end = "0";
    private String gene = "";
    private String annot = "";
    private int page = 1;

    public String getChr() {
	return chr;
    }

    public void setChr(String chr) {
	this.chr = chr;
    }

    public String getStart() {
	return start;
    }

    public void setStart(String start) {
	this.start = start;
    }

    public String getEnd() {
	return end;
    }

    public void setEnd(String end) {
	this.end = end;
    }

    public String getGene() {
	return gene;
    }

    public void setGene(String gene) {
	this.gene = gene;
    }

    public String getAnnot() {
	return annot;
    }

    public void setAnnot(String annot) {
	this.annot = annot;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub	
        //return super.toString();
	return getChr() + getStart() + getEnd() + getGene() + getAnnot() + getPage();
    }
}
