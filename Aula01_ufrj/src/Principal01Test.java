import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Principal01Test {

    @Test
    public void testarCalcularMDC(){
        assertEquals(5, Principal01.calcularMDC(10, 15));
        assertEquals(5, Principal01.calcularMDC(15, 10));
        assertEquals(13, Principal01.calcularMDC(26, 39));
        assertEquals(2, Principal01.calcularMDC(26, 40));
        assertEquals(13, Principal01.calcularMDC(39, 26));
        assertEquals(3, Principal01.calcularMDC(9, 30));
    }

    @Test
    public void testarCalcularMDCQuandoUmDosNumerosEhNegativo(){
        assertEquals(0, Principal01.calcularMDC(-13, 38));
    }


}
