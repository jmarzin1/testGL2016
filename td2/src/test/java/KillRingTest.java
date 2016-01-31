import org.junit.Test;

import java.nio.BufferOverflowException;
import java.util.Collections;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class KillRingTest {


    @Test(expected = BufferOverflowException.class)
    public void addElt_BufferAlreadyFull_ThrowException() {
        KillRing killRing = new KillRing(new LinkedList<String>(Collections.nCopies(KillRing.TAILLE_MAX, "Test")));
        killRing.addElt("Test");
    }

    @Test
    public void addElt_BufferNearlyFull_NoException() {
        KillRing killRing = new KillRing(new LinkedList<String>(Collections.nCopies(KillRing.TAILLE_MAX - 1, "Test")));
        killRing.addElt("Test");
    }

    @Test
    public void isEmpty_JustCreatedBuffer_True() {
        KillRing killRing = new KillRing();
        assertThat(killRing.isEmpty(), is(true));
    }


    @Test
    public void currentElt_OneElement_CurrentElement() {
        KillRing killRing = new KillRing();
        killRing.addElt("Test");
        assertThat(killRing.currentElt(), is(equalTo("Test")));
    }

    @Test
    public void rotateForward_BufferWithTwoElement_FirstElementAdded() {
        KillRing killRing = new KillRing();
        killRing.addElt("Test1");
        killRing.addElt("Test2");
        assertThat(killRing.currentElt(), is(equalTo("Test2")));
        killRing.rotateForward();
        assertThat(killRing.currentElt(), is(equalTo("Test1")));

    }


}
