package io.github.jonestimd.android.music;

import io.github.jonestimd.android.quiz.activity.ResourceId;

public enum NoteName implements ResourceId {
    A(R.string.note_a),
    B(R.string.note_b),
    C(R.string.note_c),
    D(R.string.note_d),
    E(R.string.note_e),
    F(R.string.note_f),
    G(R.string.note_g);

    private final int resourceId;

    NoteName(int resourceId) {
        this.resourceId = resourceId;
    }

    public int resourceId() {
        return resourceId;
    }
}