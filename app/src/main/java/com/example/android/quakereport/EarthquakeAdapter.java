package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by startupuser on 2017/10/12.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;

        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitude_text = (TextView) listview.findViewById(R.id.magnitude);


        magnitude_text.setText(formatMagnitude(currentEarthquake.getmMagnitude()));

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude_text.getBackground();
        int magnitudeColor = getMagnitutdeColor(currentEarthquake.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        TextView location_text = (TextView) listview.findViewById(R.id.location);
        String loc = currentEarthquake.getmLocation();
        String parts[] = loc.split("of");

        if (loc.indexOf("of") != -1) {
            location_text.setText(parts[0] + "of");
            TextView location2_text = (TextView) listview.findViewById(R.id.location2);
            location2_text.setText(parts[1].substring(1));
        } else {
            TextView location2_text = (TextView) listview.findViewById(R.id.location2);
            location2_text.setText(parts[0]);
        }


        Date dateObject = new Date(currentEarthquake.getmDate());

        TextView date_text = (TextView) listview.findViewById(R.id.date);
        date_text.setText(formatDate(dateObject));

        TextView time_text = (TextView) listview.findViewById(R.id.time);
        time_text.setText(formatTime(dateObject));


        return listview;
    }


    private String formatDate(Date dateObject) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        return dateToDisplay;
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = dateFormatter.format(dateObject);
        return timeToDisplay;
    }

    private String formatMagnitude(double mag) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        String output = formatter.format(mag);
        return output;
    }

    private int getMagnitutdeColor (double magnitude) {
        int magnitudeColor;

        int floor_mag = (int) Math.floor(magnitude);

        switch (floor_mag) {
            case 0:
                magnitudeColor = R.color.magnitude1;
                break;
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            default:
                magnitudeColor = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColor);

    }
}
