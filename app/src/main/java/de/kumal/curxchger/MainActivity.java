package de.kumal.curxchger;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.kumal.curxchger.AdapterClasses.CountryListAdapter;
import de.kumal.curxchger.ModelClasses.Country;

public class MainActivity extends AppCompatActivity {

    private ImageView exchangingCurr, exchangedCurr;
    private ListView countryList;
    private CountryListAdapter countryListAdapter;
    private AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exchangingCurr = findViewById(R.id.ivConvertingCurCountryFlag);
        exchangedCurr = findViewById(R.id.ivConvertedCurCountryFlag);

        exchangingCurr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCountrySelectionList();
            }
        });

        exchangedCurr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCountrySelectionList();
            }
        });
    }

    private void displayCountrySelectionList() {
        //Toast.makeText(this, "Lis of countries to select currency will be displayed.", Toast.LENGTH_SHORT).show();

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View countryListview = inflater.inflate(R.layout.country_list, null);

        countryList = countryListview.findViewById(R.id.lvCountryList);

        countryListAdapter = new CountryListAdapter(getApplicationContext(), getCountryList());
        countryList.setAdapter(countryListAdapter);

        countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView country = view.findViewById(R.id.tvCountryName);
                Toast.makeText(MainActivity.this, country.getText(), Toast.LENGTH_SHORT).show();
                alert.dismiss();
            }
        });

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        alertDialog.setTitle("Select a country")
                .setView(countryListview);

        alert = alertDialog.create();
        alert.show();

    }

    private List<Country> getCountryList() {
        List<Country> countryList = new ArrayList<>();

        String[] countries = getResources().getStringArray(R.array.countries);
        String[] countryAlph2Code = getResources().getStringArray(R.array.country_alpha2codes);
        String[] currenciesCode = getResources().getStringArray(R.array.currency_codes);

        for (int i = 0; i < countries.length; i++) {
            countryList.add(new Country(countries[i], countryAlph2Code[i], currenciesCode[i]));
        }

        return countryList;
    }
}
