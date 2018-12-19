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
        final String[] sugar = getResources().getStringArray(R.array.sugar);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(sugar.length - 1);
        numberPicker.setDisplayedValues(sugar);
        numberPicker.setValue(1); // 設定預設位置
        numberPicker.setWrapSelectorWheel(false); // 是否循環顯示
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS); // 不可編輯
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });

        NumberPicker np2 =(NumberPicker) findViewById(R.id.picker2);
        final String[] ice = getResources().getStringArray(R.array.ice);
        np2.setMinValue(0);
        np2.setMaxValue(ice.length -1);
        np2.setDisplayedValues(ice);
        np2.setValue(1);
        np2.setWrapSelectorWheel(false);
        np2.setDescendantFocusability(np2.FOCUS_BLOCK_DESCENDANTS);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){

            }

        });

        NumberPicker np3 =(NumberPicker) findViewById(R.id.picker3);
        np3.setMinValue(1);
        np3.setMaxValue(99);
        np3.setValue(1);
        np3.setWrapSelectorWheel(false);
        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });









    }
}
