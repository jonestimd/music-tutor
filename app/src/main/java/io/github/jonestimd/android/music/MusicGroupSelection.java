package io.github.jonestimd.android.music;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.jonestimd.android.quiz.activity.QuestionGroup;
import io.github.jonestimd.android.quiz.activity.QuestionGroupSelection;

//TODO rest questions
//TODO major key questions
//TODO timing questions
//TODO settings - staff/note size
public class MusicGroupSelection extends QuestionGroupSelection {
    public enum Type {
        NoteType(R.string.note_type_section),
        TrebleNote(R.string.treble_clef_section),
        BassNote(R.string.bass_clef_section);

        private final int resourceId;

        Type(int resourceId) {
            this.resourceId = resourceId;
        }
    }

    private final List<String> sectionNames;
    private final List<QuestionGroup> questionGroups;

    public MusicGroupSelection(Resources resources) {
        super(Type.values().length);
        sectionNames = new ArrayList<>(Type.values().length);
        for (Type type : Type.values()) {
            sectionNames.add(resources.getString(type.resourceId));
        }
        questionGroups = Arrays.asList(
                new NoteTypeQuestionGroup(resources),
                new StaffQuestionGroup(resources, Staff.TREBLE),
                new StaffQuestionGroup(resources, Staff.BASS)
        );
    }

    public List<String> getSections() {
        return new ArrayList<>(sectionNames);
    }

    protected QuestionGroup getGroup(int index) {
        return questionGroups.get(index);
    }
}
