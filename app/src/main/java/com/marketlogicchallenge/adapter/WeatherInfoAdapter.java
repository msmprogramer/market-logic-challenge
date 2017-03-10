package com.marketlogicchallenge.adapter;

/**
 * Created by msalama on 3/10/17.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marketlogicchallenge.R;
import com.marketlogicchallenge.model.Weather;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class WeatherInfoAdapter
        extends RecyclerView.Adapter<WeatherInfoAdapter.WeatherItemViewHolder> {


    private static final String TAG = "WeatherInfoAdapter";
    private List<Weather> weatherList;
    private Context context;

    public WeatherInfoAdapter(
            Context context,
            List<Weather> weatherList
    ) {
        this.context = context;
        setList(weatherList);
    }

    @Override
    public WeatherItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.weather_item, parent, false);
        WeatherItemViewHolder holder =
                new WeatherItemViewHolder(
                        view
                );

        return holder;
    }

    @Override
    public void onBindViewHolder(
            WeatherItemViewHolder weatherItemViewHolder,
            int position
    ) {

        Weather weatherItem = weatherList.get(position);

        weatherItemViewHolder.weatherDesc.setText(
               weatherItem.getDescription()
        );


        Picasso.with(context).load(String.format(context.getString(R.string.weather_icon_url), weatherItem.getIcon()))
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(weatherItemViewHolder.weatherImage);

    }

    public Weather getItem(int position) {
        return weatherList.get(position);
    }

    public void replaceData(List<Weather> weatherList) {
        setList(weatherList);
        notifyDataSetChanged();
    }

    private void setList(@NonNull List<Weather> weatherList) {
        this.weatherList = checkNotNull(weatherList);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public class WeatherItemViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView weatherImage;
        public TextView  weatherDesc;


        public WeatherItemViewHolder(
                View itemView
        ) {
            super(itemView);

            weatherImage = (ImageView) itemView.findViewById(R.id.weather_image);

            weatherDesc =
                    (TextView) itemView.findViewById(R.id.weather_desc);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: ");
            int position = getAdapterPosition();
            Weather weatherItem = getItem(position);
        }

    }

}
