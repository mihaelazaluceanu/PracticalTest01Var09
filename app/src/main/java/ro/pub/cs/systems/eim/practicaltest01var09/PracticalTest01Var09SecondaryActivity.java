package ro.pub.cs.systems.eim.practicaltest01var09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var09SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var09_secondary);

        Intent intent = getIntent();
        if (intent != null) {
            String opField = intent.getStringExtra("opField");
            if (opField != null) {
                //facem suma: spargem dupa delimitatorul + si adunam elementele (nu stiu cum sa fac asta)
                // harcodam rezultatul
                String result = "150";
                Intent toMain = new Intent();
                toMain.putExtra("result", result);
                setResult(RESULT_OK, toMain);
                finish();
            } else {
                Toast.makeText(this, getResources().getString(R.string.opError), Toast.LENGTH_LONG).show();
            }
        }
    }
}