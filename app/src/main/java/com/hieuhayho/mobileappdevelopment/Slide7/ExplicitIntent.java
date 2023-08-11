package com.hieuhayho.mobileappdevelopment.Slide7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hieuhayho.mobileappdevelopment.R;

public class ExplicitIntent extends AppCompatActivity {

    private Button buttonSendMessage;
    private EditText feedbackInput;
    private TextView feedbackOutput;

    private int MY_REQUEST_CODE = 11112001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        buttonSendMessage = (Button)this.findViewById((R.id.SendFeedbackButton));
        feedbackInput = (EditText)this.findViewById(R.id.FullNameInput);
        feedbackOutput = (TextView)this.findViewById((R.id.FeedbackOutput));

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMessage();
            }

        });
    }


    public void SendMessage() {
        String fullName = this.feedbackInput.getText().toString();
        String message = "Hello, please say hello me.";

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("FullName", fullName);
        intent.putExtra("Message", message);

        //startActivity(intent);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
            String feedback = data.getStringExtra("Feedback");
            feedbackOutput.setText(feedback);
        } else {
            feedbackOutput.setText("????");
        }
    }
}