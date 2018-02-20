package ir.smrahmadi.mvpexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


import ir.smrahmadi.mvpexample.R;
import ir.smrahmadi.mvpexample.presenter.StudentP;


public class StudentV extends AppCompatActivity implements StudentVI, android.view.View.OnClickListener {


    TextView txtName;
    EditText edtName;

    StudentP presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        presenter = new StudentP(this);




    }

    private void initView(){
        txtName = (TextView) findViewById(R.id.TxtName);
        edtName= (EditText) findViewById(R.id.EdtName);

        findViewById(R.id.BtnSet).setOnClickListener(this);
        findViewById(R.id.BtnShow).setOnClickListener(this);
    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.BtnSet:
                presenter.saveName(edtName.getText().toString());
                break;
            case R.id.BtnShow:
                presenter.loadName();
                break;
        }
    }

    @Override
    public void showName(String Message) {
        txtName.setText(Message);
    }

    @Override
    public void showError(String error) {
        txtName.setText(error);
    }
}

 interface StudentVI {

    void showName(String message);
    void showError(String error);

}
