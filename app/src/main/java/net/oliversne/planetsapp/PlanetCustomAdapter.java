package net.oliversne.planetsapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PlanetCustomAdapter extends ArrayAdapter<Planet> {

    //Using Custom Layouts --> MyCustomAdapter
    //Using Custom Objects --> extends ArrayAdapter<Planet>
    private ArrayList<Planet> planetsArrayList;
    Context context;

    //Constructor
    public PlanetCustomAdapter(ArrayList<Planet> planetsArrayList, Context context){
        super(context, R.layout.items_lists_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }

    //ViewHolder Class
    private static class ViewHolder{
        ImageView planetImage;
        TextView planetName, moonCount;
    }

    //getView()
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get the planet object ofr the current position
        Planet planet = getItem(position);

        //Inflate Layout
        ViewHolder viewHolder;
        final View result;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.items_lists_layout, parent,false);

            //Finding Views
            viewHolder.planetName = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.moonCount = (TextView) convertView.findViewById(R.id.textView2);
            viewHolder.planetImage = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(viewHolder);

        }else{
            //the view is recycled
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Getting the data from model class (Planet)
        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(planet.getMoonCount());
        viewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }
}
