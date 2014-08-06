package kr.re.kribb.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kribb.mapper.ChromosomeInfoMapper;
import kr.re.kribb.mapper.InDel_MarkerMapper;
import kr.re.kribb.mapper.SSR_MarkerMapper;
import kr.re.kribb.mapper.SnpMarkerMapper;
import kr.re.kribb.mapper.TraitMapper;
import kr.re.kribb.model.GeneInfo;
import kr.re.kribb.model.GffRecord;
import kr.re.kribb.model.Marker;
import kr.re.kribb.model.MarkerVO;
import kr.re.kribb.model.SSR_Marker;
import kr.re.kribb.model.SnpMarker;
import kr.re.kribb.model.SnpMarkerSearch;
import kr.re.kribb.model.TmVO;
import kr.re.kribb.model.Trait;

@Service
public class MarkerServiceImpl implements MarkerService {

	@Autowired
	private SnpMarkerMapper markerMappper;
	@Autowired
	private InDel_MarkerMapper inDel_MarkerMapper;
	@Autowired
	private SSR_MarkerMapper ssr_MarkerMapper;
	@Autowired
	private ChromosomeInfoMapper chrInfoMapper;
	@Autowired
	private TraitMapper traitMapper;
	@Autowired
	private ServletContext context;
	@Autowired
	private GeneInfoService geneInfoService;
	@Autowired
	private GffReader gffReader;
	@Autowired
	private GeneStructureMap geneStructureMap;

	public void setFastaMapper(SnpMarkerMapper markerMappper) {
		this.markerMappper = markerMappper;
	}

	@Override
	public ArrayList<SnpMarker> getMarkers(MarkerVO markerVO) {

		// TODO Auto-generated method stub
		SnpMarkerSearch search = new SnpMarkerSearch();
		if (markerVO != null) {
			search.createCriteria().andGenesLike(markerVO.getGene());
		}
		return this.markerMappper.getMarkers(search);
	}

	@Override
	public ArrayList<SnpMarker> getMarkersTrim(MarkerVO markerVO) {
		// TODO Auto-generated method stub

		SnpMarkerSearch search = new SnpMarkerSearch();
		search.makeCriteria(markerVO);

		int limitStart = (markerVO.getPage() - 1) * search.getLimitMaxSize();
		if (limitStart < 0)
			limitStart = 0;
		search.setLimitStart(limitStart);

		ArrayList<SnpMarker> markers = this.markerMappper.getMarkers(search);

		for (Marker snpMarker : markers) {
			String gene = null;
			String[] genes = snpMarker.getGenes().split(",");
			if (genes.length > 1)
				gene = genes[0] + "*";
			else if (genes.length == 1)
				gene = genes[0];
			else if (genes[0] == "")
				gene = "-";
			snpMarker.setGenes(gene);
			String tags = snpMarker.getTags();
			if (tags.startsWith("up"))
				tags = "U";
			else if (tags.startsWith("exon"))
				tags = "E";
			else if (tags.startsWith("intron"))
				tags = "I";
			else if (tags.startsWith("intergenic"))
				tags = "IG";
			snpMarker.setTags(tags);
		}
		return markers;
	}

	@Override
	public int getCount(MarkerVO markerVO) {
		// TODO Auto-generated method stub
		SnpMarkerSearch search = new SnpMarkerSearch();
		search.makeCriteria(markerVO);
		return this.markerMappper.countMarkers(search);
	}

	@Override
	public Map<String, Object> pager(int totalCnt, MarkerVO markerVO) {
		// �섏씠吏�諛섑솚媛�
		SnpMarkerSearch search = new SnpMarkerSearch();
		Map<String, Object> page = new HashMap<String, Object>();
		int curPage = markerVO.getPage() - 1;
		int maxPage = totalCnt / search.getLimitMaxSize();
		int startPage = curPage - 5;

		if (startPage < 0)
			startPage = 0;

		int endPage = curPage + 5;

		if (endPage > maxPage)
			endPage = maxPage;

		ArrayList<Integer> pages = new ArrayList<Integer>();
		for (int i = startPage; i <= endPage; i++) {
			pages.add(i);
		}
		page.put("pages", pages);
		page.put("curPage", curPage);
		return page;
	}

