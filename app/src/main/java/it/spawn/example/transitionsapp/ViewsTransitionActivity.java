package it.spawn.example.transitionsapp;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class ViewsTransitionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_transition);

        final View boxOne = findViewById(R.id.box_one);
        final View boxTwo = findViewById(R.id.box_two);
        final View boxThree = findViewById(R.id.box_three);
        final View boxFour = findViewById(R.id.box_four);

        final ViewGroup viewsContainer = (ViewGroup) findViewById(R.id.views_container);
        viewsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(viewsContainer, new Slide());
                setViewsVisibility(boxOne, boxTwo, boxThree, boxFour);
            }
        });

        viewsContainer.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                TransitionManager.beginDelayedTransition(viewsContainer, new Explode());
                setViewsVisibility(boxOne, boxTwo, boxThree, boxFour);
                return true;
            }
        } );

    }

    private void setViewsVisibility(View... views) {
        for (View view : views) {
            view.setVisibility((view.getVisibility() == View.VISIBLE) ? View.INVISIBLE : View.VISIBLE);
        }
    }
}
