package mdev.project.gameon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookingScreenAdapter extends ArrayAdapter<BookingScreenDataModel> {

    // constructor for our list view adapter.
    public BookingScreenAdapter(@NonNull Context context, ArrayList<BookingScreenDataModel> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.booking_screen_gv_item, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        BookingScreenDataModel dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView name = listitemView.findViewById(R.id.courtName);
        TextView court_state = listitemView.findViewById(R.id.courtState);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        name.setText(dataModal.getName());
        court_state.setText(dataModal.getState());

        // in below line we are using Picasso to load image
        // from URL in our Image VIew

        // below line is use to add item
        // click listener for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Intent i = new Intent(getContext(),CourtDetails.class);
                i.putExtra("Name", dataModal.getName());
                i.putExtra("About", dataModal.getAbout());
                i.putExtra("State", dataModal.getState());
                i.putExtra("Price", dataModal.getPrice());
                getContext().startActivity(i);


            }
        });
        return listitemView;
    }
}

