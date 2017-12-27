package io.github.jonestimd.android.music;

import io.github.jonestimd.android.quiz.activity.ResourceId;

public enum Duration implements ResourceId {
    WHOLE(0, R.string.whole_duration),
    HALF(0, R.string.half_duration),
    QUARTER(0, R.string.quarter_duration),
    EIGHTH(1, R.string.eighth_duration),
    SIXTEENTH(2, R.string.sixteenth_duration),
    THIRTYSECOND(3, R.string.thritysecond_duration),
    SIXTYFOURTH(4, R.string.sixtyfourth_duration);

    private final int denominator;
    private final int flags;
    private final int resourceId;

    Duration(int flags, int resourceId) {
        this.denominator = 1 << ordinal();
        this.flags = flags;
        this.resourceId = resourceId;
    }

    public int denominator() {
        return denominator;
    }

    public int flags() {
        return flags;
    }

    public int resourceId() {
        return resourceId;
    }
}