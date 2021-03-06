package app.easylink.healthMonitor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Diagnose extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] fever = {"", "Yes", "No"};
    String[] cough = {"", "Always", "Never", "Oftenly"};
    String[] shortbreath = {"", "Yes", "No"};
    String[] headache = {"", "Always", "Never", "Oftenly"};
    String[] soarthroat = {"", "Yes", "No"};
    String[] chestPain = {"", "Yes", "No"};
    String[] gender = {"", "Mail", "Female"};
    String[] age = {"", "12 to 18", "18 to 24", "24 to 40", "above 40"};

    Button submit;
    boolean fever_check, cought_check, shortbreath_check, headache_check, soarthroat_check, chestPain_check;

    boolean check1, check2, check3, check4, check5, check6;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnose_activity);
        submit = (Button) findViewById(R.id.submit);

        // show it
        //  alertDialog.show();
        // Spinner element
        Spinner spinner_fever = (Spinner) findViewById(R.id.fever);
        Spinner spinner_cough = (Spinner) findViewById(R.id.cough);
        Spinner spinner_shortbreath = (Spinner) findViewById(R.id.breath);
        Spinner spinner_headache = (Spinner) findViewById(R.id.headach);
        Spinner spinner_throat = (Spinner) findViewById(R.id.throat);
        Spinner spinner_pain = (Spinner) findViewById(R.id.chestpain);
        Spinner spinner_gender = (Spinner) findViewById(R.id.spinner_gender);
        Spinner spinner_age = (Spinner) findViewById(R.id.spinner_age);

        // Spinner click listener
        spinner_cough.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("Always")) {
                    // Showing selected spinner item
                    check2 = false;
                    cought_check = true;
                } else if (item.equals("Never")) {
                    check2 = false;
                    cought_check = false;

                } else if (item.equals("Oftenly")) {
                    check2 = false;
                    cought_check = true;

                } else {
                    check2 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_shortbreath.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("Yes")) {
                    // Showing selected spinner item
                    check3 = false;
                    shortbreath_check = true;
                } else if (item.equals("No")) {
                    check3 = false;
                    shortbreath_check = false;
                } else {
                    check3 = true;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_headache.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("Always")) {
                    // Showing selected spinner item
                    check4 = false;
                    headache_check = true;
                } else if (item.equals("Never")) {
                    check4 = false;
                    headache_check = false;
                } else if (item.equals("Oftenly")) {
                    check4 = false;
                    headache_check = true;
                } else {
                    check4 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        spinner_throat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("Yes")) {
                    // Showing selected spinner item
                    check5 = false;
                    soarthroat_check = true;
                } else if (item.equals("No")) {
                    check5 = false;
                    soarthroat_check = false;
                } else {
                    check5 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        spinner_pain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("Yes")) {
                    // Showing selected spinner item
                    check6 = false;
                    chestPain_check = true;
                } else if (item.equals("No")) {
                    check6 = false;
                    chestPain_check = false;
                } else {
                    check6 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_fever.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("Yes")) {
                    // Showing selected spinner item
                    check1 = false;
                    fever_check = true;
                } else if (item.equals("No")) {
                    fever_check = false;
                    check1 = false;
                } else {
                    check1 = true;
                    fever_check = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fever);
        // Creating adapter for spinner
        ArrayAdapter<String> coughAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cough);
        ArrayAdapter<String> breathAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shortbreath);
        ArrayAdapter<String> headachAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, headache);
        ArrayAdapter<String> throatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, soarthroat);
        ArrayAdapter<String> pain = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chestPain);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, age);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);



        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        breathAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        headachAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        throatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spinner_fever.setAdapter(dataAdapter);
        spinner_cough.setAdapter(coughAdapter);
        spinner_shortbreath.setAdapter(breathAdapter);
        spinner_headache.setAdapter(headachAdapter);
        spinner_throat.setAdapter(throatAdapter);
        spinner_pain.setAdapter(pain);
        spinner_age.setAdapter(ageAdapter);
        spinner_gender.setAdapter(genderAdapter);



        dataAdapter.notifyDataSetChanged();
      submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(Diagnose.this);
        if (check1 == true || check2 == true || check3 == true || check4 == true || check5 == true || check6 == true) {
            builder.setTitle("Missing Fields");
            builder.setMessage("For diagnose please select all the field");
            // add the buttons
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, just close
                    // the dialog box and do nothing
                    dialog.cancel();
                }
            });
            builder.setCancelable(true);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();


        }
        else if (fever_check == true) {
            builder.setTitle("There is a possibility that You might be Infected.");
            builder.setMessage("You might be infected with Cronavirus, we suggest you to consult your doctor.");
            // add the buttons
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            builder.setCancelable(false);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Consult Your Doctor"); // Storing string
            editor.commit();


        }
        else if (cought_check == false && fever_check == false && shortbreath_check == false && chestPain_check == false && soarthroat_check == false && headache_check == false) {
            builder.setTitle("The result shows that you are safe.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            // add the buttons     // add the buttons
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.safe);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "No Virus Detected"); // Storing string
            editor.commit();

        }
        else if (cought_check == true && fever_check == true && shortbreath_check == true && chestPain_check == true && soarthroat_check == true && headache_check == true) {
            builder.setTitle("The result Indicates that you might be Infected.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            // add the buttons
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("Virus", "Warning, Infected"); // Storing string
            editor.commit();
        } else if (cought_check == true && fever_check == true && shortbreath_check == true && chestPain_check == true && soarthroat_check == true) {
            builder.setTitle("The result Indicates that you might be Infected.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });



            builder.setIcon(R.drawable.warning);
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Warning, Infected"); // Storing string
            editor.commit();
        } else if (cought_check == true && fever_check == true && shortbreath_check == true && chestPain_check == true) {
            builder.setTitle("The result Indicates that you might be Infected.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            // add the buttons
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Warning, Infected"); // Storing string
            editor.commit();
        }

        else if (cought_check == true && fever_check == true && shortbreath_check == true) {
            builder.setTitle("The result Indicates that you might be Infected.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Warning, Infected"); // Storing string
            editor.commit();
        } else if (cought_check == true && fever_check == true) {
            builder.setTitle("The result Indicates that you might be Infected.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Alert! Cronavirus Symptom"); // Storing string
            editor.commit();
        } else if (cought_check == false && fever_check == false && shortbreath_check == false && chestPain_check == false && soarthroat_check == false) {
            builder.setTitle("The result shows that you are safe.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Diagnose.this.finish();
                }
            });
            builder.setIcon(R.drawable.safe);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "No Virus Detected"); // Storing string
            editor.commit();
        } else if (cought_check == false && fever_check == false && shortbreath_check == false && chestPain_check == false) {
            builder.setTitle("The result shows that you are safe.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.safe);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "No Virus Detected"); // Storing string
            editor.commit();

        } else if (cought_check == false && fever_check == false && shortbreath_check == false) {
            builder.setTitle("The result shows that you are safe.");
            builder.setMessage("Your symptoms does not match the Cronavirus Symptoms, but we suggest you to regularly check with your doctor if you have any problem");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.safe);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "No Virus Detected"); // Storing string
            editor.commit();
        } else if (cought_check == false && fever_check == false && shortbreath_check == true) {
            builder.setTitle("The result shows that You might be Infected.");
            builder.setMessage("There is a possiblity that you might be infected with Cronavirus, we suggest you to consult your doctor.");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Alert! Cronavirus Symptom"); // Storing string
            editor.commit();
        } else if (cought_check == true && fever_check == true) {
            builder.setTitle("You might be infected.");
            builder.setMessage("There is a possiblity that you might be infected with Cronavirus, we suggest you to consult your doctor.");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Alert! Cronavirus Symptom"); // Storing string
            editor.commit();
        } else if (headache_check == true || chestPain_check == true) {
            builder.setTitle("The result shows that You may be Infected.");
            builder.setMessage("There is a possiblity that you might be infected with Cronavirus, we suggest you to consult your doctor.");
            // add the buttons
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
          //  builder.setNegativeButton("Cancel", null);
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Alert! Cronavirus Symptom"); // Storing string
            editor.commit();
        } else if (fever_check == true || shortbreath_check == true) {
            builder.setTitle("The result shows that You may be Infected.");
            builder.setMessage("There is a possiblity that you might be infected with Cronavirus, we suggest you to consult your doctor.");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Alert! Cronavirus Symptom"); // Storing string
            editor.commit();
        }  else {
            builder.setTitle("The result shows that You may be Infected.");
            builder.setMessage("There is a possiblity that you might be infected with Cronavirus, we suggest you to consult your doctor.");
            builder.setCancelable(false);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setIcon(R.drawable.warning);
            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            pref = getApplicationContext().getSharedPreferences("infected", 0); // 0 - for private mode
            editor = pref.edit();
            editor.putString("virus", "Alert! Cronavirus Symptom"); // Storing string
            editor.commit();

        }

    }
});
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        if (item.equals("Yes")) {
            // Showing selected spinner item
            check6 = false;
            fever_check = true;
        } else if (item.equals("No")) {
            check6 = false;
            fever_check = false;
        } else {
            check6 = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}


