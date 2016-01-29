package td3;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestEditor {
    private MockBuffer buffer;
    private MockKillRing killRing;
    private Editor editor;

    @Before
    public void initializeObjects() {
        buffer = new MockBuffer("");
        killRing = new MockKillRing();
        editor = new Editor(buffer, killRing);
    }

    @Test
	public void testKillRingSave() {
		editor.killRingSave();
		assertThat(buffer.trace, is(equalTo("MockBuffer():substring(-1, 0):")));
		assertThat(killRing.trace, is(equalTo("MockKillRing():addElt():")));
	}

    @Test
    public void testKillRegion(){
        editor.setCursor(11);
        editor.setMark(16);
        editor.killRegion();
        assertThat(buffer.trace, is(equalTo("MockBuffer():maxPosition():maxPosition():maxPosition():maxPosition():" +
                "substring(0, 0):delete(0, 0):")));
        assertThat(killRing.trace, is(equalTo("MockKillRing():addElt():")));
    }

    @Test
    public void testYank() {
        try {

            editor.yank();
            assertThat(buffer.trace, is(equalTo("MockBuffer():insert(elt, 0):")));
            assertThat(killRing.trace, is(equalTo("MockKillRing():isEmpty():currentElt():")));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
