package com.example.siddprakash.camerarenderer;

import android.content.Context;
import android.opengl.GLES20;

/**
 * Created by siddPrakash on 1/26/18.
 */

class OriginalFrame extends DrawFrame{
    private int program;

    public OriginalFrame(Context context) {
        super(context);

        // Build shaders
        program = MyGLUtils.buildProgram(context, R.raw.vertext, R.raw.original);
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId},
                new int[][]{});
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
    }
}
