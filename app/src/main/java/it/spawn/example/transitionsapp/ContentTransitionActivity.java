package it.spawn.example.transitionsapp;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.FrameLayout;

public class ContentTransitionActivity extends Activity {

    private FrameLayout frameLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transition);
        frameLayoutContainer = (FrameLayout) findViewById(R.id.frame_container);

    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        TransitionSet set = new TransitionSet().addTransition(new Slide()).setDuration(3000L);
        TransitionManager.beginDelayedTransition(frameLayoutContainer, set);
        frameLayoutContainer.setVisibility(View.VISIBLE);
    }

}
