package ro.pub.cs.systems.eim.practicaltest01var09;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var09_main);

        Button addBtn = findViewById(R.id.add);
        EditText editText = findViewById(R.id.nextTerm);
        TextView textView = findViewById(R.id.textView);

        final String[] finalOp = {null};
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                    if (!editText.getText().isEmpty()) {
                        String digit = editText.getText().toString();
                        if (!textView.getText().equals("")) {
                            String textDigit = textView.getText().toString() + '+' + digit;
                            textView.setText(textDigit);
                        } else {
                            textView.setText(digit);
                        }
                    }
                }
            }
        });

        Button compute = findViewById(R.id.compute);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textView.getText().equals("")) {
                    Intent intent = new Intent(MainActivity.this, PracticalTest01Var09SecondaryActivity.class);
                    intent.putExtra("opField", textView.getText().toString());
                    startActivityForResult(intent, 200);
                } else {
                    Toast.makeText(getApplication(), getResources().getString(R.string.opError), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch(requestCode) {
            case 200:
                if (resultCode == Activity.RESULT_OK) {
                    String result = intent.getStringExtra("result");
//                    int intRes = (Integer)result;
                    Log.d("result", result);
//
//                    if (intRes > 10) {
//                        Intent servIntent = new Intent(this, ParcticalTest01Var09Service.class);
//                        servIntent.putExtra("sum", intRes);
//                        startService(intent);
//                    }
                }

        }
    }
}
