package com.example.enviodeemails;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView tv_email, tv_asunto, tv_mensaje;
    EditText et_email, et_asunto, et_mensaje;
    CheckBox click;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_email = findViewById(R.id.tv_email);
        tv_asunto = findViewById(R.id.tv_asunto);
        tv_mensaje = findViewById(R.id.tv_mensaje);
        et_email = findViewById(R.id.et_email);
        et_asunto = findViewById(R.id.et_asunto);
        et_mensaje = findViewById(R.id.et_mensaje);
        click = findViewById(R.id.click);
        button = findViewById(R.id.click);

        return button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent itSend = new Intent(Intent.ACTION_SEND);
                itSend.setType("plain/text");

                itSend.putExtra(Intent.EXTRA_EMAIL, new String[]{et_email.getText().toString()});
                itSend.putExtra(Intent.EXTRA_SUBJECT, et_asunto.getText().toString());
                itSend.putExtra(Intent.EXTRA_TEXT, et_mensaje.getText().toString());
                itSend.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.ic_launcher_background));
                itSend.setType("image/png");
                boolean checked = click.isChecked();

                itSend.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.ic_launcher_background));
                itSend.setType("image/png");

                startActivity(itSend);
            }

        }

    }
}




