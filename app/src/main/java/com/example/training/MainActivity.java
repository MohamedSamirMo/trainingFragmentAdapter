package com.example.training;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.training.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager(),getLifecycle());
    ArrayList<ModelFragment> list=new ArrayList<>();
    ArrayList<ModelContact>fragment= new ArrayList<>();
    AdapterContact AdapterContact=new AdapterContact();
    ArrayList<ModelContact>ListContact=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragments(new HomeFragment(),false);
        }

        });
        binding.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragments(new ChatFragment(),true);
            }
    });}
    private void replaceFragments(Fragment fragment , boolean addToStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment, "tag");
        if (addToStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        list.add(new ModelFragment(new HomeFragment(),"Home"));
        list.add(new ModelFragment(new ChatFragment(),"Chat"));
        myAdapter.setFragments(list);
        binding.pager.setAdapter(myAdapter);
        new TabLayoutMediator(binding.tablayout,binding.pager,new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText(list.get(position).getTitle());
            }
        }).attach();


        ListContact.add(new ModelContact("Mohamed","01124440330"));
        ListContact.add(new ModelContact("magdy","01103334445"));
        ListContact.add(new ModelContact("Mohamed","0101234546"));
        ListContact.add(new ModelContact("eslam","01012203303"));
        ListContact.add(new ModelContact("youtrfgh","0129203333"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));
        ListContact.add(new ModelContact("yousef","01124440330"));

        AdapterContact.setList(ListContact);
        binding.recycler.setAdapter(AdapterContact);

    }

}