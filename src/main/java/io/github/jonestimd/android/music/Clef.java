package io.github.jonestimd.android.music;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;

import io.github.jonestimd.android.quiz.graphics.PaintBuilder;
import io.github.jonestimd.android.quiz.graphics.PathBuilder;

public enum Clef {
    F(new PathBuilder().moveTo(0.038f, 2.335f)
            .cubicTo(0f, 2.22f, 0.21f, 2.148f, 0.309f, 2.087f)
            .cubicTo(0.592f, 1.927f, 0.873f, 1.765f, 1.103f, 1.536f)
            .cubicTo(1.294f, 1.321f, 1.485f, 1.034f, 1.556f, 0.753f)
            .cubicTo(1.654f, 0.362f, 1.637f, -0.019f, 1.545f, -0.413f)
            .cubicTo(1.453f, -0.702f, 1.307f, -0.842f, 1.002f, -0.873f)
            .cubicTo(0.828f, -0.882f, 0.653f, -0.777f, 0.542f, -0.685f)
            .cubicTo(0.47f, -0.625f, 0.373f, -0.462f, 0.344f, -0.351f)
            .cubicTo(0.514f, -0.502f, 0.772f, -0.446f, 0.912f, -0.354f)
            .cubicTo(1.052f, -0.263f, 1.109f, -0.087f, 1.064f, 0.074f)
            .cubicTo(1.031f, 0.192f, 0.962f, 0.29f, 0.852f, 0.349f)
            .cubicTo(0.711f, 0.424f, 0.551f, 0.418f, 0.412f, 0.358f)
            .cubicTo(0.21f, 0.272f, 0.128f, 0.023f, 0.164f, -0.192f)
            .cubicTo(0.226f, -0.557f, 0.398f, -0.791f, 0.734f, -0.94f)
            .cubicTo(0.967f, -1.044f, 1.244f, -1.037f, 1.482f, -0.954f)
            .cubicTo(2.018f, -0.712f, 2.222f, -0.267f, 2.201f, 0.293f)
            .cubicTo(2.168f, 0.725f, 1.909f, 1.081f, 1.624f, 1.388f)
            .cubicTo(1.24f, 1.783f, 0.701f, 2.066f, 0.288f, 2.286f)
            .cubicTo(0.227f, 2.318f, 0.098f, 2.403f, 0.038f, 2.335f).moveTo(2.782f, -0.492f).close()
            .cubicTo(2.782f, -0.385f, 2.695f, -0.298f, 2.588f, -0.298f)
            .cubicTo(2.481f, -0.298f, 2.394f, -0.385f, 2.394f, -0.492f)
            .cubicTo(2.394f, -0.599f, 2.481f, -0.686f, 2.588f, -0.686f)
            .cubicTo(2.695f, -0.686f, 2.782f, -0.599f, 2.782f, -0.492f).moveTo(2.777f, 0.505f).close()
            .cubicTo(2.777f, 0.612f, 2.69f, 0.699f, 2.583f, 0.699f)
            .cubicTo(2.476f, 0.699f, 2.389f, 0.612f, 2.389f, 0.505f)
            .cubicTo(2.389f, 0.397f, 2.476f, 0.31f, 2.583f, 0.31f)
            .cubicTo(2.69f, 0.31f, 2.777f, 0.397f, 2.777f, 0.505f).close().get()),
    G(new PathBuilder().moveTo(0.79f, 2.524f)
            .cubicTo(0.612f, 2.431f, 0.498f, 2.253f, 0.483f, 2.051f)
            .cubicTo(0.463f, 1.794f, 0.609f, 1.611f, 0.862f, 1.553f)
            .cubicTo(1.068f, 1.505f, 1.297f, 1.611f, 1.369f, 1.82f)
            .cubicTo(1.428f, 1.989f, 1.368f, 2.178f, 1.243f, 2.297f)
            .cubicTo(1.146f, 2.392f, 1.055f, 2.415f, 0.926f, 2.421f)
            .cubicTo(1.121f, 2.487f, 1.276f, 2.471f, 1.368f, 2.456f)
            .cubicTo(1.576f, 2.423f, 1.721f, 2.324f, 1.792f, 2.191f)
            .cubicTo(1.831f, 2.12f, 1.871f, 2.04f, 1.866f, 1.856f)
            .cubicTo(1.86f, 1.672f, 1.788f, 1.259f, 1.742f, 0.969f)
            .cubicTo(1.64f, 0.982f, 1.491f, 1.001f, 1.368f, 1.002f)
            .cubicTo(1.044f, 1.005f, 0.7f, 0.894f, 0.447f, 0.692f)
            .cubicTo(0.327f, 0.602f, 0.234f, 0.483f, 0.158f, 0.353f)
            .cubicTo(0.033f, 0.128f, 0.021f, -0.044f, 0f, -0.296f)
            .cubicTo(-0.005f, -0.512f, 0.042f, -0.728f, 0.107f, -0.934f)
            .cubicTo(0.285f, -1.496f, 0.791f, -1.833f, 1.177f, -2.231f)
            .cubicTo(1.151f, -2.425f, 1.127f, -2.598f, 1.117f, -2.729f)
            .cubicTo(1.093f, -3.031f, 1.086f, -3.334f, 1.144f, -3.63f)
            .cubicTo(1.196f, -3.894f, 1.31f, -4.033f, 1.463f, -4.254f)
            .cubicTo(1.557f, -4.353f, 1.642f, -4.506f, 1.787f, -4.489f)
            .cubicTo(2.003f, -4.396f, 2.193f, -3.962f, 2.231f, -3.733f)
            .cubicTo(2.316f, -3.207f, 2.163f, -2.609f, 1.857f, -2.164f)
            .cubicTo(1.734f, -1.985f, 1.583f, -1.824f, 1.438f, -1.661f)
            .cubicTo(1.481f, -1.41f, 1.523f, -1.186f, 1.564f, -1.002f)
            .cubicTo(1.934f, -0.992f, 2.125f, -0.886f, 2.36f, -0.674f)
            .cubicTo(2.518f, -0.502f, 2.601f, -0.259f, 2.607f, -0.107f)
            .cubicTo(2.612f, 0.044f, 2.557f, 0.257f, 2.489f, 0.385f)
            .cubicTo(2.448f, 0.463f, 2.399f, 0.534f, 2.314f, 0.631f)
            .cubicTo(2.229f, 0.728f, 2.058f, 0.861f, 1.919f, 0.927f)
            .cubicTo(1.962f, 1.252f, 2.027f, 1.528f, 2.039f, 1.85f)
            .cubicTo(2.046f, 2.064f, 1.982f, 2.201f, 1.911f, 2.294f)
            .cubicTo(1.79f, 2.451f, 1.619f, 2.579f, 1.405f, 2.604f)
            .cubicTo(1.192f, 2.629f, 0.976f, 2.621f, 0.79f, 2.524f).close().moveTo(1.718f, 0.836f)
            .cubicTo(1.641f, 0.398f, 1.568f, -0.042f, 1.488f, -0.48f)
            .cubicTo(1.357f, -0.454f, 1.26f, -0.403f, 1.194f, -0.324f)
            .cubicTo(1.017f, -0.084f, 1.005f, 0.163f, 1.214f, 0.358f)
            .cubicTo(1.28f, 0.42f, 1.48f, 0.51f, 1.318f, 0.57f)
            .cubicTo(1.208f, 0.516f, 1.083f, 0.46f, 1.008f, 0.385f)
            .cubicTo(0.805f, 0.184f, 0.738f, -0.094f, 0.812f, -0.368f)
            .cubicTo(0.888f, -0.648f, 1.173f, -0.826f, 1.41f, -0.97f)
            .cubicTo(1.38f, -1.141f, 1.345f, -1.306f, 1.291f, -1.552f)
            .cubicTo(1.208f, -1.479f, 1.009f, -1.311f, 0.947f, -1.219f)
            .cubicTo(0.699f, -1.019f, 0.519f, -0.711f, 0.412f, -0.415f)
            .cubicTo(0.385f, -0.251f, 0.396f, -0.082f, 0.405f, 0.08f)
            .cubicTo(0.44f, 0.33f, 0.589f, 0.552f, 0.777f, 0.716f)
            .cubicTo(0.965f, 0.856f, 1.211f, 0.881f, 1.437f, 0.878f)
            .cubicTo(1.504f, 0.873f, 1.652f, 0.852f, 1.718f, 0.836f).close().moveTo(2.322f, 0.23f)
            .cubicTo(2.371f, -0.062f, 2.268f, -0.228f, 2.037f, -0.426f)
            .cubicTo(1.961f, -0.492f, 1.803f, -0.522f, 1.642f, -0.501f)
            .cubicTo(1.719f, -0.065f, 1.814f, 0.367f, 1.889f, 0.803f)
            .cubicTo(2.049f, 0.725f, 2.259f, 0.605f, 2.322f, 0.23f).close().moveTo(1.352f, -2.329f)
            .cubicTo(1.585f, -2.559f, 1.751f, -2.776f, 1.865f, -3f)
            .cubicTo(1.953f, -3.207f, 2.039f, -3.426f, 2.009f, -3.653f)
            .cubicTo(1.991f, -3.74f, 1.973f, -3.902f, 1.868f, -3.92f)
            .cubicTo(1.731f, -3.907f, 1.653f, -3.783f, 1.575f, -3.659f)
            .cubicTo(1.306f, -3.223f, 1.34f, -2.806f, 1.352f, -2.329f).get());

    private static final Paint PAINT = new PaintBuilder().style(Style.FILL).get();
    private static final Path PATH = new Path();
    private static final Matrix MATRIX = new Matrix();
    private final Path path;

    Clef(Path path) {
        this.path = path;
    }

    /**
     * Draw the staff centered on the y axis.
     */
    public void draw(Canvas canvas, float spacing, Paint paint) {
        PAINT.setColor(paint.getColor());
        MATRIX.setScale(spacing, spacing);
        PATH.set(path);
        PATH.transform(MATRIX);
        canvas.drawPath(PATH, PAINT);
    }
}