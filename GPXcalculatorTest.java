package edu.upenn.cis350.gpx;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;


public class GPXcalculatorTest extends TestCase {

	GPXtrk nullTrk = null;
	GPXtrk nullTrkSegList = new GPXtrk("nullTrkSegList", null);
	GPXtrk emptyTrkSegList = new GPXtrk("emptyTrkSegList", new ArrayList<GPXtrkseg>());
	GPXtrkseg nullTrkSeg = null;
	GPXtrkpt nullPt = null;
	GPXtrkpt zerozero = new GPXtrkpt(0, 0, null);
	GPXtrkpt threefour = new GPXtrkpt(3, 4, null);
	GPXtrkpt eightfour = new GPXtrkpt(8, 4, null);
	GPXtrkpt negthreenegfour = new GPXtrkpt(-3, -4, null);
	GPXtrkpt ltneg90 = new GPXtrkpt(-91, 0, null);
	GPXtrkpt gt90 = new GPXtrkpt(91, 0, null);
	GPXtrkpt ltneg180 = new GPXtrkpt(0, -181, null);
	GPXtrkpt gt180 = new GPXtrkpt(0, 181, null);
	GPXtrkpt lat90 = new GPXtrkpt(90, 0, null);
	GPXtrkpt latneg90 = new GPXtrkpt(-90, 0, null);
	GPXtrkpt long180 = new GPXtrkpt(0, 180, null);
	GPXtrkpt longneg180 = new GPXtrkpt(0, -180, null);
	
