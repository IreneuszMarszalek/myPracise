import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DisplayOnConsoleTest {

  private DisplayOn sut;

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  /*
  In the setup method, we reassign the standard output stream to a new PrintStream with a ByteArrayOutputStream.
  As we're going to see this output stream is where the values will now be printed:
  */
  @BeforeEach
  public void setup(){
    System.setOut(new PrintStream(outputStreamCaptor));
    sut = new DisplayOnConsole();
  }

  /*
  As the standard output stream is a shared static resource used by other parts of the system,
  we should take care of restoring it to its original state when our test terminates:
   */
  @BeforeEach
  public void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void shouldDisplayNothingToDisplay_ArgumentIsNull () {
    String[] testMessages = null;
    sut.display(testMessages);
    assertEquals("Nothing to display", outputStreamCaptor.toString().trim());

    /*
    After we call the print method with the chosen text,
    we can then verify that the outputStreamCaptor contains the content we were expecting.
    We call the trim method to remove the new line that System.out.println() adds.
     */
  }

  @Test
  void shouldDisplayAniaBartekKasia () {
    String[] testMessages = {"Ania", "Bartek", "Kasia"};
    sut.display(testMessages);
    assertEquals("Ania\r\nBartek\r\nKasia", outputStreamCaptor.toString().trim());
  }

  @Test
  void shouldDisplayAniaBartek_firstArgumentIsNull () {
    String[] testMessages = {null, "Ania", "Bartek"};
    sut.display(testMessages);
    assertEquals("Ania\r\nBartek", outputStreamCaptor.toString().trim());
  }

  @Test
  void shouldDisplayAniaBartek_lastArgumentIsNull () {
    String[] testMessages = {"Ania", "Bartek", null};
    sut.display(testMessages);
    assertEquals("Ania\r\nBartek", outputStreamCaptor.toString().trim());
  }

  @Test
  //TODO: Add generic types
  void shouldDisplayNothingInCaseOfTypeDifferentThanStringCharByteShortIntLongFloatDouble () {
    assertEquals(1,0);
  }

  @Test
    //TODO: Add generic types
  void shouldDisplay_1_Ania_TwoDifferentTypesByteString () {
    assertEquals(1,0);
  }

  @Test
    //TODO: Add generic types
  void shouldDisplay_999999_X_TwoDifferentTypesLongChar () {
    assertEquals(1,0);
  }

  @Test
    //TODO: Add generic types
  void shouldDisplay_11coma11_66coma66_TwoDifferentTypesFloatDouble () {
    assertEquals(1,0);
  }
}