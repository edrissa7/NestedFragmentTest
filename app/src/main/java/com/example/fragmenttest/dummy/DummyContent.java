package com.example.fragmenttest.dummy;

import com.example.fragmenttest.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Workout> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Workout> ITEM_MAP = new HashMap<String,Workout>();

    private static final int COUNT = Workout.workouts.length;

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(Workout.workouts[i]);
        }
    }

    private static void addItem(Workout item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getName(), item);
    }


}