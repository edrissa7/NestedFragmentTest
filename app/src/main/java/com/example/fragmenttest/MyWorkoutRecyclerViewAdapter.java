package com.example.fragmenttest;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyWorkoutRecyclerViewAdapter extends RecyclerView.Adapter<MyWorkoutRecyclerViewAdapter.ViewHolder> {

    private OnItemClickListener listener;

    private final List<Workout> mValues;
    static interface OnItemClickListener{
        void OnItemClicked(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    public MyWorkoutRecyclerViewAdapter(List<Workout> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_workout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getName());

    }




    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public Workout mItem;

        private MyWorkoutRecyclerViewAdapter recyclerViewAdapter;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                if(listener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listener.OnItemClicked(position);
                    }
                }

                }
            });
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}