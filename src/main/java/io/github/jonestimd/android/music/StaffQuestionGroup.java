package io.github.jonestimd.android.music;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.jonestimd.android.quiz.activity.AnswerType;
import io.github.jonestimd.android.quiz.activity.QuestionGroup;
import io.github.jonestimd.android.quiz.activity.QuestionImage;
import io.github.jonestimd.android.quiz.activity.ReviewAdapter;
import io.github.jonestimd.android.quiz.view.QuestionImageView;

public class StaffQuestionGroup implements QuestionGroup {
    private final List<Note> notes = new ArrayList<>(Duration.values().length);
    private final Map<Integer, String> noteNames = new HashMap<>();
    private final String trebleLineHint;
    private final String trebleSpaceHint;
    private final String bassLineHint;
    private final String bassSpaceHint;
    private final String[] reviewHints;

    public StaffQuestionGroup(Resources resources, Staff staff) {
        for (NoteName noteName : NoteName.values()) {
            noteNames.put(noteName.resourceId(), resources.getString(noteName.resourceId()));
        }
        for (int offset = -8; offset <= 8; offset++) {
            notes.add(new Note(resources, staff, offset, Duration.QUARTER));
        }
        trebleLineHint = resources.getString(R.string.treble_line_hint);
        trebleSpaceHint = resources.getString(R.string.treble_space_hint);
        bassLineHint = resources.getString(R.string.bass_line_hint);
        bassSpaceHint = resources.getString(R.string.bass_space_hint);
        reviewHints = resources.getStringArray(staff.reviewHintsId);
    }

    public int getQuestionKey() {
        return R.string.note_name_question;
    }

    public boolean isGraphic() {
        return true;
    }

    public QuestionImage getGraphic(int index) {
        return notes.get(index).getImage();
    }

    public AnswerType getAnswerType() {
        return AnswerType.MULTIPLE_CHOICE;
    }

    public List<String> getAvailableAnswers() {
        return new ArrayList<>(noteNames.values());
    }

    public String getAnswer(int index) {
        return noteNames.get(notes.get(index).getName().resourceId());
    }

    public int getQuestionCount() {
        return notes.size();
    }

    public boolean hasHint(int index) {
        return true;
    }

    public String getHint(int index) {
        Note note = notes.get(index);
        if (note.getStaff() == Staff.TREBLE) {
            return note.getCenterOffset() % 2 == 0 ? trebleLineHint : trebleSpaceHint;
        }
        return note.getCenterOffset() % 2 == 0 ? bassLineHint : bassSpaceHint;
    }

    @Override
    public ListAdapter getReviewItems(Context context) {
        return new StaffReviewAdapter(context);
    }

    @Override
    public void onReviewItemClick(Context context, int position) {
    }

    @Override
    public void answerSelected(Context context, String answer) {
    }

    @Override
    public void answered(Context context, boolean correct, int questionIndex) {
    }

    public class StaffReviewAdapter extends ReviewAdapter {
        public StaffReviewAdapter(Context context) {
            super(context, R.layout.staff_review);
        }

        @Override
        public int getCount() {
            return notes.size();
        }

        @Override
        public Object getItem(int position) {
            return notes.get(position);
        }

        @Override
        protected void bindView(int position, View view) {
            QuestionImageView imageView = (QuestionImageView) view.findViewById(R.id.staff_image_view);
            imageView.setQuestionImage(getGraphic(position));
            bindText(view, R.id.note_name, getAnswer(position));
            bindText(view, R.id.note_name_hint, reviewHints[position]);
        }

        private void bindText(View view, int textViewId, String text) {
            TextView textView = (TextView) view.findViewById(textViewId);
            textView.setText(Html.fromHtml(text));
        }
    }
}
