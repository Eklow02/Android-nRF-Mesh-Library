package no.nordicsemi.android.mesh.transport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import no.nordicsemi.android.mesh.opcodes.ApplicationMessageOpCodes;
import no.nordicsemi.android.mesh.utils.ArrayUtils;
import no.nordicsemi.android.mesh.utils.BitReader;

public class TimeStatus extends ApplicationStatusMessage implements Parcelable {

    private static final String TAG = TimeStatus.class.getSimpleName();
    private static final int OP_CODE = ApplicationMessageOpCodes.TIME_STATUS;

    private static final Creator<TimeStatus> CREATOR = new Creator<TimeStatus>() {
        @Override
        public TimeStatus createFromParcel(Parcel in) {
            final AccessMessage message = in.readParcelable(AccessMessage.class.getClassLoader());
            //noinspection ConstantConditions
            return new TimeStatus(message);
        }

        @Override
        public TimeStatus[] newArray(int size) {
            return new TimeStatus[size];
        }
    };

    private Integer taiSeconds;
    private byte subSecond;
    private byte uncertainty;
    private boolean timeAuthority;
    private short utcDelta;
    private byte timeZoneOffset;


    public TimeStatus(@NonNull final AccessMessage message) {
        super(message);
        this.mParameters = message.getParameters();
        parseStatusParameters();
    }


    @Override
    void parseStatusParameters() {
        BitReader bitReader = new BitReader(ArrayUtils.reverseArray(mParameters));
        taiSeconds = bitReader.getBits(40);
        subSecond = (byte) bitReader.getBits(8);
        uncertainty = (byte) bitReader.getBits(8);
        timeAuthority = bitReader.getBits(1) == 1;
        utcDelta = (short) bitReader.getBits(15);
        timeZoneOffset = (byte) bitReader.getBits(8);
        Log.v(TAG, "Time status has taiSeconds: "+taiSeconds);
        Log.v(TAG, "Time status has subSecond: "+subSecond);
        Log.v(TAG, "Time status has uncertainty: "+uncertainty);
        Log.v(TAG, "Time status has timeAuthority: "+timeAuthority);
        Log.v(TAG, "Time status has utcDelta: "+utcDelta);
        Log.v(TAG, "Time status has timeZoneOffset: "+timeZoneOffset);
    }

    @Override
    public int getOpCode() {
        return OP_CODE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        final AccessMessage message = (AccessMessage) mMessage;
        dest.writeParcelable(message, flags);
    }

    public Integer getTaiSeconds() {
        return taiSeconds;
    }

    public byte getSubSecond() {
        return subSecond;
    }

    public byte getUncertainty() {
        return uncertainty;
    }

    public boolean isTimeAuthority() {
        return timeAuthority;
    }

    public short getUtcDelta() {
        return utcDelta;
    }

    public byte getTimeZoneOffset() {
        return timeZoneOffset;
    }
}
