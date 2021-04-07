package no.nordicsemi.android.mesh.transport;

import org.junit.Test;

import no.nordicsemi.android.mesh.ApplicationKey;
import no.nordicsemi.android.mesh.data.GenericTransitionTime;
import no.nordicsemi.android.mesh.utils.MeshParserUtils;

import static org.junit.Assert.assertEquals;

public class ConfigDefaultTransitionSetTest {

    final ApplicationKey applicationKey = new ApplicationKey(MeshParserUtils.hexToInt("0456"), MeshParserUtils.toByteArray("63964771734fbd76e3b40519d1d94a48"));

    @Test
    public void test_reading_data(){
        GenericTransitionTime genericTransitionTime = new GenericTransitionTime(0x33);

        GenericDefaultTransitionTimeSet genericDefaultTransitionTimeSet = new GenericDefaultTransitionTimeSet(applicationKey, genericTransitionTime);

        assertEquals(1, genericDefaultTransitionTimeSet.mParameters.length);
    }
}
