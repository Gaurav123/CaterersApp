package com.example.caterersapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.android.material.slider.Slider;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;

public class food extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelFood> foodList;
     SliderLayout sliderLayout;
    private HashMap<String, Integer> sliderImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        recyclerView=findViewById(R.id.recycler);




        foodList=new ArrayList<>();
        foodList.add(new ModelFood(R.drawable.pasta,"Pasta","Italiyan", "190₹"));
        foodList.add(new ModelFood(R.drawable.deserts,"Deserts","Roman","123₹"));
        foodList.add(new ModelFood(R.drawable.icecream,"Icecream","Europe","330₹"));
        foodList.add(new ModelFood(R.drawable.strawberries,"Strawberries","Chinese","110₹"));
        foodList.add(new ModelFood(R.drawable.vegburger,"VegBurger","Indian","250₹"));
        foodList.add(new ModelFood(R.drawable.vegetablesalad,"Vegsalad","US","240₹"));
        foodList.add(new ModelFood(R.drawable.chickenburger,"Chicken Burger","Great Britian","240₹"));
        foodList.add(new ModelFood(R.drawable.frenchtoast,"Pasta","Eastern Europe","30₹"));
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutmanager=layoutManager;
        recyclerView.setLayoutManager(rvlayoutmanager);
        FoodAdapter adapter=new FoodAdapter(this,foodList);
        recyclerView.setAdapter(adapter);

        sliderImages = new HashMap<>();
        //setupSlider();

    }
    private void setupSlider() {
        sliderLayout = (SliderLayout) findViewById(R.id.sliderLayout);
        sliderImages = new HashMap<>();
        sliderImages.put("Chembur's Best", R.drawable.ctrsimg1);
        sliderImages.put("Kurla's Best",R.drawable.ctrsimg2);
        sliderImages.put("Ghatkopers's Best", R.drawable.ctrsimg3);
        sliderImages.put("Andheri's Best",R.drawable.ctrsimg4);
        sliderImages.put("Goregao's Best", R.drawable.ctrs1);

        for (String name : sliderImages.keySet()) {

            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(sliderImages.get(name))
                    //.setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener((BaseSliderView.OnSliderClickListener) this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);

    }
}