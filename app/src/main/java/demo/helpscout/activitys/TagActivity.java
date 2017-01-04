package demo.helpscout.activitys;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;
import midgardsystems.library.editTag.EditTag;
import demo.helpscout.R;
/**
 * Created by Gabriel on 04/01/2017.
 */
public class TagActivity  extends AppCompatActivity implements SwitchCompat.OnCheckedChangeListener {

    private EditTag editTagView;

    private SwitchCompat statusSwitchView;

    private List<String> tagStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tags);

        editTagView = (EditTag) findViewById(R.id.edit_tag_view);
        statusSwitchView = (SwitchCompat) findViewById(R.id.status_switch);
        statusSwitchView.setOnCheckedChangeListener(this);

        for (int i = 0; i < 10; i++) {
            tagStrings.add("test" + i);
        }
        editTagView.setTagList(tagStrings);

        editTagView.addTag("hello world!");
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        editTagView.setEditable(isChecked);
    }
}
