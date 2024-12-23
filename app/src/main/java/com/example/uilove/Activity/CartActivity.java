package com.example.uilove.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.uilove.Adapter.CartAdapter;
import com.example.uilove.Helper.ChangeNumberItemsListener;
import com.example.uilove.Helper.ManagmentCart;
import com.example.uilove.R;
import com.example.uilove.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    private ManagmentCart managementCart;
    ActivityCartBinding binding;
    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
        initlist();
    }

    private void initlist() {
        if(managementCart.getListCart() .isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scroll.setVisibility(View.GONE);
        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scroll.setVisibility(View.VISIBLE);
        }
        binding.cartView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.cartView.setAdapter(new CartAdapter(managementCart.getListCart(), () -> calculatorCart()));

    }

    private void calculatorCart(){
        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round(managementCart.getTotalFee() * percentTax * 100)/100;

        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100)/100;
        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTxt.setText("$"+tax);
        binding.deliveryTxt.setText("$"+delivery);
        binding.totalTxt.setText("$"+total);

    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}