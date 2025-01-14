package no.nordicsemi.android.mesh.transport;

/**
 * Abstract wrapper class for mesh message.
 */
public abstract class ProxyConfigMessage extends MeshMessage {

    /**
     * Creates the parameters for a given mesh message.
     */
    abstract void assembleMessageParameters();

    /**
     * Returns the parameters of this message.
     *
     * @return parameters
     */
    abstract byte[] getParameters();


    @Override
    int getAkf() {
        return -1;
    }

    @Override
    int getAid() {
        return -1;
    }

}
