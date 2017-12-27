package io.github.jonestimd.android.music;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

import java.io.Serializable;

import io.github.jonestimd.android.quiz.activity.QuestionImage;
import io.github.jonestimd.android.quiz.graphics.PaintBuilder;

public class Note implements Serializable {
    private static final float WIDTH = 1.2f;
    private static final float LINE_HEIGHT = 3.5f;
    private static final float FLAG_SPACING= 0.5f;
    private static final float FLAG_OFFSET = 1.5f;
    private static final Paint STAFF_PAINT = new PaintBuilder().style(Style.STROKE).strokeWidth(1f).color(Color.BLACK).get();
    private static final Paint FILL_PAINT = new PaintBuilder().style(Style.FILL).color(Color.BLACK).get();
    private final float strokeWidth;
    private final int staffSpacing;
    private final Duration duration;
    private final Staff staff;
    private final int centerOffset;
    private final boolean filled;
    private final boolean line;
    private transient NoteImage image;

    public Note(Resources resources, int centerOffset, Duration duration) {
        this(resources, null, centerOffset, duration);
    }

    public Note(Resources resources, Staff staff, int centerOffset, Duration duration) {
        staffSpacing = resources.getDimensionPixelSize(R.dimen.staff_spacing);
        strokeWidth = resources.getDimensionPixelSize(R.dimen.note_stroke);
        this.duration = duration;
        this.staff = staff;
        this.centerOffset = centerOffset;
        this.filled = duration.denominator() > Duration.HALF.denominator();
        this.line = duration != Duration.WHOLE;
    }

    public NoteName getName() {
        return staff.noteName(centerOffset);
    }

    public Duration getDuration() {
        return duration;
    }

    public Staff getStaff() {
        return staff;
    }

    public int getCenterOffset() {
        return centerOffset;
    }

    public QuestionImage getImage() {
        if (image == null) {
            image = new NoteImage();
        }
        return image;
    }

    protected class NoteImage implements QuestionImage {
        private final Paint strokePaint = new PaintBuilder().style(Style.STROKE).strokeWidth(1.5f).color(Color.BLACK).strokeWidth(strokeWidth).get();
        private RectF head = new RectF();
        private RectF flagUp = new RectF();
        private RectF flagDown = new RectF();

        @Override
        public void initialize(AssetManager assetManager) {
        }

        @Override
        public void draw(Canvas canvas, int width, int height) {
            canvas.drawColor(Color.WHITE);
            scale();
            canvas.translate(0, height/2f);
            if (staff != null) {
                staff.draw(canvas, staffSpacing, 0, width, STAFF_PAINT);
            }
            translate(width/2 - (staff == null ? WIDTH * staffSpacing / 2 : 0),
                    staffSpacing * centerOffset / 2 + (staff == null && line ? staffSpacing : 0));
            drawNote(canvas, centerOffset > 0);
        }

        private void scale() {
            head.set(-1f, -staffSpacing/2, WIDTH * staffSpacing + 1f, staffSpacing/2);
            flagUp.set(staffSpacing * (WIDTH - 1), -staffSpacing * LINE_HEIGHT, staffSpacing * (WIDTH + 1), -staffSpacing * FLAG_OFFSET);
            flagDown.set(-staffSpacing, staffSpacing * FLAG_OFFSET, staffSpacing, staffSpacing * LINE_HEIGHT);
        }

        private void translate(float dx, float dy) {
            head.offset(dx, dy);
            flagUp.offset(dx, dy);
            flagDown.offset(dx, dy);
        }

        private void drawNote(Canvas canvas, boolean up) {
            float strokeWitdh = strokePaint.getStrokeWidth();
            canvas.drawOval(head, filled ? FILL_PAINT : strokePaint);

            if (line) {
                final float flagSpacing = duration == Duration.SIXTEENTH ? FLAG_SPACING * staffSpacing * 1.5f : FLAG_SPACING * staffSpacing;
                if (up) {
                    canvas.drawLine(flagUp.centerX()+strokeWitdh/2, head.centerY(), flagUp.centerX()+strokeWitdh/2, flagUp.top, strokePaint);
                    drawFlags(canvas, flagUp, -90f, flagSpacing);
                }
                else {
                    canvas.drawLine(flagDown.centerX(), head.centerY(), flagDown.centerX(), flagDown.bottom, strokePaint);
                    drawFlags(canvas, flagDown, -20f, -flagSpacing);
                }
            }
            for (int i = 6; i <= Math.abs(centerOffset); i+=2) {
                drawStaffOverflow(canvas, centerOffset < 0 ? -i : i);
            }
            if (staff == null) {
                drawStaffOverflow(canvas, centerOffset + (line ? 2 : 0));
            }
        }

        private void drawStaffOverflow(Canvas canvas, int centerOffset) {
            canvas.drawLine(head.left-staffSpacing/2, centerOffset * staffSpacing/2, head.right+staffSpacing/2, centerOffset * staffSpacing/2, STAFF_PAINT);
        }

        private void drawFlags(Canvas canvas, RectF flag, float startAngle, float spacing) {
            for (int i = 0; i < duration.flags(); i++) {
                canvas.drawArc(flag, startAngle, 112f, false, strokePaint);
                flag.offset(0, spacing);
            }
        }
    }
}