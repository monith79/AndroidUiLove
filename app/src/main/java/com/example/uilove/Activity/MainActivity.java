package com.example.uilove.Activity;

import android.os.Bundle;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.uilove.Adapter.PopularAdapter;
import com.example.uilove.Domain.PopularDomain;
import com.example.uilove.R;
import com.example.uilove.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        statusBarColor();
        initRecyclerView();
    }

    private void statusBarColor() {
        Window window=MainActivity.this.getWindow(); // in Activity's onCreate() for instance
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_Light));

    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-shirt black","item_1",15,4,500,"Immerse yourself in a world of vibrant images and amazing sound with monitors. " +
                "Its state-of-the-art monitor technology brings every aspect with clarity and rich colors.\n" +
                "With seamless integration and stylish design, the Pro Monitor is not only a monitor, but a focal point for your entertainment venue.\n" +
                "With its sleek and sleek design, the monitor is not only the TV but also the centerpiece of your entertainment space.\n" +
                "The thinnest edges and high-grade finish blend seamlessly with any decor."));
        items.add(new PopularDomain("Smart Watch","item_2",10,4.5,450,"Immerse yourself in a world of vibrant images and amazing sound with monitors. " +
                "Its state-of-the-art monitor technology brings every aspect with clarity and rich colors.\n" +
                "With seamless integration and stylish design, the Pro Monitor is not only a monitor, but a focal point for your entertainment venue.\n" +
                "With its sleek and sleek design, the monitor is not only the TV but also the centerpiece of your entertainment space.\n" +
                "The thinnest edges and high-grade finish blend seamlessly with any decor."));
        items.add(new PopularDomain("Phone","item_3",3,4.9,800,"Immerse yourself in a world of vibrant images and amazing sound with monitors. " +
                "Its state-of-the-art monitor technology brings every aspect with clarity and rich colors.\n" +
                "With seamless integration and stylish design, the Pro Monitor is not only a monitor, but a focal point for your entertainment venue.\n" +
                "With its sleek and sleek design, the monitor is not only the TV but also the centerpiece of your entertainment space.\n" +
                "The thinnest edges and high-grade finish blend seamlessly with any decor."));
        items.add(new PopularDomain("Phone","item_4",3,4.9,800,"Immerse yourself in a world of vibrant images and amazing sound with monitors. " +
                "Its state-of-the-art monitor technology brings every aspect with clarity and rich colors.\n" +
                "With seamless integration and stylish design, the Pro Monitor is not only a monitor, but a focal point for your entertainment venue.\n" +
                "With its sleek and sleek design, the monitor is not only the TV but also the centerpiece of your entertainment space.\n" +
                "The thinnest edges and high-grade finish blend seamlessly with any decor."));
    binding.PopularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    binding.PopularView.setAdapter(new PopularAdapter(items));

    }
}