import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class BufferTest {

    @Test
    public void toString_BasicString_NoProblem() {
        Buffer buffer = new Buffer("Test");
        String bufferToString = buffer.toString();
        assertThat(bufferToString, is(equalTo("Test")));
    }

    @Test
    public void substring_SubstringInTheBuffer_GoodPartOfTheBuffer() {
        Buffer buffer = new Buffer("Test");
        assertThat(buffer.substring(1, 4), is(equalTo("est")));
    }

    @Test
    public void substring_OutOfBufferAtTheRight_StopAtTheEnd() {
        Buffer buffer = new Buffer("Test");
        assertThat(buffer.substring(1, 7), is(equalTo("est")));
    }

    @Test
    public void substring_OutOfBufferAtTheLeft_StartAtTheBeginning() {
        Buffer buffer = new Buffer("Test");
        assertThat(buffer.substring(-2, 3), is(equalTo("Tes")));
    }

    @Test
    public void maxPosition_NoArgument_NoProblem() {
        Buffer buffer = new Buffer("Test");
        assertThat(buffer.maxPosition(), is(equalTo(4)));
    }

    @Test
    public void insert_StandardPosition_InsertionSuccessful() {
        Buffer buffer = new Buffer("Test");
        buffer.insert("String", 3);
        assertThat(buffer.toString(), is(equalTo("TesStringt")));
    }

    @Test
    public void insert_ToBigPosition_NoInsertion() {
        Buffer buffer = new Buffer("Test");
        buffer.insert("String", 6);
        assertThat(buffer.toString(), is(equalTo("Test")));
    }

    @Test
    public void insert_ToSmallPosition_NoInsertion() {
        Buffer buffer = new Buffer("Test");
        buffer.insert("String", -3);
        assertThat(buffer.toString(), is(equalTo("Test")));
    }

    @Test
    public void delete_StandardPosition_InsertionSuccessful() {
        Buffer buffer = new Buffer("Test");
        buffer.delete(1, 3);
        assertThat(buffer.toString(), is(equalTo("Tt")));
    }

}
