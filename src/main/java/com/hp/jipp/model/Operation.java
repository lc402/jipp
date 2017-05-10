package com.hp.jipp.model;

import com.google.auto.value.AutoValue;
import com.hp.jipp.encoding.NameCodeType;
import com.hp.jipp.encoding.NameCode;

/**
 * An operation code as found in request packets and elsewhere.
 *
 * @see <a href="https://tools.ietf.org/html/rfc2911#section-5.2.2">RFC2911 Section 5.2.2</a>
 */
@AutoValue
public abstract class Operation extends NameCode {
    public static final Operation PrintJob = of("Print-Job", 0x0002);
    public static final Operation PrintUri = of("Print-URI", 0x0003);
    public static final Operation ValidateJob = of("Validate-Job", 0x0004);
    public static final Operation CreateJob = of("Create-Job", 0x0005);
    public static final Operation SendDocument = of("Send-Document", 0x0006);
    public static final Operation SendUri = of("Send-URI", 0x0007);
    public static final Operation CancelJob = of("Cancel-Job", 0x0008);
    public static final Operation GetJobAttributes = of("Get-Job-Attributes", 0x0009);
    public static final Operation GetJobs = of("Get-Jobs", 0x000A);
    public static final Operation GetPrinterAttributes = of("Get-Printer-Attributes", 0x000B);
    public static final Operation HoldJob = of("Hold-Job", 0x000C);
    public static final Operation ReleaseJob = of("Release-Job", 0x000D);
    public static final Operation RestartJob = of("Restart-Job", 0x000E);
    public static final Operation PausePrinter = of("Pause-Printer", 0x0010);
    public static final Operation ResumePrinter = of("Resume-Printer", 0x0011);
    public static final Operation PurgeJobs = of("Purge-Jobs", 0x0012);
    public static final Operation CloseJob = of("Close-Job", 0x003B);
    public static final Operation IdentifyPrinter = of("Identify-Printer", 0x003C);

    /** The encoder for converting integers to Operation objects */
    public static final NameCodeType.Encoder<Operation> ENCODER = NameCodeType.Encoder.of(
            Operation.class, new NameCode.Factory<Operation>() {
                @Override
                public Operation of(String name, int code) {
                    return Operation.of(name, code);
                }
            });

    /** Create and return a {@link NameCodeType} based on this NameCode */
    public static NameCodeType<Operation> typeOf(String attributeName) {
        return new NameCodeType<>(ENCODER, attributeName);
    }

    /**
     * Returns a new instance
     * @param name human-readable name of the the operation
     * @param code machine-readable identifier for the operation
     */
    public static Operation of(String name, int code) {
        return new AutoValue_Operation(name, code);
    }
}
