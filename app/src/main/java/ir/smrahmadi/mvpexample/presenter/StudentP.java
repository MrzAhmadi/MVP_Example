package ir.smrahmadi.mvpexample.presenter;

import ir.smrahmadi.mvpexample.model.StudentM;
import ir.smrahmadi.mvpexample.view.StudentV;

/**
 * Created by cloner on 2/20/18.
 */

public class StudentP implements StudentPI {

    private StudentM model;
    private StudentV view;

    public StudentP(StudentV view){

        this.model=new StudentM();
        this.view=view;

    }


    @Override
    public void loadName() {

        if(model.getName()==null)
            view.showError("Err : Name not Exist");
        else
            view.showName(model.getName());
    }

    @Override
    public void saveName(String name) {
        model.setName(name);
    }
}

interface StudentPI {
    void loadName();
    void saveName(String name);
}
