package com.map.personalitytest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Result extends AppCompatActivity {
    TextView textView;
    String final_result;
    ImageView iv;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView=findViewById(R.id.textView10);
        button=findViewById(R.id.button20);
        iv=findViewById(R.id.imageView3);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          //Intent i =new Intent()
                                          startActivity(new Intent(getApplicationContext(),PersonalityMenu.class));


                                      }
                                  });

       /*Intent intent = getIntent();
        String [] stringArray = intent.getStringArrayExtra("string-array");

        textView.setText(stringArray[0]+stringArray[1]);*/
                Intent intent = getIntent();
        final_result= intent.getStringExtra("string-array");

        if(final_result.equals("INFP")){
            iv.setImageResource(R.drawable.healerinfp);
            textView.setText("The Healer");

        }
        else if(final_result.equals("INTJ")){
            iv.setImageResource(R.drawable.mastermindintj);
            textView.setText("The MasterMind");

        }
        else if(final_result.equals("INFJ")){
            iv.setImageResource(R.drawable.counselorinfj);
            textView.setText("The Counselor");

        }
        else if(final_result.equals("INTP")){
            iv.setImageResource(R.drawable.architectintp);
            textView.setText("The Architech");

        }
        else if(final_result.equals("ENFP")){
            iv.setImageResource(R.drawable.championenfp);
            textView.setText("The Champion");

        }
        else if(final_result.equals("ENPJ")){
            iv.setImageResource(R.drawable.commanderentj);
            textView.setText("The Commander");

        }
        else if(final_result.equals("ENTP")){
            iv.setImageResource(R.drawable.visionaryentp);
            textView.setText("The Visionary");

        }
        else if(final_result.equals("ENFJ")){
            iv.setImageResource(R.drawable.teacherenfj);
            textView.setText("The Teacher");

        }
        else if(final_result.equals("ISFJ")){
            iv.setImageResource(R.drawable.protectorisfj);
            textView.setText("The Protector");

        }
        else if(final_result.equals("ISFP")){
            iv.setImageResource(R.drawable.composerisfp);
            textView.setText("The Composer");

        }
        else if(final_result.equals("ISTJ")){
            iv.setImageResource(R.drawable.inspectoristj);
            textView.setText("The Inspector");

        }
        else if(final_result.equals("ISTP")){
            iv.setImageResource(R.drawable.craftspersonistp);
            textView.setText("The Craftperson");

        }
        else if(final_result.equals("ESFJ")){
            iv.setImageResource(R.drawable.provideresfj);
            textView.setText("The Provider");

        }
        else if(final_result.equals("ESFP")){
            iv.setImageResource(R.drawable.performeresfp);
            textView.setText("The Performer");

        }
        else if(final_result.equals("ESTJ")){
            iv.setImageResource(R.drawable.supervisorestj);
            textView.setText("The Supervisor");

        }
        else if(final_result.equals("ESTP")){
            iv.setImageResource(R.drawable.dynamoestp);
            textView.setText("The Dynamo");
        }

       /* if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        String result = "";

        if (stringArray.length > 0) {
            StringBuilder sb = new StringBuilder();

            for (String s : stringArray) {
                sb.append(s).append("+");
            }

            result = sb.deleteCharAt(sb.length() - 1).toString();
            final_result=getPythonmodule(result);
           // mbti_dict={0:'ENFJ',1:'ENFP',2:'ENTJ',3:'ENTP',4:'ESFJ',5:'ESFP',6:'ESTJ',7:'ESTP',8:'INFJ',9:'INFP',10:'INTJ',11:'INTP',12:'ISFJ',13:'ISFP',14:'ISFP',15:'ISTP'}

            if(final_result=="INFP"){
                Intent intent2=new Intent(getApplicationContext(),Healer.class);
                startActivity(intent2);
                finish();
            }
            else if(final_result=="INTJ"){
                Intent intent2=new Intent(getApplicationContext(),Mastermind.class);
                startActivity(intent2);
                finish();
            }
            else if(final_result=="INFJ"){
                Intent intent2=new Intent(getApplicationContext(),Counselor.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="INTP"){
                Intent intent2=new Intent(getApplicationContext(),Architect.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ENFP"){
                Intent intent2=new Intent(getApplicationContext(),Champion.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ENPJ"){
                Intent intent2=new Intent(getApplicationContext(),Commander.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ENTP"){
                Intent intent2=new Intent(getApplicationContext(),Visionary.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ENFJ"){
                Intent intent2=new Intent(getApplicationContext(),Teacher.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ISFJ"){
                Intent intent2=new Intent(getApplicationContext(),Protector.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ISFP"){
                Intent intent2=new Intent(getApplicationContext(),Composer.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ISTJ"){
                Intent intent2=new Intent(getApplicationContext(),Inspector.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ISTP"){
                Intent intent2=new Intent(getApplicationContext(),Craftsperson.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ESFJ"){
                Intent intent2=new Intent(getApplicationContext(),Provider.class);
                startActivity(intent2);
                finish();
            }
            else if(final_result=="ESFP"){
                Intent intent2=new Intent(getApplicationContext(),Performer.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ESTJ"){
                Intent intent2=new Intent(getApplicationContext(),Supervisor.class);
                startActivity(intent2);
                finish();
            }else if(final_result=="ESTP"){
                Intent intent2=new Intent(getApplicationContext(),Dynamo.class);
                startActivity(intent2);
                finish();
            }*/
            //textView.setText(getPythonmodule(result));
        }


    private String getPythonmodule(String result) {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("predict");
        return pythonFile.callAttr("predict", result).toString();
    }


}
