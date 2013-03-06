import junit.framework.TestCase;


public class TaulerTest extends TestCase {

	Tauler tauler;
	
	static final int AMPL=10;
	static final int ALC=10;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		tauler = new Tauler (ALC, AMPL);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testColocarVaixell()
	{
		boolean res;
		Vaixell v4H=new Vaixell(4,Orientacio.H);
		Vaixell v4V=new Vaixell(4,Orientacio.V);
//		Vaixell v1H=new Vaixell(1,Orientacio.H);
//		Vaixell v1V=new Vaixell(1,Orientacio.V);
	
			// Colocar-los a les vores del taulell
		res=tauler.ColocarVaixell(1, 1, v4H);
		assertTrue(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-1, AMPL-1, v4H);
		assertFalse(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-1, AMPL-2, v4H);
		assertFalse(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-1, AMPL-3, v4H);
		assertFalse(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-1, AMPL-4, v4H);
		assertTrue(res);
		tauler.FerTotAigua();

		res=tauler.ColocarVaixell(1, 1, v4V);
		assertTrue(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-1, AMPL-1, v4V);
		assertFalse(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-2, AMPL-1, v4V);
		assertFalse(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-3, AMPL-1, v4V);
		assertFalse(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(ALC-4, AMPL-1, v4V);
		assertTrue(res);
		tauler.FerTotAigua();
		// ... i mes casos limit per v1H i v1V

			// Colocar-los sobre un altre vaixell
		
		res=tauler.ColocarVaixell(1, 1, v4V);
		assertTrue(res);
		tauler.FerTotAigua();
		res=tauler.ColocarVaixell(1, 1, v4H);
		assertTrue(res);
		tauler.FerTotAigua();
		
	}

	public void testTret()
	{
		int yV=1;
		int xV=1;
		Casella cas;
		Vaixell v1H=new Vaixell(1,Orientacio.H);
		tauler.ColocarVaixell(yV, xV, v1H);
		
		cas=tauler.Tret(xV,yV);
		assertEquals(cas,Casella.TOCAT);
		cas=tauler.Tret(2,1);
		assertEquals(cas,Casella.AIGUA);
		
	}
	
}
