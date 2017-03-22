package it.spawn.example.transitionsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;

public class ContentTransitionActivity extends AppCompatActivity {

    private ViewGroup frameLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transition);
        frameLayoutContainer = (ViewGroup) findViewById(R.id.frame_container);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        TransitionSet set = new TransitionSet().addTransition(new Slide()).setDuration(500L);
        TransitionManager.beginDelayedTransition(frameLayoutContainer, set);
        frameLayoutContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }

}
