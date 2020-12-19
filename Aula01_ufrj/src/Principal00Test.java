import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Principal00Test {


    @Test
    public void testarCalcularMDC1(){
        assertEquals(5, Principal00.calcularMDC(10, 15));
        assertEquals(5, Principal00.calcularMDC(15, 10));
        assertEquals(13, Principal00.calcularMDC(26, 39));
        assertEquals(2, Principal00.calcularMDC(26, 40));
        assertEquals(13, Principal00.calcularMDC(39, 26));
        assertEquals(5, Principal00.calcularMDC(15, 10));
    }

    @Test
    public void testarCalculaMDCQuandoUmDosNumrosEhNegativo(){
        assertEquals(0, Principal00.calcularMDC(-13, 38));
    }


}
