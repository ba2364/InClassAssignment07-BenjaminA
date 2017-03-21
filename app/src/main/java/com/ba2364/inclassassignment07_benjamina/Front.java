package com.ba2364.inclassassignment07_benjamina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Front extends AppCompatActivity
{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference titleRef = database.getReference("title");
    private DatabaseReference teamRef = database.getReference("team");
    private TextView title;
    private TextView city;
    private TextView nickname;
    private TextView champs;
    private CheckBox playing;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        title = (TextView) findViewById(R.id.titleview);
        city = (TextView) findViewById(R.id.cityName);
        nickname = (TextView) findViewById(R.id.nickname);
        champs = (TextView) findViewById(R.id.champs);
        playing = (CheckBox) findViewById(R.id.playing);
    }

    public void setTitle(View view)
    {
        titleRef.setValue(title.getText().toString());
    }

    public void addTeam(View view)
    {
        String cityName = city.getText().toString();
        String nick = nickname.getText().toString();
        int champy = Integer.parseInt(champs.getText().toString());
        boolean play=((CheckBox) findViewById(R.id.playing)).isChecked();
        teamRef.push().setValue(new Team(cityName,nick,champy,play));
    }
}