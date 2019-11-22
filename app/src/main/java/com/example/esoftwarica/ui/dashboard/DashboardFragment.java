package com.example.esoftwarica.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.Model.Students;
import com.example.esoftwarica.R;
import com.example.esoftwarica.display_activity;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private TextView name, age, address;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnSave;
    List<Students> listStudent;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);

        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        name = root.findViewById(R.id.etName);
        age = root.findViewById(R.id.etAge);
        address = root.findViewById(R.id.etAddress);
        radioGroup = root.findViewById(R.id.rgGender);
        btnSave = root.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radio = radioGroup.getCheckedRadioButtonId();
                radioButton = root.findViewById(radio);

                listStudent = display_activity.StudentList;

                int setImage = R.drawable.male;

                if(radioButton.getText().toString().equals("Female"))
                    setImage = R.drawable.female;
                else if(radioButton.getText().toString().equals("Others"))
                    setImage = R.drawable.others;

                Students stud = new Students(name.getText().toString(),
                        address.getText().toString(),
                        radioButton.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        setImage);

                listStudent.add(stud);
                Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}