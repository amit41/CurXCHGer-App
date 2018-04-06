package de.kumal.curxchger.AdapterClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.kumal.curxchger.ModelClasses.Country;
import de.kumal.curxchger.R;

/**
 * Created by Amit on 2018-04-06.
 */

public class CountryListAdapter extends ArrayAdapter<Country> {

    private List<Country> countries;
    private Context context;
    private LayoutInflater inflater;

    public CountryListAdapter(@NonNull Context context, @NonNull List<Country> countries) {
        super(context, R.layout.country_list);
        this.context = context;
        this.countries = countries;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.single_country_item_layout, null);

            viewHolder = new ViewHolder();
            viewHolder.countryName = view.findViewById(R.id.tvCountryName);
            viewHolder.currencyCode = view.findViewById(R.id.tvCurrencyCode);
            viewHolder.flag = view.findViewById(R.id.ivFlag);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Country country = getItem(position);

        viewHolder.countryName.setText(country.getCountryname());
        viewHolder.currencyCode.setText(country.getCurrencyCode());
        viewHolder.flag.setImageResource(getImage(country.getCountryAlpha2Code()));

        return view;
    }

    private int getImage(String countryAlpha2Code) {
        int image = 0;
        switch (countryAlpha2Code) {
            case "de":
                image = R.drawable.de;
                break;
            case "np":
                image = R.drawable.np;
                break;
            case "us":
                image = R.drawable.us;
                break;
            case "gb":
                image = R.drawable.gb;
                break;
        }
        return image;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Nullable
    @Override
    public Country getItem(int position) {
        return countries.get(position);
    }

    private static class ViewHolder {
        private TextView countryName;
        private TextView currencyCode;
        private ImageView flag;
    }
}
