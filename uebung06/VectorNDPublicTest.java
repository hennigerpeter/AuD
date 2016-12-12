import static org.junit.Assert.*;
import org.junit.*;

public class VectorNDPublicTest {
	public final double EPS = 1e-5;
    

    @Test(timeout=100)
    public void testCtor1(){
		VectorND vec = new VectorND(2);
		assertEquals("Wrong dimension intialization! Await 2 got " + vec.data.length, 2, vec.data.length);
    }

    @Test(timeout=100)
    public void testCtor2(){
		VectorND vec = new VectorND(new double[]{3.0, 3.0, 3.0});
		assertEquals("Wrong dimension intialization! Await 3 got " + vec.data.length, 3, vec.data.length);
    }

    @Test(timeout=100)
    public void testInit2(){
		VectorND vec = new VectorND(2);
		vec.init(new double[]{1.0, 2.0});

		assertEquals("Wrong data intialization! Await 1.0 got " + vec.getValueAt(0), 1.0, vec.getValueAt(0), EPS);
		assertEquals("Wrong data intialization! Await 2.0 got " + vec.getValueAt(1), 2.0, vec.getValueAt(1), EPS);
    }
    
    @Test(timeout=100)
    public void testGetDimension2(){
		VectorND vec = new VectorND(1);

		assertEquals("Vector dimension", 1, vec.getDimension());
	}

    @Test(timeout=100)
    public void testMultiply1(){
		VectorND vec = new VectorND(2);
		vec.init(new double[]{1.0, 2.0});
		vec.multiply(3);
		
		assertEquals("Wrong multiplication! Await 3.0 got " + vec.getValueAt(0), 3.0, vec.getValueAt(0), EPS);
		assertEquals("Wrong multiplication! Await 6.0 got " + vec.getValueAt(1), 6.0, vec.getValueAt(1), EPS);

    }

    @Test(timeout=100)
    public void testDotVector2(){
		VectorND vec = new VectorND(2);
		vec.init(new double[]{3.0, 6.0});

		VectorND vec2 = new VectorND(2);
		vec2.init(new double[]{4.0, 8.0 });
		
		assertEquals("Scalar product. Await 60 got " + vec.dot(vec2), 60.0, vec.dot(vec2), EPS);
    }
    
    @Test(timeout=100)
    public void testSum3(){
		VectorND vec = new VectorND(3);
		vec.init(new double[]{1.0, 2.0, 3.0});

		VectorND vec2 = new VectorND(3);
		vec2.init(new double[]{3.0, 2.0, 1.0});

		vec.add(vec2);

		assertEquals("Sum of vectors wrong.", 4.0, vec.getValueAt(0), EPS);
		assertEquals("Sum of vectors wrong.", 4.0, vec.getValueAt(1), EPS);
		assertEquals("Sum of vectors wrong.", 4.0, vec.getValueAt(2), EPS);
	}

    @Test(timeout=100)
    public void testNormalize1(){
		VectorND vec = new VectorND(3);
		vec.init(new double[]{3.0, 3.0, 3.0});
		vec.normalize();

		assertEquals("Normalized vector wrong at position 0.", 0.5773502691896257, Math.abs(vec.getValueAt(0)), EPS);
		assertEquals("Normalized vector wrong at position 1.", 0.5773502691896257, Math.abs(vec.getValueAt(1)), EPS);
		assertEquals("Normalized vector wrong at position 2.", 0.5773502691896257, Math.abs(vec.getValueAt(2)), EPS);
	}
}