	@Test
	public void testNullTrk() {
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullTrk), -1);
	}
	
	@Test
	public void testNullTrkSegList() {
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullTrkSegList), -1);
	}
	
	@Test
	public void testEmptyTrkSegList() {
		assertEquals(GPXcalculator.calculateDistanceTraveled(emptyTrkSegList), -1);
	}
	
	@Test
	public void testNullTrkSeg() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		segArray.add(nullTrkSeg);
		GPXtrk nullTrkSeg = new GPXtrk("nullTrkSegObj", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullTrkSeg), 0);
	}
	
	@Test
	public void testNullTrkSeg2() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(threefour);
		GPXtrkseg threeFourTrkSeg = new GPXtrkseg(ptArray);
		segArray.add(nullTrkSeg);
		segArray.add(threeFourTrkSeg);
		GPXtrk nullTrkSeg = new GPXtrk("nullTrkSegObj", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullTrkSeg), 5);
	}
	
	@Test
	public void testEmptyTrkSeg() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		GPXtrkseg emptyTrkSegObj = new GPXtrkseg(ptArray);
		segArray.add(emptyTrkSegObj);
		GPXtrk emptyTrkSeg = new GPXtrk("emptyTrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(emptyTrkSeg), 0);
	}
	
	@Test
	public void testEmptyTrkSeg2() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(threefour);
		GPXtrkseg emptyTrkSegObj = new GPXtrkseg(ptArray);
		GPXtrkseg threeFourTrkSeg = new GPXtrkseg(ptArray);
		segArray.add(emptyTrkSegObj);
		segArray.add(threeFourTrkSeg);
		GPXtrk emptyTrkSeg = new GPXtrk("emptyTrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(emptyTrkSeg), 5);
	}
	
	@Test
	public void testOneTrkPt() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		GPXtrkseg zeroZeroTrkSeg = new GPXtrkseg(ptArray);
		segArray.add(zeroZeroTrkSeg);
		GPXtrk onePtTrkSeg = new GPXtrk("testOneTrkPt", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(onePtTrkSeg), 0);
	}
	
	@Test
	public void testOneTrkPt2() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ArrayList<GPXtrkpt> ptArray2 = new ArrayList<GPXtrkpt>();
		ptArray.add(eightfour);
		ptArray2.add(zerozero);
		ptArray2.add(threefour);
		GPXtrkseg onePtTrkSegObj = new GPXtrkseg(ptArray);
		GPXtrkseg twoPtTrkSegObj = new GPXtrkseg(ptArray2);
		segArray.add(onePtTrkSegObj);
		segArray.add(twoPtTrkSegObj);
		GPXtrk onePtTrkSeg = new GPXtrk("testOneTrkPt", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(onePtTrkSeg), 5);
	}
	
	@Test
	public void testNullPt() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(nullPt);
		GPXtrkseg nullPtTrkSegObj = new GPXtrkseg(ptArray);
		segArray.add(nullPtTrkSegObj);
		GPXtrk nullPtTrkSeg = new GPXtrk("nullPtTrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullPtTrkSeg), 0);
	}
	
	@Test
	public void testNullPt2() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(nullPt);
		ptArray.add(threefour);
		GPXtrkseg nullPtTrkSegObj = new GPXtrkseg(ptArray);
		segArray.add(nullPtTrkSegObj);
		GPXtrk nullPtTrkSeg = new GPXtrk("nullPtTrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullPtTrkSeg), 0);
	}
	
	@Test
	public void testNullPt3() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ArrayList<GPXtrkpt> ptArray2 = new ArrayList<GPXtrkpt>();
		ptArray.add(nullPt);
		ptArray.add(eightfour);
		ptArray2.add(zerozero);
		ptArray2.add(threefour);
		GPXtrkseg nullPtTrkSegObj = new GPXtrkseg(ptArray);
		GPXtrkseg zztfTrkSegObj = new GPXtrkseg(ptArray2);
		segArray.add(nullPtTrkSegObj);
		segArray.add(zztfTrkSegObj);
		GPXtrk nullPtTrkSeg = new GPXtrk("nullPtTrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullPtTrkSeg), 5);
	}
	
	@Test
	public void testLatGT90() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(gt90);
		GPXtrkseg gt90seg = new GPXtrkseg(ptArray);
		segArray.add(gt90seg);
		GPXtrk gt90TrkSeg = new GPXtrk("gt90TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(gt90TrkSeg), 0);
	}
	
	@Test
	public void testLatLTneg90() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(ltneg90);
		GPXtrkseg ltneg90seg = new GPXtrkseg(ptArray);
		segArray.add(ltneg90seg);
		GPXtrk ltneg90TrkSeg = new GPXtrk("ltneg90TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(ltneg90TrkSeg), 0);
	}
	
	@Test
	public void testLongGT180() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(gt180);
		GPXtrkseg gt180seg = new GPXtrkseg(ptArray);
		segArray.add(gt180seg);
		GPXtrk gt180TrkSeg = new GPXtrk("gt180TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(gt180TrkSeg), 0);
	}
	
	@Test
	public void testLongLTneg180() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(ltneg180);
		GPXtrkseg ltneg180seg = new GPXtrkseg(ptArray);
		segArray.add(ltneg180seg);
		GPXtrk ltneg180TrkSeg = new GPXtrk("ltneg180TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(ltneg180TrkSeg), 0);
	}
	
	@Test
	public void testLatEQ90() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(lat90);
		GPXtrkseg lat90seg = new GPXtrkseg(ptArray);
		segArray.add(lat90seg);
		GPXtrk lat90TrkSeg = new GPXtrk("lat90TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(lat90TrkSeg), 90);
	}
	
	@Test
	public void testLatEQneg90() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(latneg90);
		GPXtrkseg latneg90seg = new GPXtrkseg(ptArray);
		segArray.add(latneg90seg);
		GPXtrk latneg90TrkSeg = new GPXtrk("latneg90TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(latneg90TrkSeg), 90);
	}
	
	@Test
	public void testLongEQ180() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(long180);
		GPXtrkseg long180seg = new GPXtrkseg(ptArray);
		segArray.add(long180seg);
		GPXtrk long180TrkSeg = new GPXtrk("long180TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(long180TrkSeg), 180);
	}
	
	@Test
	public void testLongEQneg180() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(longneg180);
		GPXtrkseg longneg180seg = new GPXtrkseg(ptArray);
		segArray.add(longneg180seg);
		GPXtrk longneg180TrkSeg = new GPXtrk("longneg180TrkSeg", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(longneg180TrkSeg), 180);
	}
	
	@Test
	public void testNormalGPXtrk() {
		ArrayList<GPXtrkseg> segArray = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> ptArray = new ArrayList<GPXtrkpt>();
		ArrayList<GPXtrkpt> ptArray2 = new ArrayList<GPXtrkpt>();
		ptArray.add(zerozero);
		ptArray.add(threefour);
		ptArray2.add(threefour);
		ptArray2.add(eightfour);
		GPXtrkseg zztf = new GPXtrkseg(ptArray);
		GPXtrkseg tfef = new GPXtrkseg(ptArray2);
		segArray.add(zztf);
		segArray.add(tfef);
		GPXtrk normalTrk = new GPXtrk("normalTrk", segArray);
		assertEquals(GPXcalculator.calculateDistanceTraveled(normalTrk), 10);
	}
}
