package com.example.uilove.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.uilove.Domain.PopularDomain;
import com.example.uilove.Helper.ManagmentCart;
import com.example.uilove.R;
import com.example.uilove.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getBundles();
        managmentCart = new ManagmentCart(this);
        statusBarColor();
    }
    private void statusBarColor() {
        Window window=DetailActivity.this.getWindow(); // in Activity's onCreate() for instance
        window.setStatusBarColor(ContextCompat.getColor(DetailActivity.this, R.color.white));

    }

    private void getBundles(){
        object = (PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId).into(binding.itemPic);
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.descriptionTxt.setText(object.getDescription());
        binding.reviewTxt.setText(object.getReview()+"");
        binding.ratingTxt.setText(object.getScore()+"");

       binding.addToCardBtn.setOnClickListener(view -> {
           object.setNumberInCart(numberOrder);
           finish();
           managmentCart.insertFood(object);
       });

       binding.backBtn.setOnClickListener(view -> finish());
    }
}