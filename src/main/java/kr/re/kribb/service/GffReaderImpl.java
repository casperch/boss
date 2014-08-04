package kr.re.kribb.service;

import htsjdk.tribble.readers.TabixReader;
import htsjdk.tribble.readers.TabixReader.Iterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.re.kribb.model.GffRecord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GffReaderImpl implements GffReader {
	
	
	@Value("${file.gff}")	
	private String gffpath;
	
	public String getGffPath() {
		return this.gffpath;

	}
	
	public List<GffRecord> query(String chrom, int start, int end)
	{	
		List<GffRecord> gffRecords = new ArrayList<GffRecord>();
		try {
			TabixReader reader = new TabixReader(gffpath);
			StringBuilder sb = new StringBuilder(chrom);
			sb.append(":");
			sb.append(Integer.toString(start));
			sb.append("-");
			sb.append(Integer.toString(end));			
			Iterator itr = reader.query(sb.toString());			
			String line;
			while( (line = itr.next()) != null  ){
				String items[] = line.split("\t");
				GffRecord record = new GffRecord(items);
				gffRecords.add(record);
				//System.out.println(record);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gffRecords;
	}

}
