package kr.ac.kopo.activitytest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rbSecond, rbThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg = findViewById(R.id.rg);
        rbSecond = findViewById(R.id.rb_second);
        rbSecond.setChecked(true); // 처음부터 선택되어 있도록

        Button btnMain = findViewById(R.id.btn_main);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null; // 인텐트 객체 생성
                if(rg.getCheckedRadioButtonId() == R.id.btn_second)
                {
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                }
                else
                {
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                }
                startActivity(intent);
            }
        });

    }
}