package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    public Polynomial firstPolynomial = new Polynomial();
    public Polynomial secondPolynomial = new Polynomial() ;
    public Operations operation = new Operations(firstPolynomial);
    private static int nrTesteExec = 0;
    private static int nrTesteCuSucces = 0;

    public OperationsTest(){
        System.out.println("Testare operatii");
    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Incepe testarea calculatorului de polinoame!");
        System.out.println();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("S-a  terminat testarea calculatorului de polinoame");
        System.out.println("S-au executat " + nrTesteExec + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExec++;
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
        System.out.println();
    }

    @Test
    void addOp() {
        firstPolynomial.addInList("2x^2+3x^1+5");

        secondPolynomial.addInList("3x^2+5x^1+2");
        assertEquals("5x^2+8x^1+7", operation.addOp(secondPolynomial).toString());
        assertNotEquals("10x^2+5x^1+12", operation.addOp(secondPolynomial).toString());

        secondPolynomial.addInList("3x^2+5x^1+4");
        assertEquals("5x^2+8x^1+9", operation.addOp(secondPolynomial).toString());
        assertNotEquals("5x^2+8x^1+7", operation.addOp(secondPolynomial).toString());

        nrTesteCuSucces++;
    }

    @Test
    void subtractOp() {
        firstPolynomial.addInList("5x^2+8x^1+5");

        secondPolynomial.addInList("3x^2+5x^1+2");
        assertEquals("2x^2+3x^1+3", operation.subtractOp(secondPolynomial).toString());
        assertNotEquals("10x^2+5x^1+12", operation.subtractOp(secondPolynomial).toString());

        secondPolynomial.addInList("3x^2+5x^1+4");
        assertEquals("2x^2+3x^1+1", operation.subtractOp(secondPolynomial).toString());
        assertNotEquals("5x^2+8x^1+7", operation.subtractOp(secondPolynomial).toString());

        nrTesteCuSucces++;
    }

    @Test
    void integrateOp() {
        firstPolynomial.addInList("4x^3+3x^2+2x^1+2");
        assertEquals("x^4+x^3+x^2+2x^1", operation.integrateOp().toString());
        assertNotEquals("10x^2+5x^1+12", operation.integrateOp().toString());

        firstPolynomial.addInList("3x^2+5x^1+4");
        assertNotEquals("2x^2+3x^1+1", operation.integrateOp().toString());
        assertNotEquals("5x^2+8x^1+7", operation.integrateOp().toString());

        nrTesteCuSucces++;
    }

    @Test
    void derivateOp() {
        firstPolynomial.addInList("4x^3+3x^2+2x^1+2");
        assertEquals("12x^2+6x^1+2", operation.derivateOp().toString());
        assertNotEquals("10x^2+5x^1+12", operation.derivateOp().toString());

        firstPolynomial.addInList("4x^4+3x^2+2x^1+2");
        assertEquals("16x^3+6x^1+2", operation.derivateOp().toString());
        assertNotEquals("10x^4+3x^1+8", operation.derivateOp().toString());

        nrTesteCuSucces++;
    }

    @Test
    void multiplyOp() {
        firstPolynomial.addInList("2x^2+3x^1+5");

        secondPolynomial.addInList("2x^2");
        assertEquals("4x^4+6x^3+10x^2", operation.multiplyOp(secondPolynomial).toString());
        assertNotEquals("4x^4+6x^3+10x^2+10x", operation.multiplyOp(secondPolynomial).toString());

        secondPolynomial.addInList("3x^1");
        assertEquals("6x^3+9x^2+15x^1", operation.multiplyOp(secondPolynomial).toString());
        assertNotEquals("5x^2+8x^1+7", operation.multiplyOp(secondPolynomial).toString());

        nrTesteCuSucces++;
    }

    @Test
    void divideOp() {
        firstPolynomial.addInList("x^3-2x^2+6x^1-5");

        secondPolynomial.addInList("x^2-1");
        assertEquals("x^1-2", operation.divideOp(secondPolynomial).get(0).toString());
        assertEquals("7x^1-7", operation.divideOp(secondPolynomial).get(1).toString());

        assertNotEquals("2x^1-7", operation.divideOp(secondPolynomial).get(0).toString());
        assertNotEquals("2x^2-7x^1-7", operation.divideOp(secondPolynomial).get(1).toString());

        nrTesteCuSucces++;
    }
}