	@Override
	public Map<String, String> getChars() {
		Map<String, String> chrs = new HashMap<String, String>();
		chrs.put("all", "All");
		for (int i = 1; i <= 9; i++) {
			chrs.put("C" + Integer.toString(i), "C" + Integer.toString(i));
		}
		return chrs;
	}

	@Override
	public void makeChromsomeMap(String chrNo) {
		// try {

		/*
		 * Properties properties = new Properties(); try {
		 * properties.load(this.getClass().getClassLoader()
		 * .getResourceAsStream("vcf.properties")); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(properties.getProperty("allvcf"));
		 * 
		 * VcfParserImpl vp = new
		 * VcfParserImpl(properties.getProperty("allvcf"));
		 * vp.setVcfFile(properties.getProperty("allvcf"));
		 */
		/*
		 * final int DRAW_HEIGHT = 500;
		 * 
		 * int maxGenomeLength = chrInfoMapper.getMaxChrLen(); ChromosomeInfo
		 * chrInfo = chrInfoMapper.selectByPrimaryKey(chrNo); float rate =
		 * (float)DRAW_HEIGHT / (float)maxGenomeLength; float s_chrLen =
		 * chrInfo.getChrlen() * rate;
		 * 
		 * BufferedImage image = new BufferedImage(200, 800,
		 * BufferedImage.TYPE_INT_ARGB); Graphics2D g2 = image.createGraphics();
		 * 
		 * int start=1; int end = 100000; int cnt=0;
		 * 
		 * while(start<=chrInfo.getChrlen()) { cnt =
		 * vp.queryCnt(chrNo,start,end); System.out.println(start +"," + end+
		 * ","+cnt); start+=100000; end+=100000; }
		 * 
		 * g2.setColor(new Color(0, 0, 0)); g2.drawLine(10, 10, 10, (int)
		 * (10+s_chrLen)); g2.drawLine(20, 10, 20, (int) (10+s_chrLen));
		 * g2.drawArc(10, 5, 10, 10, 0, 180); g2.drawArc(10, (int) (5+s_chrLen),
		 * 10, 10, 180, 180);
		 * 
		 * 
		 * File outputfile = new File(context.getRealPath( "/images/"+ chrNo +
		 * ".png")); ImageIO.write(image, "png", outputfile); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	@Override
	public HashMap<String, Integer> getMarkerCount(String markerType) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int sum = 0;
		if (markerType.equals("SNP")) {
			// SNP에서 찾을께요
			for (int i = 1; i <= 9; i++) {
				int cnt = markerMappper.chrCountSNP("C0" + i);
				sum += cnt;
				map.put("C0" + i, cnt);
			}
		} else if (markerType.equals("InDel")) {
			// InDel에서 찾을께요
			for (int i = 1; i <= 9; i++) {
				int cnt = inDel_MarkerMapper.chrCountInDel("C0" + i);
				sum += cnt;
				map.put("C0" + i, cnt);
			}
		} else if (markerType.equals("SSR")) {
			// SSR 에서 찾을께요
			for (int i = 1; i <= 9; i++) {
				int cnt = ssr_MarkerMapper.chrCountSSR("C0" + i);
				sum += cnt;
				map.put("C0" + i, cnt);
			}
		}

		map.put("sum", sum);

		return map;
	}

	@Override
	public int getMarkerCount(TmVO chrMarkerVO) {
		int cnt = 0;
		if (chrMarkerVO.getMarkerType().equals("SNP")) {
			cnt = markerMappper.chrCountSNP(chrMarkerVO.getChrom());
		} else if (chrMarkerVO.getMarkerType().equals("InDel")) {
			cnt = inDel_MarkerMapper.chrCountInDel(chrMarkerVO.getChrom());
		} else if (chrMarkerVO.getMarkerType().equals("SSR")) {
			cnt = ssr_MarkerMapper.chrCountSSR(chrMarkerVO.getChrom());
		}
		return cnt;
	}

	@Override
	public ArrayList<Marker> getChrMarkers(TmVO chrMarkerVO) {
		ArrayList<Marker> markers = new ArrayList<Marker>();

		if (chrMarkerVO.getMarkerType().equals("SNP")) {
			markers = markerMappper.getChrMarkers(chrMarkerVO);
		} else if (chrMarkerVO.getMarkerType().equals("InDel")) {
			markers = inDel_MarkerMapper.getChrMarkers(chrMarkerVO);
		} else if (chrMarkerVO.getMarkerType().equals("SSR")) {
			markers = ssr_MarkerMapper.getChrMarkers(chrMarkerVO);
		}

		return markers;
	}

	@Override
	public HashMap<Integer, Integer> getMfCnt(TmVO chrMarkerVO) {
		HashMap<Integer, Integer> mfcnt = new HashMap<Integer, Integer>();
		int pos = 0;
		int chrLen = chrInfoMapper.getChrLen(chrMarkerVO.getChrom());

		do {
			int endPos = pos + 1000000;
			int cnt = 0;
			if (chrMarkerVO.getMarkerType().equals("SNP")) {
				cnt = markerMappper.getCountPos(chrMarkerVO.getChrom(),
						pos + 1, endPos);
			} else if (chrMarkerVO.getMarkerType().equals("InDel")) {
				cnt = inDel_MarkerMapper.getCountPos(chrMarkerVO.getChrom(),
						pos + 1, endPos);
			} else if (chrMarkerVO.getMarkerType().equals("SSR")) {
				cnt = ssr_MarkerMapper.getCountPos(chrMarkerVO.getChrom(),
						pos + 1, endPos);
			}
			mfcnt.put(pos, cnt);
			pos = endPos;
		} while (pos < chrLen);

		return mfcnt;
	}

	@Override
	public SSR_Marker getSsrMarker(SSR_Marker ssrVO) {
		// TODO Auto-generated method stub
		SSR_Marker ssrMarker = ssr_MarkerMapper.getSsrMarker(ssrVO);
		return ssrMarker;
	}

	@Override
	public Map<String, Object> drawGeneStructure(Marker marker) {
		// TODO : 이미지 맵 그리는 부분 호출

		Map<String, Object> retValue = new HashMap<String, Object>();
		String imgName = null;
		List<Marker> markers = new ArrayList<Marker>();

		GeneInfo geneInfo = geneInfoService.getGeneInfo(marker.getGenes());
		if (geneInfo != null) {

			int[] startEnd = geneInfoService.up1kb_pos(geneInfo);
			TmVO serchVO = new TmVO();
			serchVO.setChrom(marker.getChrom());
			serchVO.setStartPos(startEnd[0]);
			serchVO.setEndPos(startEnd[1]);
			
			List<Marker> snpMarkers = markerMappper.getChrMarkers(serchVO);
			List<Marker> inDel_Markers = inDel_MarkerMapper
					.getChrMarkers(serchVO);
			List<Marker> ssr_Markers = ssr_MarkerMapper.getChrMarkers(serchVO);
			markers.addAll(snpMarkers);
			markers.addAll(inDel_Markers);
			markers.addAll(ssr_Markers);
			Collections.sort(markers, new LociAscCompare());

			List<GffRecord> gffRecords = gffReader.query(marker.getChrom(),
					startEnd[0], startEnd[1]);
			imgName = geneStructureMap.drawGeneStructure(startEnd,
					gffRecords, marker, markers);
		}
		
		retValue.put("imgName", imgName);
		retValue.put("markers", markers);

		return retValue;

	}

	@Override
	public HashMap<String, String> getTraits() {
		
		// TODO Auto-generated method stub
		List<Trait> traits = traitMapper.selectTraits();
		HashMap<String, String> traitMap = new HashMap<String, String>();
		for (Iterator<Trait> itr = traits.iterator(); itr.hasNext();) {
			Trait trait = (Trait) itr.next();
			traitMap.put(trait.getCode(), trait.getTrait());			
		}
		return traitMap;		
	}
	
	static class LociAscCompare implements Comparator<Marker> {

		@Override
		public int compare(Marker m1, Marker m2) {
			// TODO 마커 loci 오름차순
			return m1.getLoci() < m2.getLoci() ? -1 : m1.getLoci() > m2.getLoci() ? 1 : 0;
		}
		
	}
}
