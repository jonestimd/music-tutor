package io.github.jonestimd.android.music;

import android.graphics.Canvas;
import android.graphics.Paint;

public enum Staff {
    TREBLE(Clef.G, 1, NoteName.B, R.array.treble_hints),
    BASS(Clef.F, -1, NoteName.D, R.array.bass_hints);

    private final Clef clef;
    private final int centerOffset;
    private final NoteName centerNote;
    public final int reviewHintsId;

    Staff(Clef clef, int centerOffset, NoteName centerNote, int reviewHintsId) {
        this.clef = clef;
        this.centerOffset = centerOffset;
        this.centerNote = centerNote;
        this.reviewHintsId = reviewHintsId;
    }

    /**
     * Draw the staff centered on the y axis.
     */
    public void draw(Canvas canvas, float spacing, int left, int width, Paint paint) {
        for (int y = -2; y < 3; y++) {
            canvas.drawLine(left, y*spacing, left+width, y*spacing, paint);
        }
        canvas.save();
        canvas.translate(width/5, spacing * centerOffset);
        clef.draw(canvas, spacing, paint);
        canvas.restore();
    }

    public NoteName noteName(int centerOffset) {
        int index = (centerNote.ordinal() - centerOffset) % NoteName.values().length;
        if (index < 0) index += NoteName.values().length;
        return NoteName.values()[index];
    }
}
