package com.example.splash;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    DBHelper mDb;
    EditText name,age,date;
    Button b1,b2,b3,b4,b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDb=new DBHelper(this);
        name=(EditText) findViewById(R.id.edname);
        age=(EditText) findViewById(R.id.edage);
        date=(EditText) findViewById(R.id.eddate);
        b1=(Button) findViewById (R.id.bt1);
        b2=(Button) findViewById (R.id.bt2);
        b3=(Button) findViewById (R.id.bt3);
        b4=(Button) findViewById (R.id.bt4);
        b5=(Button) findViewById (R.id.bt5);

        addData();
        updateData();
        deleteData();
        viewData();
        clearData();



    }
    public void addData()
    {
        b1.setOnClickListener(new View.OnClickListener()
        {          @Override
        public void onClick(View v)
        {
            boolean insert=mDb.insertData(name.getText().toString(),age.getText().toString(),date.getText().toString());
        if(insert==true)
            Toast.makeText(HomeActivity.this, "Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(HomeActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();

        }
        });
    }
    public void updateData()
    {
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {                boolean update=mDb.updateData(name.getText().toString(),age.getText().toString(),date.getText().toString());
            if(update==true)
                Toast.makeText(HomeActivity.this,"Data updated",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(HomeActivity.this, "Data not updated",Toast.LENGTH_LONG).show();
            }
        });

        }

        public void deleteData()
        {
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer del = mDb.deleteData(name.getText().toString());
                    if (del > 0)
                        Toast.makeText(HomeActivity.this, "Data deleted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(HomeActivity.this, "Dat not deleted", Toast.LENGTH_LONG).show();
                }
            });
        }

            public void viewData()
            {
                b4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Cursor r=mDb.getAllData();
                    if(r.getCount()==0)
                    {
                        showMessage("Error", "Nothing found");
                    return;
                    }

                    StringBuffer b=new StringBuffer();
                    while(r.moveToNext())
                    {                 b.append("Name"+r.getString(0)+"\n");
                    b.append("name:"+r.getString(1)+"\n");
                    b.append("age:"+r.getString(2)+"\n");
                    b.append("date:"+r.getString(3)+"\n");
                    }

                    showMessage("Student Details",b.toString());

                }
                });
            }
            public void clearData()
            {
                b5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        name.setText("");
                    age.setText("");
                    date.setText("");


                }
                });
            }
    public void showMessage(String title,String mes)
    {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(mes);
        ad.show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {      int id=menuItem.getItemId();
    if(id==R.id.action_settings)
    {
        return true;
    }      return super.onOptionsItemSelected(menuItem);
    }
}






