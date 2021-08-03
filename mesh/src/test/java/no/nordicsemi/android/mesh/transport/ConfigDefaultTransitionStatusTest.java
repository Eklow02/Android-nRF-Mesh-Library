package no.nordicsemi.android.mesh.transport;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import no.nordicsemi.android.mesh.data.GenericTransitionTime;

import static org.junit.Assert.assertEquals;

public class ConfigDefaultTransitionStatusTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    byte[] data = new byte[]{(byte)0x61};

    @Mock
    AccessMessage accessMessage;

    @Test
    public void test_reading_data() {
        GenericTransitionTime expected = new GenericTransitionTime(GenericTransitionTime.TransitionResolution.SECOND, GenericTransitionTime.TransitionStep.Specific(33));

        Mockito.when(accessMessage.getParameters()).thenReturn(data);
        GenericDefaultTransitionTimeStatus sut = new GenericDefaultTransitionTimeStatus(accessMessage);

        assertEquals(sut.getGenericTransitionTime(), expected);
    }
}
