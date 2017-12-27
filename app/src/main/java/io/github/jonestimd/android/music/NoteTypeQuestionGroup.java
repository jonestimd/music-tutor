package io.github.jonestimd.android.music;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.jonestimd.android.quiz.activity.AnswerType;
import io.github.jonestimd.android.quiz.activity.QuestionGroup;
import io.github.jonestimd.android.quiz.activity.QuestionImage;
import io.github.jonestimd.android.quiz.activity.ReviewAdapter;
import io.github.jonestimd.android.quiz.view.QuestionImageView;

public class NoteTypeQuestionGroup implements QuestionGroup {
    private final List<Note> questions;
    private final List<String> answers;
    private final String hint;

    public NoteTypeQuestionGroup(Resources resources) {
        questions = new ArrayList<>(Duration.values().length);
        answers = new ArrayList<>(Duration.values().length);
        for (Duration duration : Duration.values()) {
            questions.add(new Note(resources, 1, duration));
            answers.add(resources.getString(R.string.note_duration, resources.getString(duration.resourceId())));
        }
        hint = resources.getString(R.string.note_type_hint);
    }

    public int getQuestionKey() {
        return R.string.note_type_question;
    }

    public boolean isGraphic() {
        return true;
    }

    public QuestionImage getGraphic(int index) {
        return questions.get(index).getImage();
    }

    public AnswerType getAnswerType() {
        return AnswerType.MULTIPLE_CHOICE;
    }

    public List<String> getAvailableAnswers() {
        return new ArrayList<>(answers);
    }

    public String getAnswer(int index) {
        return answers.get(index);
    }

    public int getQuestionCount() {
        return questions.size();
    }

    public boolean hasHint(int index) {
        return true;
    }

    public String getHint( int index) {
        return hint;
    }

    @Override
    public ListAdapter getReviewItems(Context context) {
        return new NoteReviewAdapter(context);
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

    public class NoteReviewAdapter extends ReviewAdapter {
        public NoteReviewAdapter(Context context) {
            super(context, R.layout.note_type_review);
        }

        @Override
        public int getCount() {
            return questions.size();
        }

        @Override
        public Object getItem(int position) {
            return questions.get(position);
        }

        @Override
        protected void bindView(int position, View view) {
            QuestionImageView imageView = (QuestionImageView) view.findViewById(R.id.note_image);
            imageView.setQuestionImage(getGraphic(position));
            bindText(view, R.id.note_type, answers.get(position));
        }

        private void bindText(View view, int textViewId, String text) {
            TextView textView = (TextView) view.findViewById(textViewId);
            textView.setText(Html.fromHtml(text));
        }
    }
}
