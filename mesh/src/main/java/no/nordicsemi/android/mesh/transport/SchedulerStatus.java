package no.nordicsemi.android.mesh.transport;

import android.os.Parcel;
import android.os.Parcelable;
import no.nordicsemi.android.mesh.logger.MeshLogger;

import androidx.annotation.NonNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.nordicsemi.android.mesh.data.ScheduleEntry;
import no.nordicsemi.android.mesh.opcodes.ApplicationMessageOpCodes;
import no.nordicsemi.android.mesh.utils.ArrayUtils;
import no.nordicsemi.android.mesh.utils.BitReader;
import no.nordicsemi.android.mesh.utils.MeshAddress;

public class SchedulerStatus extends ApplicationStatusMessage implements Parcelable {

    private static final String TAG = SchedulerStatus.class.getSimpleName();
    private static final int OP_CODE = ApplicationMessageOpCodes.SCHEDULER_STATUS;
    private List<Integer> schedules = Collections.emptyList();

    private static final Creator<SchedulerStatus> CREATOR = new Creator<SchedulerStatus>() {
        @Override
        public SchedulerStatus createFromParcel(Parcel in) {
            final AccessMessage message = in.readParcelable(AccessMessage.class.getClassLoader());
            //noinspection ConstantConditions
            return new SchedulerStatus(message);
        }

        @Override
        public SchedulerStatus[] newArray(int size) {
            return new SchedulerStatus[size];
        }
    };

    /**
     * Scheduler Status is an unacknowledged message used to report the current Schedule Register state of an element (see Mesh Model Spec. v1.0.1 Section 5.1.4.2).
     *
     * @param message Access Message containing tht schedules
     */
    public SchedulerStatus(@NonNull final AccessMessage message) {
        super(message);
        this.mParameters = message.getParameters();
        parseStatusParameters();
    }

    @Override
    void parseStatusParameters() {
        MeshLogger.verbose(TAG, "Received scheduler status from: " + MeshAddress.formatAddress(mMessage.getSrc(), true));
        final BitReader bitReader = new BitReader(ArrayUtils.reverseArray(mParameters));
        List<Integer> scheduler = new ArrayList<>();
        for (int i = 0; i <= 15; i++){
            scheduler.add(bitReader.getBits(1));
        }
        this.schedules = scheduler;
        MeshLogger.verbose(TAG, "Schedules action: " + schedules);
    }

    @Override
    public int getOpCode() {
        return OP_CODE;
    }

    /**
     * Bit field indicating defined Actions in the `Schedule Register`
     * Each bit of the Schedules field set to 1 identifies a corresponding entry of the Schedule Register
     */
    public List<Integer> getSchedules() {
        return schedules;
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
}
