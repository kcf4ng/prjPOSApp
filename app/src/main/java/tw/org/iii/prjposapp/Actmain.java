package tw.org.iii.prjposapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

public class Actmain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);


        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.picker);
        final String[] miaoliStation = getResources().getStringArray(R.array.miaoli_station);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(miaoliStation.length - 1);
        numberPicker.setDisplayedValues(miaoliStation);
        numberPicker.setValue(3); // 設定預設位置
        numberPicker.setWrapSelectorWheel(false); // 是否循環顯示
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS); // 不可編輯
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });
    }
}
