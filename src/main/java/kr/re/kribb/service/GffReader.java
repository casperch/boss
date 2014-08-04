package kr.re.kribb.service;

import java.util.List;

import kr.re.kribb.model.GffRecord;

public interface GffReader {
	String getGffPath();
	public List<GffRecord> query(String chrom, int start, int end);
}
