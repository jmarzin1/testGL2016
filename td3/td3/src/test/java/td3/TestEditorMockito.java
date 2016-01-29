package td3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class TestEditorMockito {
    Buffer bufferMock;
    KillRing killRingMock;
    Editor editor;

    @Before
    public void initialize() {
        bufferMock = mock(Buffer.class);
        killRingMock = mock(KillRing.class);
        editor = new Editor(bufferMock, killRingMock);
    }

    @Test(expected=IllegalAccessException.class)
    public void testYankPopAlone() throws IllegalAccessException {
            editor.yankPop();
    }

    @Test
    public void testYankPop() {
        when(killRingMock.isEmpty()).thenReturn(false);
        when(killRingMock.currentElt()).thenReturn("element");
        try {
            editor.yankMode = true;
            editor.yankPop();
            Mockito.verify(killRingMock, Mockito.times(1)).isEmpty();
            Mockito.verify(killRingMock, Mockito.times(1)).rotateForward();
            Mockito.verify(killRingMock, Mockito.times(1)).currentElt();
            Mockito.verify(bufferMock, Mockito.times(1)).delete(anyInt(), anyInt());
            Mockito.verify(bufferMock, Mockito.times(1)).insert(anyString(), anyInt());
            Mockito.verify(bufferMock).insert(Mockito.eq("element"), anyInt());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testKillRegion() {
        when(bufferMock.substring(anyInt(), anyInt())).thenReturn("testValue");
        editor.killRegion();
        Mockito.verify(killRingMock, Mockito.times(1)).addElt(anyString());
        Mockito.verify(bufferMock, Mockito.times(1)).delete(anyInt(), anyInt());
        Mockito.verify(bufferMock, Mockito.times(1)).substring(anyInt(), anyInt());
        Mockito.verify(killRingMock).addElt("testValue");
    }
}
