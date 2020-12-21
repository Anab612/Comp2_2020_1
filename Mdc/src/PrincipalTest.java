import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrincipalTest {

    @Test
    public void testarCalcularMdc(){

        assertEquals(5, Principal.calcularMDC(15, 10));
        assertEquals(2, Principal.calcularMDC(2, 1234));
    }

    @Test
    public void testarCalcularMdcQuandoUImDosNumerosEhNegativo(){
        assertEquals(0, Principal.calcularMDC(-14, 45));
    }


}
