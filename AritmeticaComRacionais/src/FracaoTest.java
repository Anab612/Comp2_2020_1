import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FracaoTest {

    @Test
    public void testarSimplificacao(){

        Fracao fracao = new Fracao(4, 6);

        assertEquals(4, fracao.getNumerador());
        assertEquals(6, fracao.getDenominador());

        fracao.simplificar();

        assertEquals(2, fracao.getNumerador());
        assertEquals(3, fracao.getDenominador());
    }

    @Test
    public void testarToStringAmbosPositivos() {

        Fracao fracao = new Fracao(4, 6);
        assertEquals("4/6", fracao.toString());
    }

    @Test
    public void testarToStringComNumeradorNegativo() {
        Fracao fracao = new Fracao(-4, 6);
        assertEquals("-4/6", fracao.toString());
    }

    @Test
    public void testarToStringComNumeradorEDenominadorNegativo() {
        Fracao fracao = new Fracao(-4, -6);
        assertEquals("4/6", fracao.toString());
    }

    @Test
    public void testarToStringComDenominadorNegativo() {
        Fracao fracao = new Fracao(4, -6);
        assertEquals("-4/6", fracao.toString());
    }

    @Test
    public void testarToStringComDenominadorUnitario(){
        Fracao fracao = new Fracao(5, 1);
        assertEquals("5", fracao.toString());
    }
}
