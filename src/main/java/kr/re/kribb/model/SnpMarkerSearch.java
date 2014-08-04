package kr.re.kribb.model;

import java.lang.Math;

public class SnpMarkerSearch extends SnpMarkerExample {
	public SnpMarkerSearch() {
		// TODO Auto-generated constructor stub
		this.setLimitMaxSize(30);
	}

	public void makeCriteria(MarkerVO markerVO) {
		Criteria criteria = this.createCriteria();

		if (!markerVO.getChr().equals("all")) {
			// this.createCriteria().andChromEqualTo(markerVO.getChr());
			criteria.andChromEqualTo(markerVO.getChr());
		}

		if ( !(markerVO.getStart() == null || markerVO.getStart().equals("0"))
				|| !(markerVO.getEnd() == null || markerVO.getEnd().equals("0"))) {
			int start = Math.min(Integer.parseInt(markerVO.getStart()),
					Integer.parseInt(markerVO.getEnd()));
			int end = Math.max(Integer.parseInt(markerVO.getStart()),
					Integer.parseInt(markerVO.getEnd()));
			criteria.andLociBetween(start, end);
		}

		if (markerVO.getGene() != "") {
			criteria.andGenesLike(markerVO.getGene());
		}		

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// this.getOredCriteria();
		return super.toString();
	}
}
