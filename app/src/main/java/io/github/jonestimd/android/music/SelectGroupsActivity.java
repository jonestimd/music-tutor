package io.github.jonestimd.android.music;

import io.github.jonestimd.android.quiz.activity.QuestionGroupSelection;
import io.github.jonestimd.android.quiz.activity.StartActivity;

public class SelectGroupsActivity extends StartActivity {
    private MusicGroupSelection selection;

    protected QuestionGroupSelection getGroupSelection() {
        if (selection == null) {
            selection = new MusicGroupSelection(getResources());
        }
        return selection;
    }
}
