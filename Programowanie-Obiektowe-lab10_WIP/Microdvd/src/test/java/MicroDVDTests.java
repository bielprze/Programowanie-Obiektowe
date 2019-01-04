import org.junit.Test;
import org.junit.Assert;

public class MicroDVDTests {

    final static double DELTA = 1.e-15;

    @Test
    public void ms_to_framesTest()
    {
        MicroDVD m = new MicroDVD("", "", 1000, 60);
        int result = m.ms_to_frames(60, 1000);

        Assert.assertEquals("Test przeliczenia opóźnienia w ms na opóźnienie w klatkach", 60,result,DELTA);
    }

    @Test
    public void delay_beginningTest()
    {
        MicroDVD m = new MicroDVD("", "", 1000, 60);
        String for_test = "{340}{539} Na wysokości 600 kilometrów temperatura...";
        m.setLine(for_test);
        if()
        int result =
        Assert.assertEquals("Test sprawdza czy moment pojawienia się napisu zmienia się poprawnie", 1,result,DELTA);

    }

    @Test
    public void delay_endingTest()
    {

    }
}
