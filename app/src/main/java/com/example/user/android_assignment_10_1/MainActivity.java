package com.example.user.android_assignment_10_1;
//Package objects contain version information about the implementation and specification of a Java package.
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.

    BlankFragment blankFragment;
    EditText editText;
    Button button;
    //Intializing the variables

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.

    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
//So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design
        blankFragment = new BlankFragment();
        //creating new object
        editText = findViewById(R.id.editText);
        //giving edit text and it will find the text from activity what ur giving.

        android.app.FragmentManager manager = getFragmentManager();
        //we are using FragmentManager that help us to handle  Android fragment trasaction between fragments.
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        //for adding the fragments dynamically.
        transaction.add(R.id.frameLayout,blankFragment);
        //adding the layout to fragment.
        transaction.commit();
        //it will finish of adding.
        button = findViewById(R.id.button);
        //it will find the button as we created in the activity
        button.setOnClickListener(new View.OnClickListener() {
            //we use set on click listner method because if we click on event then listener then the method is called.
            @Override
            public void onClick(View view) {
                //we use onclick to invoke the button
                blankFragment.sendData(editText.getText().toString());
                //we are giving the method of send data for getting the text which are given in string
            }
        });
    }
    public interface DataListener{
        //it will act as interface between the fragment and activity.
        void sendData(String data);
        //created the method.
    }
}