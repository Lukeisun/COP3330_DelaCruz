import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testBMIUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(71, 100);
        assertEquals("User is underweight: < 18.5", bmi.BMICat());
    }
    @Test
    public void testBMINormalweight(){
        BodyMassIndex bmi = new BodyMassIndex(71, 150);
        assertEquals("User is normal weight: 18.5 - 24.9", bmi.BMICat());
    }
    @Test
    public void testBMIOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(71, 190);
        assertEquals("User is overweight: 25-29.9", bmi.BMICat());
    }
    @Test
    public void testBMIObese(){
        BodyMassIndex bmi = new BodyMassIndex(71, 250);
        assertEquals("User is obese: >= 30", bmi.BMICat());
    }
    
    @Test
    public void testBMIScoreObese(){
        BodyMassIndex bmi = new BodyMassIndex(71, 250);
        assertEquals(34.9, bmi.BMIScore());

    }
    @Test
    public void testBMIScoreOver(){
        BodyMassIndex bmi = new BodyMassIndex(71,190);
        assertEquals(26.5, bmi.BMIScore());
    }
    @Test
    public void testBMIScoreNormal(){
        BodyMassIndex bmi = new BodyMassIndex(71, 150);
        assertEquals(20.9,bmi.BMIScore());
    }
    @Test
    public void testBMIScoreUnder() {
        BodyMassIndex bmi = new BodyMassIndex(71, 100);
        assertEquals(13.9,bmi.BMIScore());
    }
}