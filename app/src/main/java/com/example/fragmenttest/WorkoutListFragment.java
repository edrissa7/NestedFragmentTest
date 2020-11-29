package com.example.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.fragmenttest.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class WorkoutListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkoutListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static WorkoutListFragment newInstance(int columnCount) {
        WorkoutListFragment fragment = new WorkoutListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            MyWorkoutRecyclerViewAdapter workoutRecyclerViewAdapter = new MyWorkoutRecyclerViewAdapter(DummyContent.ITEMS);
            workoutRecyclerViewAdapter.setOnItemClickListener(new MyWorkoutRecyclerViewAdapter.OnItemClickListener() {
                @Override
                public void OnItemClicked(int position) {
                  WorkoutDetailFragment workoutDetailFragment  = new WorkoutDetailFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    workoutDetailFragment.setWorkout(position);
                    ft.replace(R.id.detailFragment,workoutDetailFragment);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    Log.e("Log","Clicked");
                }
            });
            recyclerView.setAdapter(workoutRecyclerViewAdapter);
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }


}