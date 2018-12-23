package tw.org.iii.prjposapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Actmain extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }


    String strMsg = "";
    Integer total_price =0;
    String  strTotal_price="";

    private  View.OnClickListener btn_clear =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);

            np1.setValue(1);
            np2.setValue(1);
            np3.setValue(1);

            lblList.setText("");

            strMsg = "";
            total_price =0;
            strTotal_price="";

        }
    };



    private View.OnClickListener btn_confirm = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            Integer intPrice = 0;

            if ((btn1.isEnabled() == true) && (btn2.isEnabled() == true) &&(btn3.isEnabled()==true))
            {
                    new AlertDialog.Builder(Actmain.this)
                            .setTitle("警告提示")
                            .setIcon(R.drawable.warning)
                            .setMessage("請點選至少一項商品。")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }
                            )
                            .show();


            }else
                {
             if(btn1.isEnabled() == false){
                 strMsg += "★紅茶\n";
                 intPrice =25;
             }else if (btn2.isEnabled() == false){
                 strMsg += "★抹茶\n";
                 intPrice =35;
             }else if (btn3.isEnabled() == false){
                 strMsg +="★奶茶\n";
                 intPrice =45;
             }

                String[] arySugar = getResources().getStringArray(R.array.sugar);
                String[] aryIce = getResources().getStringArray(R.array.ice);

                Integer sugar_index = np1.getValue();
                Integer ice_index =np2.getValue();


                strMsg += "**"+arySugar[sugar_index]+" ";
                strMsg += "**" + aryIce[ice_index] +" ";
                strMsg += "**" + np3.getValue() + "杯\n";
                strMsg += "小計 : " + intPrice*(np3.getValue()) +"元\n";
                lblList.setText(strMsg);


                total_price += intPrice*(np3.getValue());

                strTotal_price = "總計消費金額 : " + total_price.toString();
            }

        }
    };



    private View.OnClickListener btn_cash = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn結帳){
                new AlertDialog.Builder(Actmain.this)
                        .setTitle("總計金額")
                        .setIcon(R.drawable.coins)
                        .setMessage(strTotal_price)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                       dialog.dismiss();
                                    }
                                }
                        )
                        .show();
            }


        }
    };






    private void InitialComponent() {
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        np1 = findViewById(R.id.picker);
        np2 = findViewById(R.id.picker2);
        np3 = findViewById(R.id.picker3);

        final String[] sugar = getResources().getStringArray(R.array.sugar);
        np1.setMinValue(0);
        np1.setMaxValue(sugar.length - 1);
        np1.setDisplayedValues(sugar);
        np1.setValue(1); // 設定預設位置
        np1.setWrapSelectorWheel(false); // 是否循環顯示
        np1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS); // 不可編輯
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });


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


        np3.setMinValue(1);
        np3.setMaxValue(99);
        np3.setValue(1);
        np3.setWrapSelectorWheel(false);
        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });


        btn確認 = findViewById(R.id.btn確認);
        btn確認.setOnClickListener(btn_confirm);

        lblList = findViewById(R.id.lblList);

        btn結帳 = findViewById(R.id.btn結帳);
        btn結帳.setOnClickListener(btn_cash);

        btn作廢 = findViewById(R.id.btn作廢);
        btn作廢.setOnClickListener(btn_clear);

    }

    Button btn1,btn2,btn3,btn確認,btn結帳,btn作廢;
    NumberPicker np1,np2,np3;
    TextView lblList;





    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn1:
                btn1.setEnabled(false);
                btn2.setEnabled(true);
                btn3.setEnabled(true);

                break;
            case R.id.btn2:
                btn2.setEnabled(false);
                btn1.setEnabled(true);
                btn3.setEnabled(true);

                break;
            case R.id.btn3:
                btn3.setEnabled(false);
                btn2.setEnabled(true);
                btn1.setEnabled(true);

                break;
            default:
                break;
        }

    }



}
