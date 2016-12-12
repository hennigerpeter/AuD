import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

//import java.math.BigInteger;


//TODO throw away complex public tests that have long call chains
//but keep get/set parts
//TODO pick parts of the secret tests for new public test
public class AwesomAvatarPublicTest {


    @Test(timeout = 500)
    public void checkGetters1() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int s = aGet.getStrength();
    }

    @Test(timeout = 500)
    public void checkGetters2() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int i = aGet.getIntelligence();
    }

    @Test(timeout = 500)
    public void checkGetters3() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int e = aGet.getExperience();
    }

    @Test(timeout = 500)
    public void checkGetters4() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int m = aGet.getMana();
    }

    @Test(timeout = 500)
    public void checkGetters5() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int lp = aGet.getLifePoints();
    }

    @Test(timeout = 500)
    public void checkGetters6() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int mlp = aGet.getMaxLifePoints();
    }

    @Test(timeout = 500)
    public void checkGetters7() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        int mm = aGet.getMaxMana();
    }

    @Test(timeout = 500)
    public void checkGetters8() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        int d = w4.getDamage();
    }

    @Test(timeout = 500)
    public void checkGetters9() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        int w = w4.getWear();
    }

    @Test(timeout = 500)
    public void checkGetters10() {
        AwesomSpell sGet = new AwesomSpell(1);
        int d = sGet.getDamage();
    }

    @Test(timeout = 500)
    public void checkGetters11() {
        AwesomSpell sGet = new AwesomSpell(1);
        int c = sGet.getCost();
    }

    @Test(timeout = 500)
    public void checkSetters10() {
        AwesomWeapon w3 = new AwesomWeapon(4, 4);
        AwesomAvatar a3 = new AwesomAvatar(5, 2, 3, w3);
        AwesomWeapon w = a3.getWeapon();
    }

    @Test(timeout = 500)
    public void checkSetters1() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        aGet.setStrength(1);
    }

    @Test(timeout = 500)
    public void checkSetters2() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        aGet.setIntelligence(1);
    }

    @Test(timeout = 500)
    public void checkSetters3() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        aGet.setExperience(1);
    }

    @Test(timeout = 500)
    public void checkSetters4() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        aGet.setMana(1);
    }

    @Test(timeout = 500)
    public void checkSetters5() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);
        aGet.setLifePoints(1);
    }

    @Test(timeout = 500)
    public void checkSetters6() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        w4.setDamage(1);
    }

    @Test(timeout = 500)
    public void checkSetters7() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        w4.setWear(1);
    }

    @Test(timeout = 500)
    public void checkSetters8() {
        AwesomSpell sGet = new AwesomSpell(1);
        sGet.setDamage(1);
    }

    @Test(timeout = 500)
    public void checkSetters9() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);

        aGet.setWeapon(w4);
    }

    @Test(timeout = 500)
    public void checkRemoveLifePoints() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);

        aGet.removeLifePoints(1);
    }

    @Test(timeout = 500)
    public void checkLevelUp() {
        AwesomWeapon w4 = new AwesomWeapon(4, 4);
        AwesomAvatar aGet = new AwesomAvatar(1, 1, 1, w4);

        aGet.levelUp();
    }

    @Test(timeout = 500)
    public void checkAttack() {
        AwesomWeapon w = new AwesomWeapon(4, 4);

        int x = w.attack();
    }

    @Test(timeout = 500)
    public void testMain1() {
        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        assertEquals("Lifepoints a1 before attack: ", 20, a1.getLifePoints());
    }

    @Test(timeout = 500)
    public void testMain2() {
        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);
        a2.attack(a1);
        assertEquals("Lifepoints a1 after attack: ", 14, a1.getLifePoints());
    }

    @Test(timeout = 500)
    public void testMain3() {
        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        assertEquals("Wear of a2 weapon after attack: ", 6, a2.getWeapon().getWear());
    }

    @Test(timeout = 500)
    public void testMain4() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        assertEquals("Wear of a2 weapon after spell: ", 5, a2.getWeapon().getWear());
    }

    @Test(timeout = 500)
    public void testMain5() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        assertEquals("Experience a1 before attacks: ", 5, a1.getExperience());
    }

    @Test(timeout = 500)
    public void testMain6() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        assertEquals("Strength a1 before attacks: ", 4, a1.getStrength());
    }

    @Test(timeout = 500)
    public void testMain7() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        assertEquals("Experience a1 after attacks: ", 13, a1.getExperience());
    }

    @Test(timeout = 500)
    public void testMain8() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        assertEquals("Strength a1 after attacks: ", 5, a1.getStrength());
    }

    @Test(timeout = 500)
    public void testMain9() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        assertEquals("Lifepoints a2 after 3 attacks: ", 0, a2.getLifePoints());
    }

    @Test(timeout = 500)
    public void testMain10() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        assertEquals("Damage of weapon of a1 after killing a2: ", 8, a1.getWeapon().getDamage());
    }

    @Test(timeout = 500)
    public void testMain11() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        assertEquals("Experience a1 after savagely attacking the dead body of a2 again: ", 21, a1.getExperience());
    }

    @Test(timeout = 500)
    public void testMain12() {

        AwesomWeapon w1 = new AwesomWeapon(8, 8);
        AwesomWeapon w2 = new AwesomWeapon(6, 7);
        AwesomSpell s1 = new AwesomSpell(1);
        AwesomAvatar a1 = new AwesomAvatar(4, 3, 5, w1);
        AwesomAvatar a2 = new AwesomAvatar(3, 5, 8, w2);

        a2.attack(a1);
        a1.castSpell(a2, s1);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        a1.attack(a2);
        a2.rest();
        assertEquals("Lifepoints a2 after resting: ", 24, a2.getLifePoints());
    }

    public static void main(String args[]) {
        // to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
        // to run on command line: java -cp .:/usr/share/java/junit4.jar AwesomAvatarPublicTest

        // starts junit runner - don't try to understand!
        org.junit.runner.JUnitCore.main(new Object() {
        }.getClass().getEnclosingClass().getSimpleName());
    }
}
